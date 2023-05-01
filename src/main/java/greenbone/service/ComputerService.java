package greenbone.service;

import greenbone.domain.Computer;
import greenbone.repository.ComputerRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ComputerService {

    private final ComputerRepository computerRepository;

    public ComputerService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    public Iterable<Computer> getAllComputers() {
        return computerRepository.findAll();
    }

//    public Iterable<Computer> getAllComputersForEmployee(String employeeAbbreviation, Pageable pageable) {
//        return computerRepository.findAllByEmployeeAbbreviation(employeeAbbreviation, pageable);
//    }

    public Computer getComputer(Long id) {
        return computerRepository.findById(id).orElse(null);
    }

    public Computer create(Computer newComputer) {
        return computerRepository.save(newComputer);
    }

    public Computer update(Long id, Map<String, Object> params) {
        Optional<Computer> computer = computerRepository.findById(id);
        return computer.map(computerRepository::save).orElse(null);
    }

    public void delete(Long id) {
        computerRepository.deleteById(id);
    }
}
