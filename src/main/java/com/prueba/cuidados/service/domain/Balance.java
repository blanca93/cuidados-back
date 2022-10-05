package com.prueba.cuidados.service.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Balance {
    private String person;
    private Integer time;
}
