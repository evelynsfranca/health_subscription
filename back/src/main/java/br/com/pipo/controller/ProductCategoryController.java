package br.com.pipo.controller;

import br.com.pipo.model.ProductCategory;
import br.com.pipo.service.ProductCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product-categories")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @PostMapping
    private ResponseEntity<ProductCategory> create(@RequestBody ProductCategory category) {
        ProductCategory result = productCategoryService.save(category);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @PutMapping
    private ResponseEntity<ProductCategory> update(@RequestBody ProductCategory category) {
        ProductCategory result = productCategoryService.update(category);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ProductCategory> get(@PathVariable String id) {
        ProductCategory result = productCategoryService.get(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<ProductCategory>> getAll() {
        List<ProductCategory> result = productCategoryService.getAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable String id) {
        productCategoryService.delete(id);
        return new ResponseEntity(ResponseEntity.noContent(), HttpStatus.OK);
    }
}
