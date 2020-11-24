package com.upc.demo.resource.saving;

import com.upc.demo.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter

public class SaveReservationResource extends AuditModel {

    private Long id;

    private Date reservationDate;

    private Boolean state;

}
