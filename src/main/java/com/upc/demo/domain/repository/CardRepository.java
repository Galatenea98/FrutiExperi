package com.upc.demo.domain.repository;

import com.upc.demo.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card>findByUserId(Long userId);
    Optional<Card> findByIdAndUserId(Long id, Long userId);
}
