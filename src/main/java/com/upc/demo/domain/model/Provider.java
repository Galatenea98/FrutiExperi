package com.upc.demo.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "providers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Provider  {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String calification;
}
