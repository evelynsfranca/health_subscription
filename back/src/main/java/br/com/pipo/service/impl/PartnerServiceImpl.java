package br.com.pipo.service.impl;

import br.com.pipo.model.Partner;
import br.com.pipo.repository.PartnerRepository;
import br.com.pipo.service.PartnerService;
import br.com.pipo.service.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository partnerRepository;

    public PartnerServiceImpl(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @Override
    public Partner save(Partner partner) {
        return partnerRepository.save(partner);
    }

    @Override
    public Partner get(String id) {
        return partnerRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Partner not found."));
    }

    @Override
    public List<Partner> getAll() {
        return partnerRepository.findAll();
    }
}
