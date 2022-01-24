package br.com.pipo.facade;

import br.com.pipo.facade.dto.product.ProductToCreateDTO;
import br.com.pipo.facade.dto.product.ProductToSimpleDTO;
import br.com.pipo.facade.mapper.ProductMapper;
import br.com.pipo.model.Product;
import br.com.pipo.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductFacade {

    private final ProductMapper productMapper;
    private final ProductService productService;

    public ProductFacade(
        ProductMapper productMapper,
        ProductService productService
    ) {
        this.productMapper = productMapper;
        this.productService = productService;
    }

    @Transactional
    public ProductToSimpleDTO save(ProductToCreateDTO dto) {
        Product entity = productMapper.toCreateEntity(dto);
        Product saved = productService.save(entity);
        return productMapper.toSimṕleDto(saved);
    }

    @Transactional(readOnly = true)
    public Product get(String id) {
        return productService.get(id);
    }

    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productService.getAll();
    }

}
