package com.upc.demo.domain.repository;

import com.upc.demo.domain.model.Card;
import com.upc.demo.domain.model.Membership;
import com.upc.demo.domain.model.MembershipPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MembershipPaymentRepository extends JpaRepository<MembershipPayment,Long> {
    List<MembershipPayment> findByCardId(Long cardId);
    List<MembershipPayment> findByMembershipId(Long membershipId);
    Optional<MembershipPayment> findByIdAndCardIdAndMembershipId(Long id, Long cardId,Long membershipId);

}
