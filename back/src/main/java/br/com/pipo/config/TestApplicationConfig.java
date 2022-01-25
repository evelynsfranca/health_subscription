package br.com.pipo.config;

import br.com.pipo.model.Client;
import br.com.pipo.model.Partner;
import br.com.pipo.model.Product;
import br.com.pipo.model.enumeration.PartnerName;
import br.com.pipo.repository.ClientRepository;
import br.com.pipo.repository.PartnerRepository;
import br.com.pipo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;


@Configuration
public class TestApplicationConfig {

    @Bean
    public CommandLineRunner initConfig(PartnerRepository partnerRepository, ProductRepository productRepository, ClientRepository clientRepository) {

        Client clientAcme = new Client();
        clientAcme.setName("Acme Co");
        clientAcme.setProducts(new ArrayList<>());
        clientRepository.save(clientAcme);

        Client clientTioPatinhas = new Client();
        clientTioPatinhas.setName("Tio Patinhas Bank");
        clientTioPatinhas.setProducts(new ArrayList<>());
        clientRepository.save(clientTioPatinhas);

        Arrays.stream(PartnerName.values())
            .forEach(it -> {
                Partner entity = new Partner();
                entity.setName(it);
                Partner savedPartner = partnerRepository.findByName(it).orElseGet(() -> partnerRepository.save(entity));

                Product product = new Product();
                product.setPartner(savedPartner);
                product.setName(it + " - Product One");
                productRepository.save(product);

                if (it == PartnerName.NORTE_EUROPA) {
                    clientAcme.getProducts().add(product);
                }

                if (it == PartnerName.DENTAL_SORRISO) {
                    clientAcme.getProducts().add(product);
                    clientTioPatinhas.getProducts().add(product);
                }

                if (it == PartnerName.PAMPULHA_INTRAMEDICA || it == PartnerName.MENTE_SA_CORPO_SAO) {
                    clientTioPatinhas.getProducts().add(product);
                }

                clientRepository.save(clientAcme);
                clientRepository.save(clientTioPatinhas);

            });


        return null;
    }
}
