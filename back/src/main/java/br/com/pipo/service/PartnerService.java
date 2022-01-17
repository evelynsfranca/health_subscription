package br.com.pipo.service;

import br.com.pipo.model.Partner;

import java.util.List;

public interface PartnerService {

    Partner save(Partner partner);

    Partner update(Partner partner);

    Partner get(String id);

    List<Partner> getAll();

    void delete(String id);
}
