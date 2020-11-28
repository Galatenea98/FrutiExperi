package com.upc.demo.domain.repository;

import com.upc.demo.domain.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider,Long> {
}
