package com.prueba.cuidados.service;

import com.prueba.cuidados.repository.CuidadosRepository;
import com.prueba.cuidados.service.domain.Balance;
import com.prueba.cuidados.service.domain.Cuidado;
import com.prueba.cuidados.service.domain.Persona;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.prueba.cuidados.constants.CuidadosConstants.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class CuidadosServiceTest {

    private final CuidadosRepository repository = mock(CuidadosRepository.class);
    private final CuidadosService sut = new CuidadosService(repository);

    @Test
    void getAllCuidadosShouldCallRepositoryAndFillInNames() {
        when(repository.getAllCuidados()).thenReturn(cuidadosWithoutNames);
        when(repository.getAllPersonas()).thenReturn(personas);

        List<Cuidado> result = sut.getAllCuidados();

        assertThat(result).isEqualTo(cuidados);
        verify(repository).getAllCuidados();
        verify(repository).getAllPersonas();
    }

    @Test
    void getAllPersonasShouldCallRepository() {
        when(repository.getAllPersonas()).thenReturn(personas);

        List<Persona> result = sut.getAllPersonas();

        assertThat(result).isEqualTo(personas);
        verify(repository).getAllPersonas();
    }

    @Test
    void saveCuidadoShouldCallRepository() {
        doNothing().when(repository).saveCuidado(cuidado);

        sut.saveCuidado(cuidado);

        verify(repository).saveCuidado(cuidado);
    }

    @Test
    void savePersonaShouldCallRepository() {
        doNothing().when(repository).savePersona(parentName);

        sut.savePersona(parentName);

        verify(repository).savePersona(parentName);
    }

    @Test
    void getBalanceShouldCalculateTimes() {
        when(repository.getAllCuidados()).thenReturn(cuidadosWithoutNames);
        when(repository.getAllPersonas()).thenReturn(personas);

        List<Balance> result = sut.getBalance();

        assertThat(result).isEqualTo(balances);
        verify(repository).getAllCuidados();
        verify(repository).getAllPersonas();
    }



}
