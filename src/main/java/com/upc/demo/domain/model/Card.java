package com.upc.demo.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "cards")
@Getter
@Setter
public class Card extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private Integer number;

    private Date expirationDate;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String ownerName;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String ownerLastName;

    @NotNull
    @NotBlank
    private Integer codCV;

}
