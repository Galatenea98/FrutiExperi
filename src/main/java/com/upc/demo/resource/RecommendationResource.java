package com.upc.demo.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upc.demo.domain.model.AuditModel;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter

public class RecommendationResource extends AuditModel {

    private Long id;

    private String content;


}
