package br.com.pipo.repository;

import br.com.pipo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{'clients' :{'$ref' : 'clients' , '$id' : ?0}}")
    List<Product> findAllByClientId(String clientId);
}
