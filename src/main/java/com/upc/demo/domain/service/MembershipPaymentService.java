package com.upc.demo.domain.service;


import com.upc.demo.domain.model.MembershipPayment;

import java.util.List;

public interface MembershipPaymentService {
    List<MembershipPayment> getAllMembershipPaymentsByCardId(Long cardId);
    List<MembershipPayment> getAllMembershipPaymentsByMembershipId(Long membershipId);
    MembershipPayment getMembershipPaymentByIdAndCardIdAndMembershipId(Long membershipPaymentId, Long cardId,Long membershipId);
    MembershipPayment createMembershipPayment(Long cardId,Long membershipId,MembershipPayment membershipPayment);
}
