package com.prueba.cuidados.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder
public class BalanceDto {
    private String person;
    private Integer time;
}
