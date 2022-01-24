package br.com.pipo.repository;

import br.com.pipo.model.Partner;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PartnerRepository extends MongoRepository<Partner, String> {
}
