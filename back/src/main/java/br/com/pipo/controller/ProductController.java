package br.com.pipo.controller;

import br.com.pipo.model.Product;
import br.com.pipo.service.ProductService;
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
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    private ResponseEntity<Product> create(@RequestBody Product category) {
        Product result = productService.save(category);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @PutMapping
    private ResponseEntity<Product> update(@RequestBody Product category) {
        Product result = productService.update(category);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Product> get(@PathVariable String id) {
        Product result = productService.get(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<Product>> getAll() {
        List<Product> result = productService.getAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable String id) {
        productService.delete(id);
        return new ResponseEntity(ResponseEntity.noContent(), HttpStatus.OK);
    }
}
