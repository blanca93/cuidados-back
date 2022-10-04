package com.prueba.cuidados.service;

import com.prueba.cuidados.repository.CuidadosRepository;
import com.prueba.cuidados.service.domain.Cuidado;
import com.prueba.cuidados.service.domain.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CuidadosService {

    private final CuidadosRepository repository;

    public List<Cuidado> getAllCuidados() {
        return repository.getAllCuidados();
    }

    public void saveCuidado(Cuidado cuidado) {
        repository.saveCuidado(cuidado);
    }

    public void savePersona(String persona) {
        repository.savePersona(persona);
    }

    public List<Persona> getAllPersonas() {
        return repository.getAllPersonas();
    }
}
