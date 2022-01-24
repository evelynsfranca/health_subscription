package br.com.pipo.facade.mapper;

import br.com.pipo.facade.dto.employee.EmployeeToCreateDTO;
import br.com.pipo.facade.dto.employee.EmployeeToSimpleDTO;
import br.com.pipo.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { AddressMapper.class, ClientMapper.class, ProductMapper.class })
public interface EmployeeMapper {

    Employee toCreateEntity(EmployeeToCreateDTO dto);

    EmployeeToSimpleDTO toSimṕleDto(Employee entity);
}
