package com.upc.demo.controller;

import com.upc.demo.domain.model.Membership;
import com.upc.demo.domain.service.MembershipService;
import com.upc.demo.resource.MembershipResource;
import com.upc.demo.resource.saving.SaveMembershipResource;
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
public class MembershipController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private MembershipService membershipService;

    @GetMapping("/posts/{postId}/memberships")
    public Page<MembershipResource> getAllMembershipsByProviderId(
            @PathVariable(name = "postId") Long postId,
            Pageable pageable) {
        Page<Membership> membershipPage = membershipService.getAllMembershipsByProviderId(postId, pageable);
        List<MembershipResource> resources = membershipPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/posts/{postId}/memberships/{membershipId}")
    public MembershipResource getMembershipByIdAndProviderId(@PathVariable(name = "postId") Long postId,
                                                   @PathVariable(name = "membershipId") Long membershipId) {
        return convertToResource(membershipService.getMembershipByIdAndProviderId(postId, membershipId));
    }

    @PostMapping("/posts/{postId}/memberships")
    public MembershipResource createMembership(@PathVariable(name = "postId") Long postId,
                                         @Valid @RequestBody SaveMembershipResource resource) {
        return convertToResource(membershipService.createMembership(postId, convertToEntity(resource)));

    }

    @PutMapping("/posts/{postId}/memberships/{membershipId}")
    public MembershipResource updateMembership(@PathVariable(name = "postId") Long postId,
                                         @PathVariable(name = "membershipId") Long membershipId,
                                         @Valid @RequestBody SaveMembershipResource resource) {
        return convertToResource(membershipService.updateMembership(postId, membershipId, convertToEntity(resource)));
    }

    @DeleteMapping("/posts/{postId}/memberships/{membershipId}")
    public ResponseEntity<?> deleteMembership(@PathVariable(name = "postId") Long postId,
                                           @PathVariable(name = "membershipId") Long membershipId) {
        return membershipService.deleteMembership(postId, membershipId);
    }

    private Membership convertToEntity(SaveMembershipResource resource) {
        return mapper.map(resource, Membership.class);
    }

    private MembershipResource convertToResource(Membership entity) {
        return mapper.map(entity, MembershipResource.class);
    }
}
