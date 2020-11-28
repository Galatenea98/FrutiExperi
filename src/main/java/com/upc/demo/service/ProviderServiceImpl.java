package com.upc.demo.service;

import com.upc.demo.domain.model.Provider;
import com.upc.demo.domain.repository.ProviderRepository;
import com.upc.demo.domain.service.ProviderService;
import com.upc.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderRepository providerRepository;
    @Override
    public ResponseEntity<?> deleteProvider(Long providerId) {
        Provider provider = providerRepository.findById(providerId)
                .orElseThrow(() -> new ResourceNotFoundException("Provider", "Id", providerId));
        providerRepository.delete(provider);
        return ResponseEntity.ok().build();
    }

    @Override
    public Provider updateProvider(Long providerId, Provider providerRequest) {
        Provider provider = providerRepository.findById(providerId)
                .orElseThrow(() -> new ResourceNotFoundException("Provider", "Id", providerId));
        return providerRepository.save(provider);
    }

    @Override
    public Provider createProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    @Override
    public Provider getProviderById(Long providerId) {
        return providerRepository.findById(providerId)
                .orElseThrow(() -> new ResourceNotFoundException("Provider", "Id", providerId));
    }

    @Override
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }
}
