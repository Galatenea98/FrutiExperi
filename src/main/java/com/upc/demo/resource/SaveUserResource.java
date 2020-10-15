package com.upc.demo.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter@Setter
public class SaveUserResource {

    @NotNull @NotBlank
    private String name;

    @NotNull @NotBlank
    private String lastName;

    @NotNull @NotBlank
    private String email;

    @NotNull @NotBlank
    private String password;

    @NotNull @NotBlank
    private Integer phone;
}
