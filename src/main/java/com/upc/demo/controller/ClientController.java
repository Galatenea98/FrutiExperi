package com.upc.demo.controller;

import com.upc.demo.domain.model.Client;
import com.upc.demo.domain.service.ClientService;
import com.upc.demo.resource.ClientResource;
import com.upc.demo.resource.saving.SaveClientResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<ClientResource> getAllClients()
    {
        return clientService.getAllClients().stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/clients/{id}")
    public ClientResource getClientById(
            @Parameter(description="Client Id")
            @PathVariable(name = "id") Long clientId) {
        return convertToResource(clientService.getClientById(clientId));
    }

    @PostMapping("/clients")
    public ClientResource createClient(@Valid @RequestBody SaveClientResource resource)  {
        Client client = convertToEntity(resource);
        return convertToResource(clientService.createClient(client));
    }

    @PutMapping("/clients/{id}")
    public ClientResource updateClient(@PathVariable(name = "id") Long clientId, @Valid @RequestBody SaveClientResource resource) {
        Client client = convertToEntity(resource);
        return convertToResource(clientService.updateClient(clientId, client));
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(name = "id") Long clientId) {
        return clientService.deleteClient(clientId);
    }


    private Client convertToEntity(SaveClientResource resource) {
        return mapper.map(resource, Client.class);
    }

    private ClientResource convertToResource(Client entity) {
        return mapper.map(entity, ClientResource.class);
    }
}
