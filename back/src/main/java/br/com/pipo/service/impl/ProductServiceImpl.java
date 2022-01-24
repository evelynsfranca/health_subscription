package br.com.pipo.service.impl;

import br.com.pipo.model.Partner;
import br.com.pipo.model.Product;
import br.com.pipo.model.ProductCategory;
import br.com.pipo.repository.PartnerRepository;
import br.com.pipo.repository.ProductCategoryRepository;
import br.com.pipo.repository.ProductRepository;
import br.com.pipo.service.ProductService;
import br.com.pipo.service.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final PartnerRepository partnerRepository;

    public ProductServiceImpl(
        ProductRepository productRepository,
        ProductCategoryRepository productCategoryRepository,
        PartnerRepository partnerRepository
    ) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.partnerRepository = partnerRepository;
    }

    @Override
    public Product save(Product product) {
        ProductCategory category = productCategoryRepository.findById(product.getCategory().getId())
            .orElseThrow(() -> new NotFoundException("Category not found."));
        Partner partner = partnerRepository.findById(product.getPartner().getId())
            .orElseThrow(() -> new NotFoundException("Partner not found."));

        product.setCategory(category);
        product.setPartner(partner);

        return productRepository.save(product);
    }

    @Override
    public Product get(String id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Product not found."));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllByClientId(String clientId) {
        return productRepository.findAllByClientId(clientId);
    }
}
