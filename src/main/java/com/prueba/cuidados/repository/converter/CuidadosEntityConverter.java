package com.prueba.cuidados.repository.converter;

import com.prueba.cuidados.repository.entity.CuidadoEntity;
import com.prueba.cuidados.repository.entity.PersonaEntity;
import com.prueba.cuidados.service.domain.Cuidado;
import com.prueba.cuidados.service.domain.Persona;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CuidadosEntityConverter {


    List<Cuidado> cuidadoEntityToCuidado(List<CuidadoEntity> allCuidados);

    CuidadoEntity cuidadoToCuidadoEntity(Cuidado cuidado);

    PersonaEntity personaToPersonaEntity(Persona persona);

    List<Persona> personaEntityToPersona(List<PersonaEntity> allPersonas);
}
