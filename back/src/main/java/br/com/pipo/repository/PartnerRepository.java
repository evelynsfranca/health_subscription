package br.com.pipo.repository;

import br.com.pipo.model.Partner;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartnerRepository extends MongoRepository<Partner, String> {
}
