package br.com.pipo.facade.mapper;

import br.com.pipo.facade.dto.address.AddressToCreateEmployeeDTO;
import br.com.pipo.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { EmployeeMapper.class })
public interface AddressMapper {

    Address toCreateEntity(AddressToCreateEmployeeDTO dto);
}
