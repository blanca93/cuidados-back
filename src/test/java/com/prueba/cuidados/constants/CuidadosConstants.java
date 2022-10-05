package com.prueba.cuidados.constants;

import com.prueba.cuidados.controller.dto.BalanceDto;
import com.prueba.cuidados.controller.dto.CuidadoDto;
import com.prueba.cuidados.controller.dto.PersonaDto;
import com.prueba.cuidados.repository.entity.CuidadoEntity;
import com.prueba.cuidados.repository.entity.PersonaEntity;
import com.prueba.cuidados.service.domain.Balance;
import com.prueba.cuidados.service.domain.Cuidado;
import com.prueba.cuidados.service.domain.Persona;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CuidadosConstants {

    public static final String parentName = "parent";
    private static final Integer parentCode = 1;
    private static final String caretakerName = "caretaker";
    private static final Integer caretakerCode = 2;
    private static final LocalDateTime beginning = LocalDateTime.parse("2018-10-10T11:25");
    private static final Integer duration = 90;


    public static final Cuidado cuidado = Cuidado.builder().parent(parentName).parentCode(parentCode).caretaker(caretakerName)
            .caretakerCode(caretakerCode).beginning(beginning).duration(duration).build();
    public static final List<Cuidado> cuidados = Collections.singletonList(cuidado);

    public static final Cuidado cuidadoWithoutNames = Cuidado.builder().parentCode(parentCode)
            .caretakerCode(caretakerCode).beginning(beginning).duration(duration).build();
    public static final List<Cuidado> cuidadosWithoutNames = Collections.singletonList(cuidadoWithoutNames);

    public static final CuidadoDto cuidadoDto = CuidadoDto.builder().parent(parentName).parentCode(parentCode).caretaker(caretakerName)
            .caretakerCode(caretakerCode).beginning(beginning).duration(duration).build();
    public static final List<CuidadoDto> cuidadosDto = Collections.singletonList(cuidadoDto);

    public static final CuidadoEntity cuidadoEntity = CuidadoEntity.builder().parent(parentName).parentCode(parentCode).caretaker(caretakerName)
            .caretakerCode(caretakerCode).beginning(beginning).duration(duration).build();
    public static final List<CuidadoEntity> cuidadosEntity = Collections.singletonList(cuidadoEntity);

    public static final Persona persona1 = Persona.builder().name(parentName).code(parentCode).build();
    public static final Persona persona2 = Persona.builder().name(caretakerName).code(caretakerCode).build();
    public static final List<Persona> personas = Arrays.asList(persona1, persona2);

    public static final PersonaDto personaDto = PersonaDto.builder().name(parentName).code(parentCode).build();
    public static final List<PersonaDto> personasDto = Collections.singletonList(personaDto);

    public static final PersonaEntity personaEntity = PersonaEntity.builder().name(parentName).code(parentCode).build();
    public static final List<PersonaEntity> personasEntity = Collections.singletonList(personaEntity);

    public static final Balance balance1 = Balance.builder().person(parentName).time((-1) * duration).build();
    public static final Balance balance2 = Balance.builder().person(caretakerName).time(duration).build();
    public static final List<Balance> balances = Arrays.asList(balance1, balance2);

    public static final BalanceDto balanceDto1 = BalanceDto.builder().person(parentName).time((-1) * duration).build();
    public static final BalanceDto balanceDto2 = BalanceDto.builder().person(caretakerName).time(duration).build();
    public static final List<BalanceDto> balancesDto = Arrays.asList(balanceDto1, balanceDto2);

}
