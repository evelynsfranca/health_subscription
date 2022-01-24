package br.com.pipo.facade.mapper;

import br.com.pipo.facade.dto.client.ClientToCreateDTO;
import br.com.pipo.facade.dto.client.ClientToCreateEmployeeDTO;
import br.com.pipo.facade.dto.client.ClientToGetAllDTO;
import br.com.pipo.facade.dto.client.ClientToGetDTO;
import br.com.pipo.facade.dto.client.ClientToSimpleDTO;
import br.com.pipo.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProductMapper.class, PartnerMapper.class })
public interface ClientMapper {

    Client toCreateEntity(ClientToCreateDTO dto);

    ClientToSimpleDTO toSimṕleDto(Client entity);

    @Mapping(source = "products", target = "products")
    ClientToGetDTO toGetDto(Client entity);

    @Mapping(source = "products", target = "products")
    ClientToGetAllDTO toGetAllDto(Client entity);

    Client toCreateEmployeeEntity(ClientToCreateEmployeeDTO dto);
}
