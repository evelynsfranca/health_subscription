package br.com.pipo.service.impl;

import br.com.pipo.model.Client;
import br.com.pipo.repository.ClientRepository;
import br.com.pipo.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.findById(client.getId())
            .map(it -> {
                it.setName(client.getName());
                return it;
            }).map(clientRepository::save)
            .orElseThrow(() -> new IllegalArgumentException("Client not found."));
    }

    @Override
    public Client get(String id) {
        return clientRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Client not found."));
}

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public void delete(String id) {
        clientRepository.findById(id)
            .ifPresent(clientRepository::delete);
    }
}
