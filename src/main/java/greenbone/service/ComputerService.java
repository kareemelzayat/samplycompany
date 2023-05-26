package greenbone.service;

import greenbone.domain.Computer;
import greenbone.repository.ComputerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerService {

    private final AdminNotificationService adminNotificationService;
    private final ComputerRepository computerRepository;

    public ComputerService(AdminNotificationService adminNotificationService, ComputerRepository computerRepository) {
        this.adminNotificationService = adminNotificationService;
        this.computerRepository = computerRepository;
    }

    public Page<Computer> getAllComputers(Pageable pageable) {
        return computerRepository.findAll(pageable);
    }

    public List<Computer> getAllComputersForEmployee(String employeeAbbreviation) {
        return computerRepository.findAllByEmployeeAbbreviation(employeeAbbreviation);
    }

    public Computer getComputer(Long id) {
        return computerRepository.findById(id).orElse(null);
    }

    public Computer getComputerForEmployee(Long id, String employeeAbbreviation) {
        return computerRepository.findByIdAndEmployeeAbbreviation(id, employeeAbbreviation).orElse(null);
    }

    public Computer create(Computer newComputer) {
        notifyAdmin(newComputer.getEmployeeAbbreviation());
        return computerRepository.save(newComputer);
    }

    public Computer update(Long id, Computer computer) {
        Computer existingComputer = computerRepository.findById(id).orElse(null);
        if (existingComputer == null) {
            return null;
        }
        computer.setId(existingComputer.getId());
        notifyAdmin(computer.getEmployeeAbbreviation());
        return computerRepository.save(computer);
    }

    public void delete(Long id) {
        computerRepository.deleteById(id);
    }

    public void unassignFromEmployee(Long id, String employeeAbbreviation) {
        Computer computer = computerRepository.findByIdAndEmployeeAbbreviation(id, employeeAbbreviation).orElse(null);
        if (computer == null) {
            return;
        }
        computer.setEmployeeAbbreviation(null);
        computerRepository.save(computer);
    }

    private void notifyAdmin(String employeeAbbreviation) {
        int noOfComputers = computerRepository.findAllByEmployeeAbbreviation(employeeAbbreviation).size();
        if (noOfComputers >= 3) {
            adminNotificationService.notifyThreeComputers(employeeAbbreviation);
        }
    }
}
