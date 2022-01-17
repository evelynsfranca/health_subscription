package br.com.pipo.controller;

import br.com.pipo.model.Client;
import br.com.pipo.service.ClientService;
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
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    private ResponseEntity<Client> create(@RequestBody Client client) {
        Client result = clientService.save(client);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @PutMapping
    private ResponseEntity<Client> update(@RequestBody Client client) {
        Client result = clientService.update(client);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Client> get(@PathVariable String id) {
        Client result = clientService.get(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<Client>> getAll() {
        List<Client> result = clientService.getAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable String id) {
        clientService.delete(id);
        return new ResponseEntity(ResponseEntity.noContent(), HttpStatus.OK);
    }
}
