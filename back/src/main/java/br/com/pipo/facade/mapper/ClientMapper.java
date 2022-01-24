package br.com.pipo.facade.mapper;

import br.com.pipo.facade.dto.client.ClientToCreateDTO;
import br.com.pipo.facade.dto.client.ClientToCreateEmployeeDTO;
import br.com.pipo.facade.dto.client.ClientToGetAllDTO;
import br.com.pipo.facade.dto.client.ClientToGetDTO;
import br.com.pipo.facade.dto.client.ClientToSimpleDTO;
import br.com.pipo.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface ClientMapper {

    Client toCreateEntity(ClientToCreateDTO dto);

    ClientToSimpleDTO toSimṕleDto(Client entity);

    ClientToGetDTO toGetDto(Client entity);

    ClientToGetAllDTO toGetAllDto(Client entity);

    Client toCreateEmployeeEntity(ClientToCreateEmployeeDTO dto);
}
