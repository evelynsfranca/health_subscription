package br.com.pipo.service;

import br.com.pipo.model.Client;

import java.util.List;

public interface ClientService {

    Client save(Client client);

    Client update(Client client);

    Client get(String id);

    List<Client> getAll();

    void delete(String id);
}
