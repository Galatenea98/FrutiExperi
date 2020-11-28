package com.upc.demo.resource;

import com.upc.demo.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter@Setter

public class UserResource extends AuditModel {

    private Long id;

    private String email;

    private String password;


}
