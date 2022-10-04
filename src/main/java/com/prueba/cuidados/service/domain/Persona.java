package com.prueba.cuidados.service.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Persona {

    private String name;
    private Integer code;
}
