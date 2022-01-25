package br.com.pipo.service.impl;

import br.com.pipo.model.Partner;
import br.com.pipo.model.Product;
import br.com.pipo.repository.PartnerRepository;
import br.com.pipo.repository.ProductRepository;
import br.com.pipo.service.ProductService;
import br.com.pipo.service.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final PartnerRepository partnerRepository;

    public ProductServiceImpl(
        ProductRepository productRepository,
        PartnerRepository partnerRepository
    ) {
        this.productRepository = productRepository;
        this.partnerRepository = partnerRepository;
    }

    @Override
    public Product save(Product product) {
        Partner partner = partnerRepository.findById(product.getPartner().getId())
            .orElseThrow(() -> new NotFoundException("Partner not found."));
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
