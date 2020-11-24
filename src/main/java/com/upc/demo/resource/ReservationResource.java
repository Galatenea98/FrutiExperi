package com.upc.demo.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.upc.demo.domain.model.AuditModel;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter

public class ReservationResource extends AuditModel {

    private Long id;

    private Date reservationDate;

    private Boolean state;

}
