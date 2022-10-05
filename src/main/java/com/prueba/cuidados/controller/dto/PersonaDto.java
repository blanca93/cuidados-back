package com.prueba.cuidados.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder
public class PersonaDto {

    private String name;
    private Integer code;

}
