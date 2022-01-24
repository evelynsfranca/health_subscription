package br.com.pipo.controller;

import br.com.pipo.facade.ClientFacade;
import br.com.pipo.facade.dto.client.ClientToCreateDTO;
import br.com.pipo.facade.dto.client.ClientToGetAllDTO;
import br.com.pipo.facade.dto.client.ClientToGetDTO;
import br.com.pipo.facade.dto.client.ClientToSimpleDTO;
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
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientFacade clientFacade;

    public ClientController(ClientFacade clientFacade) {
        this.clientFacade = clientFacade;
    }


    @PostMapping
    private ResponseEntity<ClientToSimpleDTO> create(@Valid @RequestBody ClientToCreateDTO dto) {
        ClientToSimpleDTO result = clientFacade.save(dto);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ClientToGetDTO> get(@PathVariable String id) {
        ClientToGetDTO result = clientFacade.get(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<ClientToGetAllDTO>> getAll() {
        List<ClientToGetAllDTO> result = clientFacade.getAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
