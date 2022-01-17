package br.com.pipo.service;

import br.com.pipo.model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    ProductCategory save(ProductCategory category);

    ProductCategory update(ProductCategory category);

    ProductCategory get(String id);

    List<ProductCategory> getAll();

    void delete(String id);
}
