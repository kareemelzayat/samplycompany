package greenbone.controller;


import greenbone.domain.Computer;
import greenbone.service.ComputerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/computers")
public class ApiComputerController {
    private final ComputerService computerService;
    public ApiComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    public void list() {}

    public void list(String employeeAbbreviation) {}

    public void get(@PathVariable Long id) {}

    public void create(@RequestBody Computer computer) {
        computerService.create(computer);
    }

    public void update(@PathVariable Long id, @RequestBody Map<String, Object> body) {}

    public void delete(@PathVariable Long id) {}

    public void delete(@PathVariable Long id, String employeeAbbreviation) {}
}
