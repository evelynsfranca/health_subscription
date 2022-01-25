package br.com.pipo.repository;

import br.com.pipo.model.Partner;
import br.com.pipo.model.enumeration.PartnerName;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PartnerRepository extends MongoRepository<Partner, String> {

    Optional<Partner> findByName(PartnerName name);
}
