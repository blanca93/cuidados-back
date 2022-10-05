package com.prueba.cuidados.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Jacksonized
@Builder
public class PersonaDto {

    private String name;
    private Integer code;

}
