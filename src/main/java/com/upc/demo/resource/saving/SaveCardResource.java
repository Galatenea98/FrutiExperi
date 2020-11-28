package com.upc.demo.resource.saving;

import com.upc.demo.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class SaveCardResource extends AuditModel {


    private Long id;

    private Integer number;

    private Date expirationDate;

    private String ownerName;

    private String ownerLastName;

    private Integer codCV;

}
