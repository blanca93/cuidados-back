package com.prueba.cuidados.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Data
@Jacksonized
@Builder
public class CuidadoDto {

    private Integer parentCode;
    private String parent;
    private Integer caretakerCode;
    private String caretaker;
    private LocalDateTime beginning;
    // En minutos
    private Integer duration;
    private String description;

}
