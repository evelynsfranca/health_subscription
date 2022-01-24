package br.com.pipo.repository;

import br.com.pipo.model.Address;
import br.com.pipo.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
}
