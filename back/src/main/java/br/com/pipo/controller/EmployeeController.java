package br.com.pipo.controller;

import br.com.pipo.facade.EmployeeFacade;
import br.com.pipo.facade.dto.employee.EmployeeToCreateDTO;
import br.com.pipo.facade.dto.employee.EmployeeToGetAllDTO;
import br.com.pipo.facade.dto.employee.EmployeeToGetDTO;
import br.com.pipo.facade.dto.employee.EmployeeToSimpleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeFacade employeeFacade;

    public EmployeeController(EmployeeFacade employeeFacade) {
        this.employeeFacade = employeeFacade;
    }

    @PostMapping
    private ResponseEntity<EmployeeToSimpleDTO> create(@Valid @RequestBody EmployeeToCreateDTO dto) {
        EmployeeToSimpleDTO result = employeeFacade.save(dto);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<EmployeeToGetDTO> get(@PathVariable String id) {
        EmployeeToGetDTO result = employeeFacade.get(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<EmployeeToGetAllDTO>> getAll() {
        List<EmployeeToGetAllDTO> result = employeeFacade.getAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
