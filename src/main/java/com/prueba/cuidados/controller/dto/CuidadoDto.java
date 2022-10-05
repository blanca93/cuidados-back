package com.prueba.cuidados.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Jacksonized
@Builder
public class CuidadoDto {

    @NotNull
    private Integer parentCode;
    private String parent;
    @NotNull
    private Integer caretakerCode;
    private String caretaker;
    @NotNull
    private LocalDateTime beginning;
    // En minutos
    @NotNull
    private Integer duration;
    private String description;

}
