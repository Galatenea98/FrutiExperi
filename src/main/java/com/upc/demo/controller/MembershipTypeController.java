package com.upc.demo.controller;

import com.upc.demo.domain.model.MembershipType;
import com.upc.demo.domain.service.MembershipTypeService;
import com.upc.demo.resource.MembershipTypeResource;
import com.upc.demo.resource.saving.SaveMembershipTypeResource;
import io.swagger.v3.oas.annotations.Parameter;
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
public class MembershipTypeController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private MembershipTypeService membershipTypeService;

    @GetMapping("/membershipTypes")
    public Page<MembershipTypeResource> getAllMembershipTypes(
            @Parameter(description="Pageable Parameter")
                    Pageable pageable) {
        Page<MembershipType> membershipTypesPage = membershipTypeService.getAllMembershipTypes(pageable);
        List<MembershipTypeResource> resources = membershipTypesPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/membershipTypes/{id}")
    public MembershipTypeResource getMembershipTypeById(
            @Parameter(description="MembershipType Id")
            @PathVariable(name = "id") Long membershipTypeId) {
        return convertToResource(membershipTypeService.getMembershipTypeById(membershipTypeId));
    }

    @PostMapping("/membershipTypes")
    public MembershipTypeResource createMembershipType(@Valid @RequestBody SaveMembershipTypeResource resource)  {
        MembershipType membershipType = convertToEntity(resource);
        return convertToResource(membershipTypeService.createMembershipType(membershipType));
    }

    @PutMapping("/membershipTypes/{id}")
    public MembershipTypeResource updateMembershipType(@PathVariable(name = "id") Long membershipTypeId, @Valid @RequestBody SaveMembershipTypeResource resource) {
        MembershipType membershipType = convertToEntity(resource);
        return convertToResource(membershipTypeService.updateMembershipType(membershipTypeId, membershipType));
    }

    @DeleteMapping("/membershipTypes/{id}")
    public ResponseEntity<?> deleteMembershipType(@PathVariable(name = "id") Long membershipTypeId) {
        return membershipTypeService.deleteMembershipType(membershipTypeId);
    }


    private MembershipType convertToEntity(SaveMembershipTypeResource resource) {
        return mapper.map(resource, MembershipType.class);
    }

    private MembershipTypeResource convertToResource(MembershipType entity) {
        return mapper.map(entity, MembershipTypeResource.class);
    }
}
