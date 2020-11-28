package com.upc.demo.resource.saving;

import com.upc.demo.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SaveRecommendationResource extends AuditModel {

    private Long id;

    private String content;


}
