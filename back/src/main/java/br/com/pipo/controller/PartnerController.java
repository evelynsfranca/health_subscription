package br.com.pipo.controller;

import br.com.pipo.facade.PartnerFacade;
import br.com.pipo.facade.dto.partner.PartnerToCreateDTO;
import br.com.pipo.facade.dto.partner.PartnerToGetAllDTO;
import br.com.pipo.facade.dto.partner.PartnerToGetDTO;
import br.com.pipo.facade.dto.partner.PartnerToSimpleDTO;
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
@RequestMapping("/api/partners")
public class PartnerController {

    private final PartnerFacade partnerFacade;

    public PartnerController(PartnerFacade partnerFacade) {
        this.partnerFacade = partnerFacade;
    }

    @PostMapping
    private ResponseEntity<PartnerToSimpleDTO> create(@Valid @RequestBody PartnerToCreateDTO dto) {
        PartnerToSimpleDTO result = partnerFacade.save(dto);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<PartnerToGetDTO> get(@PathVariable String id) {
        PartnerToGetDTO result = partnerFacade.get(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<PartnerToGetAllDTO>> getAll() {
        List<PartnerToGetAllDTO> result = partnerFacade.getAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
