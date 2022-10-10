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
    private static final String ADA = "Ada Lovelace";
    private static final String ALAN = "Alan Turing";
    private static final String ANGELA = "Angela Ruiz Robles";
    private static final String HEDY = "Hedy Lamarr";


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

    // getSaldo
    public static final Balance balanceA = Balance.builder().person(ADA).time(-90).build();
    public static final Balance balanceB = Balance.builder().person(ALAN).time(-60).build();
    public static final Balance balanceC = Balance.builder().person(ANGELA).time(120).build();
    public static final Balance balanceD = Balance.builder().person(HEDY).time(30).build();
    public static final List<Balance> balancesExercise1 = Arrays.asList(balanceA, balanceB, balanceC, balanceD);

    public static final Cuidado cuidado1 = Cuidado.builder().caretaker(ADA).parent(ANGELA).duration(90).build();
    public static final Cuidado cuidado2 = Cuidado.builder().caretaker(ALAN).parent(ANGELA).duration(30).build();
    public static final Cuidado cuidado3 = Cuidado.builder().caretaker(ALAN).parent(HEDY).duration(30).build();
    public static final List<Cuidado> cuidadosExercise1 = Arrays.asList(cuidado1, cuidado2, cuidado3);

    public static final Balance balanceE = Balance.builder().person(ADA).time(-120).build();
    public static final List<Balance> balancesExercise2 = Arrays.asList(balanceB, balanceC, balanceD, balanceE);

    public static final Cuidado cuidadoA = Cuidado.builder().caretaker(ADA).parent(ANGELA).duration(120).build();
    public static final Cuidado cuidadoB = Cuidado.builder().caretaker(ALAN).parent(HEDY).duration(30).build();
    public static final Cuidado cuidadoC = Cuidado.builder().caretaker(ALAN).duration(30).build();
    public static final List<Cuidado> cuidadosExercise2 = Arrays.asList(cuidadoA, cuidadoB, cuidadoC);

}
