package com.upc.demo.service;

import com.upc.demo.domain.model.Client;
import com.upc.demo.domain.repository.ClientRepository;
import com.upc.demo.domain.service.ClientService;
import com.upc.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl  implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public ResponseEntity<?> deleteClient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "Id", clientId));
        clientRepository.delete(client);
        return ResponseEntity.ok().build();
    }

    @Override
    public Client updateClient(Long clientId, Client clientRequest) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "Id", clientId));

        return clientRepository.save(client);
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "Id", clientId));
    }

    @Override
    public Page<Client> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }
}
