package com.prueba.cuidados.repository;

import com.prueba.cuidados.repository.converter.CuidadosEntityConverter;
import com.prueba.cuidados.repository.mapper.CuidadosMapper;
import com.prueba.cuidados.service.domain.Cuidado;
import com.prueba.cuidados.service.domain.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CuidadosRepository {

    private final CuidadosMapper mapper;
    private final CuidadosEntityConverter converter;

    public List<Cuidado> getAllCuidados() {
        return converter.cuidadoEntityToCuidado(mapper.getAllCuidados());
    }

    public void saveCuidado(Cuidado cuidado) {
        mapper.saveCuidado(converter.cuidadoToCuidadoEntity(cuidado));
    }

    public void savePersona(String persona) {
        mapper.savePersona(persona);
    }

    public List<Persona> getAllPersonas() {
        return converter.personaEntityToPersona(mapper.getAllPersonas());
    }
}
