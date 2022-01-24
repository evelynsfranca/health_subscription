package br.com.pipo.facade;

import br.com.pipo.facade.dto.employee.EmployeeToCreateDTO;
import br.com.pipo.facade.dto.employee.EmployeeToGetAllDTO;
import br.com.pipo.facade.dto.employee.EmployeeToGetDTO;
import br.com.pipo.facade.dto.employee.EmployeeToSimpleDTO;
import br.com.pipo.facade.mapper.EmployeeMapper;
import br.com.pipo.facade.validation.employee.EmployeeToCreateValidation;
import br.com.pipo.model.Employee;
import br.com.pipo.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeFacade {

    private final EmployeeMapper employeeMapper;
    private final EmployeeService employeeService;
    private final EmployeeToCreateValidation employeeToCreateValidation;

    public EmployeeFacade(
        EmployeeMapper employeeMapper,
        EmployeeService employeeService,
        EmployeeToCreateValidation employeeToCreateValidation
    ) {
        this.employeeMapper = employeeMapper;
        this.employeeService = employeeService;
        this.employeeToCreateValidation = employeeToCreateValidation;
    }

    @Transactional
    public EmployeeToSimpleDTO save(EmployeeToCreateDTO dto) {
        employeeToCreateValidation.create(dto);
        Employee entity = employeeMapper.toCreateEntity(dto);

        Employee saved = employeeService.save(entity);
        return employeeMapper.toSimṕleDto(saved);
    }

    @Transactional(readOnly = true)
    public EmployeeToGetDTO get(String id) {
        Employee entity = employeeService.get(id);
        return employeeMapper.toGetDto(entity);
    }

    @Transactional(readOnly = true)
    public List<EmployeeToGetAllDTO> getAll() {
        return employeeService.getAll().stream()
            .map(employeeMapper::toGetAllDto)
            .collect(Collectors.toList());
    }

}
