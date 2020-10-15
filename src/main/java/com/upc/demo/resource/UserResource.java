package com.upc.demo.resource;

import com.upc.demo.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;


@Getter
public class UserResource extends AuditModel {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Integer phone;
}
