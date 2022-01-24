package br.com.pipo.facade;

import br.com.pipo.facade.dto.partner.PartnerToCreateDTO;
import br.com.pipo.facade.dto.partner.PartnerToGetAllDTO;
import br.com.pipo.facade.dto.partner.PartnerToGetDTO;
import br.com.pipo.facade.dto.partner.PartnerToSimpleDTO;
import br.com.pipo.facade.mapper.PartnerMapper;
import br.com.pipo.model.Partner;
import br.com.pipo.service.PartnerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnerFacade {

    private final PartnerMapper partnerMapper;
    private final PartnerService partnerService;

    public PartnerFacade(
        PartnerMapper partnerMapper,
        PartnerService partnerService
    ) {
        this.partnerMapper = partnerMapper;
        this.partnerService = partnerService;
    }

    @Transactional
    public PartnerToSimpleDTO save(PartnerToCreateDTO dto) {
        Partner entity = partnerMapper.toCreateEntity(dto);
        Partner saved = partnerService.save(entity);
        return partnerMapper.toSimṕleDto(saved);
    }

    @Transactional(readOnly = true)
    public PartnerToGetDTO get(String id) {
        Partner entity = partnerService.get(id);
        return partnerMapper.toGetDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PartnerToGetAllDTO> getAll() {
        return partnerService.getAll().stream()
            .map(partnerMapper::toGetAllDto)
            .collect(Collectors.toList());
    }

}
