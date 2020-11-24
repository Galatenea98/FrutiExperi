package com.upc.demo.domain.service;

import com.upc.demo.domain.model.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProviderService {
    ResponseEntity<?> deleteProvider(Long providerId);
    Provider updateProvider(Long providerId, Provider providerRequest);
    Provider createProvider(Provider provider);
    Provider getProviderById(Long providerId);
    List<Provider> getAllProviders();
}
