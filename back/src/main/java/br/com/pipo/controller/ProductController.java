package br.com.pipo.controller;

import br.com.pipo.facade.dto.product.ProductToCreateDTO;
import br.com.pipo.facade.dto.product.ProductToSimpleDTO;
import br.com.pipo.model.Product;
import br.com.pipo.facade.ProductFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductFacade productFacade;

    public ProductController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @PostMapping
    private ResponseEntity<ProductToSimpleDTO> create(@Valid @RequestBody ProductToCreateDTO dto) {
        ProductToSimpleDTO result = productFacade.save(dto);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Product> get(@PathVariable String id) {
        Product result = productFacade.get(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<Product>> getAll() {
        List<Product> result = productFacade.getAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
