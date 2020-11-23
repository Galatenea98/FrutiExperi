package com.upc.demo.domain.repository;

import com.upc.demo.domain.model.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipTypeRepository extends JpaRepository<MembershipType,Long> {
}
