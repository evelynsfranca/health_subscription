package br.com.pipo.service.impl;

import br.com.pipo.model.Partner;
import br.com.pipo.repository.PartnerRepository;
import br.com.pipo.service.PartnerService;
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
    public Partner update(Partner partner) {
        return partnerRepository.findById(partner.getId())
            .map(it -> {
                it.setName(partner.getName());
                return it;
            }).map(partnerRepository::save)
            .orElseThrow(() -> new IllegalArgumentException("Partner not found."));
    }

    @Override
    public Partner get(String id) {
        return partnerRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Partner not found."));
    }

    @Override
    public List<Partner> getAll() {
        return partnerRepository.findAll();
    }

    @Override
    public void delete(String id) {
        partnerRepository.findById(id)
            .ifPresent(partnerRepository::delete);
    }
}
