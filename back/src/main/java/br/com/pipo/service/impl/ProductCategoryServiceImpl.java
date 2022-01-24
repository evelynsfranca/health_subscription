package br.com.pipo.service.impl;

import br.com.pipo.model.ProductCategory;
import br.com.pipo.repository.ProductCategoryRepository;
import br.com.pipo.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public ProductCategory save(ProductCategory category) {
        return productCategoryRepository.save(category);
    }

    @Override
    public ProductCategory get(String id) {
        return productCategoryRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Category not found."));
    }

    @Override
    public List<ProductCategory> getAll() {
        return productCategoryRepository.findAll();
    }

}
