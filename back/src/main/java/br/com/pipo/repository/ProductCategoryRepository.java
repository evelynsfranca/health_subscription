package br.com.pipo.repository;

import br.com.pipo.model.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductCategoryRepository extends MongoRepository<ProductCategory, String> {
}
