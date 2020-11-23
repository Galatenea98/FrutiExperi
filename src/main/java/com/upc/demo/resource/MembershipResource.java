package com.upc.demo.resource;

import com.upc.demo.domain.model.AuditModel;
import lombok.*;

import java.util.Date;


@Getter
@Setter

public class MembershipResource extends AuditModel {

    private Long id;

    private Date startDate;

    private ProviderResource provider;

    private MembershipTypeResource membershipType;
}
