package com.upc.demo.controller;

import com.upc.demo.domain.model.MembershipPayment;
import com.upc.demo.domain.service.MembershipPaymentService;
import com.upc.demo.resource.MembershipPaymentResource;
import com.upc.demo.resource.saving.SaveMembershipPaymentResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MembershipPaymentController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private MembershipPaymentService membershipPaymentService;

    @GetMapping("/cards/{cardId}/membershipPayments")
    public List<MembershipPaymentResource> getAllMembershipPaymentsByCardId(
            @PathVariable(name = "cardId") Long cardId) {
       return membershipPaymentService.getAllMembershipPaymentsByCardId(cardId).stream().map(this::convertToResource).collect(Collectors.toList());
    
    }
    @GetMapping("/memberships/{membershipId}/membershipPayments")
    public List<MembershipPaymentResource> getAllMembershipPaymentsByMembershipId(
            @PathVariable(name = "membershipId") Long membershipId) {
        return membershipPaymentService.getAllMembershipPaymentsByMembershipId(membershipId).stream().map(this::convertToResource).collect(Collectors.toList());

    }
    @GetMapping("/cards/{cardId}/memberships/{membershipId}/membershipPayments/{membershipPaymentId}")
    public MembershipPaymentResource getMembershipPaymentByIdAndPostId(@PathVariable(name = "cardId") Long cardId,
                                                                       @PathVariable(name = "membershipId") Long membershipId,
                                                                       @PathVariable(name = "membershipPaymentId") Long membershipPaymentId
    ) {
        return convertToResource(membershipPaymentService.getMembershipPaymentByIdAndCardIdAndMembershipId(membershipPaymentId,cardId,membershipId));
    }








    private MembershipPayment convertToEntity(SaveMembershipPaymentResource resource) {
        return mapper.map(resource, MembershipPayment.class);
    }

    private MembershipPaymentResource convertToResource(MembershipPayment entity) {
        return mapper.map(entity, MembershipPaymentResource.class);
    }
}
