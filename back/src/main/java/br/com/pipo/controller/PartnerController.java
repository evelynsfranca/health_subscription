package br.com.pipo.controller;

import br.com.pipo.model.Partner;
import br.com.pipo.service.PartnerService;
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
@RequestMapping("/api/partners")
public class PartnerController {

    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @PostMapping
    private ResponseEntity<Partner> create(@RequestBody Partner partner) {
        Partner result = partnerService.save(partner);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @PutMapping
    private ResponseEntity<Partner> update(@RequestBody Partner partner) {
        Partner result = partnerService.update(partner);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Partner> get(@PathVariable String id) {
        Partner result = partnerService.get(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<Partner>> getAll() {
        List<Partner> result = partnerService.getAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable String id) {
        partnerService.delete(id);
        return new ResponseEntity(ResponseEntity.noContent(), HttpStatus.OK);
    }
}
