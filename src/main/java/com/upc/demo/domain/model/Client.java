package com.upc.demo.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Client extends User{

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

}
