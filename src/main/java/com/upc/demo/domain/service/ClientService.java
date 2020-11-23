package com.upc.demo.domain.service;

import com.upc.demo.domain.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ClientService {
    ResponseEntity<?> deleteClient(Long clientId);
    Client updateClient(Long clientId, Client clientRequest);
    Client createClient(Client client);
    Client getClientById(Long clientId);
    Page<Client> getAllClients(Pageable pageable);
}
