package greenbone.controller;

import greenbone.domain.Computer;
import greenbone.model.ComputerDto;
import greenbone.service.ComputerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/computers")
public class ComputerController {

    private final ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Computer> list(Pageable pageable) {
        return computerService.getAllComputers(pageable);
    }

    @RequestMapping(params = "employeeAbbreviation", method = RequestMethod.GET)
    public List<Computer> list(String employeeAbbreviation) {
        return computerService.getAllComputersForEmployee(employeeAbbreviation);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Computer> get(@PathVariable Long id) {
        Computer computer = computerService.getComputer(id);
        if (computer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(computer);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ComputerDto> create(@RequestBody ComputerDto computerDto) {
        Computer newComputer = computerService.create(computerDto.toEntity());
        if (newComputer == null) {
            return ResponseEntity.status(HttpStatusCode.valueOf(500)).build();
        }
        return ResponseEntity.created(URI.create("/api/computers/" + newComputer.getId())).body(newComputer.toDto());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ComputerDto> update(@PathVariable Long id, @RequestBody ComputerDto computerDto) {
        Computer existingComputer = computerService.getComputer(id);
        if (existingComputer == null) {
            return ResponseEntity.notFound().build();
        }
        computerDto.setId(existingComputer.getId());
        Computer updatedComputer = computerService.update(existingComputer.getId(), computerDto.toEntity());
        return ResponseEntity.ok(updatedComputer.toDto());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Computer computerToDelete = computerService.getComputer(id);
        if (computerToDelete == null) {
            return ResponseEntity.notFound().build();
        }
        computerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(path = "/{id}", params = "employeeAbbreviation", method = RequestMethod.DELETE)
    public ResponseEntity<Void> unassignFromEmployee(@PathVariable Long id, String employeeAbbreviation) {
        Computer computerToUnassign = computerService.getComputerForEmployee(id, employeeAbbreviation);
        if (computerToUnassign == null) {
            return ResponseEntity.notFound().build();
        }
        computerService.unassignFromEmployee(id, employeeAbbreviation);
        return ResponseEntity.noContent().build();
    }
}
