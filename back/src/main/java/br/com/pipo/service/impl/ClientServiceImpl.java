package br.com.pipo.service.impl;

import br.com.pipo.model.Client;
import br.com.pipo.model.Product;
import br.com.pipo.repository.ClientRepository;
import br.com.pipo.repository.ProductRepository;
import br.com.pipo.service.ClientService;
import br.com.pipo.service.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(
        ClientRepository clientRepository
    ) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client get(String id) {
        return clientRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Client not found."));
}

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }
}
