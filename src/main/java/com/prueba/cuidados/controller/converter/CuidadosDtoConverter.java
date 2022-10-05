package com.prueba.cuidados.controller.converter;

import com.prueba.cuidados.controller.dto.BalanceDto;
import com.prueba.cuidados.controller.dto.CuidadoDto;
import com.prueba.cuidados.controller.dto.PersonaDto;
import com.prueba.cuidados.service.domain.Balance;
import com.prueba.cuidados.service.domain.Cuidado;
import com.prueba.cuidados.service.domain.Persona;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface CuidadosDtoConverter {

    List<CuidadoDto> cuidadoToCuidadoDto(List<Cuidado> all);

    Cuidado cuidadoDtoToCuidado(CuidadoDto cuidado);

    List<PersonaDto> personaToPersonaDto(List<Persona> allPersonas);

    List<BalanceDto> balanceToBalanceDto(List<Balance> balance);
}
