package com.upc.demo.service;

import com.upc.demo.domain.model.Card;
import com.upc.demo.domain.model.Membership;
import com.upc.demo.domain.model.MembershipPayment;
import com.upc.demo.domain.repository.CardRepository;
import com.upc.demo.domain.repository.MembershipPaymentRepository;
import com.upc.demo.domain.repository.MembershipRepository;
import com.upc.demo.domain.service.MembershipPaymentService;
import com.upc.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipPaymentServiceImpl implements MembershipPaymentService {

    @Autowired
    private MembershipPaymentRepository membershipPaymentRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private MembershipRepository membershipRepository;

    @Override
    public List<MembershipPayment> getAllMembershipPaymentsByCardId(Long cardId) {
        return membershipPaymentRepository.findByCardId(cardId);
    }

    @Override
    public List<MembershipPayment> getAllMembershipPaymentsByMembershipId(Long membershipId) {
        return membershipPaymentRepository.findByMembershipId(membershipId);
    }

    @Override
    public MembershipPayment getMembershipPaymentByIdAndCardIdAndMembershipId(Long membershipPaymentId, Long cardId, Long membershipId) {
        return membershipPaymentRepository.findByIdAndCardIdAndMembershipId(membershipPaymentId,cardId,membershipId).orElseThrow();
    }

    @Override
    public MembershipPayment createMembershipPayment(Long cardId, Long membershipId, MembershipPayment membershipPayment) {
        //pos1
       return cardRepository.findById(cardId).map(card -> {

            membershipRepository.findById(membershipId).map(membership -> {
                membershipPayment.setMembership(membership);
                return membershipPayment;
            }).orElseThrow(() -> new ResourceNotFoundException());

            membershipPayment.setCard(card);
           return membershipPaymentRepository.save(membershipPayment);
       }).orElseThrow(() -> new ResourceNotFoundException());
        //pos2
        /*Card card = cardRepository.findById(cardId).orElseThrow(() -> new ResourceNotFoundException();
        Membership membership = membershipRepository.findById(membershipId).orElseThrow(() -> new ResourceNotFoundException();
        membershipPayment.setCard(card);
        membershipPayment.setMembership(membership);
        return membershipPaymentRepository.save(membershipPayment);*/
    }
}
