package com.upc.demo.domain.service;

import com.upc.demo.domain.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientService {
    ResponseEntity<?> deleteClient(Long clientId);
    Client updateClient(Long clientId, Client clientRequest);
    Client createClient(Client client);
    Client getClientById(Long clientId);
    List<Client> getAllClients();
}
