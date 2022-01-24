package br.com.pipo.facade;

import br.com.pipo.facade.dto.client.ClientToCreateDTO;
import br.com.pipo.facade.dto.client.ClientToGetAllDTO;
import br.com.pipo.facade.dto.client.ClientToGetDTO;
import br.com.pipo.facade.dto.client.ClientToSimpleDTO;
import br.com.pipo.facade.mapper.ClientMapper;
import br.com.pipo.model.Client;
import br.com.pipo.service.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientFacade {

    private final ClientMapper clientMapper;
    private final ClientService clientService;

    public ClientFacade(
        ClientMapper clientMapper,
        ClientService clientService
    ) {
        this.clientMapper = clientMapper;
        this.clientService = clientService;
    }

    @Transactional
    public ClientToSimpleDTO save(ClientToCreateDTO dto) {
        Client entity = clientMapper.toCreateEntity(dto);
        Client saved = clientService.save(entity);
        return clientMapper.toSimṕleDto(saved);
    }

    @Transactional(readOnly = true)
    public ClientToGetDTO get(String id) {
        Client entity = clientService.get(id);
        return clientMapper.toGetDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ClientToGetAllDTO> getAll() {
        return clientService.getAll().stream()
            .map(clientMapper::toGetAllDto)
            .collect(Collectors.toList());
    }

}
