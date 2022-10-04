package com.prueba.cuidados.service.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class Cuidado {

    private Integer parentCode;
    private String parent;
    private Integer caretakerCode;
    private String caretaker;
    private LocalDateTime beginning;
    // En minutos
    private Integer duration;
    private String description;

}
