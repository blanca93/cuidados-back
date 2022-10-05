package com.prueba.cuidados.repository;

import com.prueba.cuidados.repository.converter.CuidadosEntityConverter;
import com.prueba.cuidados.repository.mapper.CuidadosMapper;
import com.prueba.cuidados.service.domain.Cuidado;
import com.prueba.cuidados.service.domain.Persona;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.prueba.cuidados.constants.CuidadosConstants.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class CuidadosRepositoryTest {

    private final CuidadosMapper mapper = mock(CuidadosMapper.class);
    private final CuidadosEntityConverter converter = mock(CuidadosEntityConverter.class);
    private final CuidadosRepository sut = new CuidadosRepository(mapper, converter);

    @Test
    void getAllCuidadosShouldCallConverterAndMapper() {
        when(converter.cuidadoEntityToCuidado(cuidadosEntity)).thenReturn(cuidados);
        when(mapper.getAllCuidados()).thenReturn(cuidadosEntity);

        List<Cuidado> result = sut.getAllCuidados();

        assertThat(result).isEqualTo(cuidados);
        verify(converter).cuidadoEntityToCuidado(cuidadosEntity);
        verify(mapper).getAllCuidados();
    }

    @Test
    void getAllPersonasShouldCallConverterAndMapper() {
        when(converter.personaEntityToPersona(personasEntity)).thenReturn(personas);
        when(mapper.getAllPersonas()).thenReturn(personasEntity);

        List<Persona> result = sut.getAllPersonas();

        assertThat(result).isEqualTo(personas);
        verify(converter).personaEntityToPersona(personasEntity);
        verify(mapper).getAllPersonas();
    }

    @Test
    void saveCuidadoShouldCallConverterAndMapper() {
        when(converter.cuidadoToCuidadoEntity(cuidado)).thenReturn(cuidadoEntity);
        doNothing().when(mapper).saveCuidado(cuidadoEntity);

        sut.saveCuidado(cuidado);

        verify(converter).cuidadoToCuidadoEntity(cuidado);
        verify(mapper).saveCuidado(cuidadoEntity);
    }

    @Test
    void savePersonaShouldCallMapper() {
        doNothing().when(mapper).savePersona(parentName);

        sut.savePersona(parentName);

        verify(mapper).savePersona(parentName);
    }

}
