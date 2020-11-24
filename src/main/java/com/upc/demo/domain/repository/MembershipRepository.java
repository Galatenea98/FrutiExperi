package com.upc.demo.domain.repository;

import com.upc.demo.domain.model.Membership;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembershipRepository extends JpaRepository<Membership,Long> {
    Page<Membership> findByProviderId(Long postId, Pageable pageable);
    Optional<Membership> findByIdAndProviderId(Long id, Long postId);

}
