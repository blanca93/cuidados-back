package com.prueba.cuidados.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CuidadoEntity {

    private Integer parentCode;
    private String parent;
    private Integer caretakerCode;
    private String caretaker;
    private LocalDateTime beginning;
    // En minutos
    private Integer duration;
    private String description;

}
