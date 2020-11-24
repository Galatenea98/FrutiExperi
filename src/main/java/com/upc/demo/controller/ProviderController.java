package com.upc.demo.controller;

import com.upc.demo.domain.model.Provider;
import com.upc.demo.domain.service.ProviderService;
import com.upc.demo.resource.ProviderResource;
import com.upc.demo.resource.saving.SaveProviderResource;
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
public class ProviderController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ProviderService providerService;

    @GetMapping("/providers")
    public List<ProviderResource> getAllProviders(
            @Parameter(description="Pageable Parameter")
                    Pageable pageable) {
        Page<Provider> providersPage = providerService.getAllProviders(pageable);
        List<ProviderResource> resources = providersPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());

        return resources;
    }

    @GetMapping("/providers/{id}")
    public ProviderResource getProviderById(
            @Parameter(description="Provider Id")
            @PathVariable(name = "id") Long providerId) {
        return convertToResource(providerService.getProviderById(providerId));
    }

    @PostMapping("/providers")
    public ProviderResource createProvider(@Valid @RequestBody SaveProviderResource resource)  {
        Provider provider = convertToEntity(resource);
        return convertToResource(providerService.createProvider(provider));
    }

    @PutMapping("/providers/{id}")
    public ProviderResource updateProvider(@PathVariable(name = "id") Long providerId, @Valid @RequestBody SaveProviderResource resource) {
        Provider provider = convertToEntity(resource);
        return convertToResource(providerService.updateProvider(providerId, provider));
    }

    @DeleteMapping("/providers/{id}")
    public ResponseEntity<?> deleteProvider(@PathVariable(name = "id") Long providerId) {
        return providerService.deleteProvider(providerId);
    }


    private Provider convertToEntity(SaveProviderResource resource) {
        return mapper.map(resource, Provider.class);
    }

    private ProviderResource convertToResource(Provider entity) {
        return mapper.map(entity, ProviderResource.class);
    }
}
