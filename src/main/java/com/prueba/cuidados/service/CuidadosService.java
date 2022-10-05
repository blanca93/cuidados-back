package com.prueba.cuidados.service;

import com.prueba.cuidados.repository.CuidadosRepository;
import com.prueba.cuidados.service.domain.Balance;
import com.prueba.cuidados.service.domain.Cuidado;
import com.prueba.cuidados.service.domain.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CuidadosService {

    private final CuidadosRepository repository;

    public List<Cuidado> getAllCuidados() {
        List<Cuidado> cuidados = repository.getAllCuidados();
        List<Persona> personas = repository.getAllPersonas();
        cuidados.forEach(x -> x.setParent(personas.stream().filter(y -> Objects.equals(y.getCode(), x.getParentCode())).findFirst().get().getName()));
        cuidados.forEach(x -> x.setCaretaker(personas.stream().filter(y -> Objects.equals(y.getCode(), x.getCaretakerCode())).findFirst().get().getName()));
        return cuidados;
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

    public List<Balance> getBalance() {
        List<Cuidado> cuidados = repository.getAllCuidados();
        List<Persona> personas = repository.getAllPersonas();
        List<Balance> balances = new ArrayList<>();
        personas.forEach(x -> {
            Balance balance = Balance.builder().person(x.getName()).build();
            List<Cuidado> negatives = cuidados.stream().filter(y -> y.getParentCode().equals(x.getCode())).collect(Collectors.toList());
            List<Cuidado> positives = cuidados.stream().filter(y -> y.getCaretakerCode().equals(x.getCode())).collect(Collectors.toList());
            AtomicReference<Integer> time = new AtomicReference<>(0);
            positives.forEach(z -> time.updateAndGet(v -> v + z.getDuration()));
            negatives.forEach(z -> time.updateAndGet(v -> v - z.getDuration()));
            balance.setTime(time.get());
            balances.add(balance);
        });
        return balances;
    }
}
