package com.upc.demo.domain.repository;

import com.upc.demo.domain.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembershipRepository extends JpaRepository<Membership,Long> {
    List<Membership> findByProviderId(Long postId);
    Optional<Membership> findByIdAndProviderId(Long id, Long postId);

}
