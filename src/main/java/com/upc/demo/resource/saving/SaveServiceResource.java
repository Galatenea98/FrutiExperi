package com.upc.demo.resource.saving;

import com.upc.demo.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter

public class SaveServiceResource extends AuditModel {

    private Long id;

    @NotNull
    private String name;

}
