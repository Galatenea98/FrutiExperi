package com.upc.demo.resource;

import com.upc.demo.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Getter
@Setter
public class CardResource extends AuditModel {


    private Long id;

    private Integer number;

    private Date expirationDate;

    private String ownerName;

    private String ownerLastName;

    private Integer codCV;

}
