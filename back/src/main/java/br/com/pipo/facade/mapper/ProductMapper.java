package br.com.pipo.facade.mapper;

import br.com.pipo.facade.dto.product.ProductToCreateDTO;
import br.com.pipo.facade.dto.product.ProductToCreateEmployeeDTO;
import br.com.pipo.facade.dto.product.ProductToGetAllDTO;
import br.com.pipo.facade.dto.product.ProductToGetDTO;
import br.com.pipo.facade.dto.product.ProductToSimpleDTO;
import br.com.pipo.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { ClientMapper.class, PartnerMapper.class })
public interface ProductMapper {

    Product toCreateEntity(ProductToCreateDTO dto);

    ProductToSimpleDTO toSimṕleDto(Product entity);

    ProductToGetDTO toGetDto(Product entity);

    ProductToGetAllDTO toGetAllDto(Product entity);

    Product toCreateEmployeeEntity(ProductToCreateEmployeeDTO dto);
}
