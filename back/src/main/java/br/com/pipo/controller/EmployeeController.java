package br.com.pipo.controller;

import br.com.pipo.model.Employee;
import br.com.pipo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    private ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee result = employeeService.save(employee);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @PutMapping
    private ResponseEntity<Employee> update(@RequestBody Employee employee) {
        Employee result = employeeService.update(employee);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Employee> get(@PathVariable String id) {
        Employee result = employeeService.get(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<Employee>> getAll() {
        List<Employee> result = employeeService.getAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable String id) {
        employeeService.delete(id);
        return new ResponseEntity(ResponseEntity.noContent(), HttpStatus.OK);
    }
}
