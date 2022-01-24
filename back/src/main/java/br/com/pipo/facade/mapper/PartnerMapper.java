package br.com.pipo.facade.mapper;

import br.com.pipo.facade.dto.partner.PartnerToCreateDTO;
import br.com.pipo.facade.dto.partner.PartnerToGetAllDTO;
import br.com.pipo.facade.dto.partner.PartnerToGetDTO;
import br.com.pipo.facade.dto.partner.PartnerToSimpleDTO;
import br.com.pipo.model.Partner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface PartnerMapper {

    Partner toCreateEntity(PartnerToCreateDTO dto);

    PartnerToSimpleDTO toSimṕleDto(Partner entity);

    PartnerToGetDTO toGetDto(Partner entity);

    PartnerToGetAllDTO toGetAllDto(Partner entity);
}
