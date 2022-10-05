package com.prueba.cuidados.controller;

import com.prueba.cuidados.controller.converter.CuidadosDtoConverter;
import com.prueba.cuidados.controller.dto.BalanceDto;
import com.prueba.cuidados.controller.dto.CuidadoDto;
import com.prueba.cuidados.controller.dto.PersonaDto;
import com.prueba.cuidados.service.CuidadosService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.prueba.cuidados.constants.CuidadosConstants.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class CuidadosControllerTest {

    private final CuidadosService service = mock(CuidadosService.class);
    private final CuidadosDtoConverter converter = mock(CuidadosDtoConverter.class);
    private final CuidadosController sut = new CuidadosController(service, converter);


    @Test
    void getAllCuidadosShouldCallConverterAndService() {
        when(service.getAllCuidados()).thenReturn(cuidados);
        when(converter.cuidadoToCuidadoDto(cuidados)).thenReturn(cuidadosDto);

        List<CuidadoDto> result = sut.getAllCuidados();

        assertThat(result).isEqualTo(cuidadosDto);
        verify(converter).cuidadoToCuidadoDto(cuidados);
        verify(service).getAllCuidados();
    }

    @Test
    void getBalanceShouldCallConverterAndService() {
        when(service.getBalance()).thenReturn(balances);
        when(converter.balanceToBalanceDto(balances)).thenReturn(balancesDto);

        List<BalanceDto> result = sut.getBalance();

        assertThat(result).isEqualTo(balancesDto);
        verify(converter).balanceToBalanceDto(balances);
        verify(service).getBalance();
    }

    @Test
    void saveCuidadoShouldCallConverterAndService() {
        doNothing().when(service).saveCuidado(cuidado);
        when(converter.cuidadoDtoToCuidado(cuidadoDto)).thenReturn(cuidado);

        sut.saveCuidado(cuidadoDto);

        verify(converter).cuidadoDtoToCuidado(cuidadoDto);
        verify(service).saveCuidado(cuidado);
    }

    @Test
    void getAllPersonasShouldCallConverterAndService() {
        when(service.getAllPersonas()).thenReturn(personas);
        when(converter.personaToPersonaDto(personas)).thenReturn(personasDto);

        List<PersonaDto> result = sut.getAllPersonas();

        assertThat(result).isEqualTo(personasDto);
        verify(converter).personaToPersonaDto(personas);
        verify(service).getAllPersonas();
    }

    @Test
    void savePersonaShouldCallService() {
        doNothing().when(service).savePersona(parentName);

        sut.savePersona(parentName);

        verify(service).savePersona(parentName);
    }
}
