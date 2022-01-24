package br.com.pipo.service;

import br.com.pipo.model.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    Product get(String id);

    List<Product> getAll();

    List<Product> getAllByClientId(String clientId);
}
