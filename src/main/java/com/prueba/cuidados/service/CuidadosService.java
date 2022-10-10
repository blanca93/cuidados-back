package com.prueba.cuidados.service;

import com.prueba.cuidados.repository.CuidadosRepository;
import com.prueba.cuidados.service.domain.Balance;
import com.prueba.cuidados.service.domain.Cuidado;
import com.prueba.cuidados.service.domain.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
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

    public List<Cuidado> getSaldo() {
        List<Cuidado> lista = new ArrayList<>();
        List<Balance> allBalances = this.getBalance();
        List<Balance> balances;
        Cuidado resolucion;

        Comparator<Balance> comparator = Comparator.comparing(x -> Math.abs(x.getTime()));

        while (allBalances.size() > 1) {
            // Ordenamos de duraciones mayores a menores en valor absoluto y quitamos los que tienen balance cero
            balances = allBalances.stream().filter(x -> x.getTime()!=0).sorted(comparator.reversed()).collect(Collectors.toList());

            if (!balances.isEmpty()) {
                Balance objetivo = balances.get(0);
                Integer biggerTime = objetivo.getTime();

                // Buscamos la primera de signo contrario que sea menor o igual en valor absoluto
                Optional<Balance> parejaFound = balances.stream().filter(x -> (Math.abs(biggerTime) >= Math.abs(x.getTime()) && Integer.signum(x.getTime()) != Integer.signum(biggerTime))).findFirst();

                if (parejaFound.isPresent()) {

                    Balance pareja = parejaFound.get();

                    int duracion = Math.min(Math.abs(biggerTime), Math.abs(pareja.getTime()));

                    if (biggerTime > 0) {
                        resolucion = Cuidado.builder().parent(objetivo.getPerson()).caretaker(pareja.getPerson()).duration(duracion).build();
                    } else {
                        resolucion = Cuidado.builder().parent(pareja.getPerson()).caretaker(objetivo.getPerson()).duration(duracion).build();
                    }
                    lista.add(resolucion);

                    // Actualizamos la lista
                    balances.get(0).setTime(objetivo.getTime() + (duracion * (-1) * Integer.signum(biggerTime)));
                    balances.get(balances.indexOf(pareja)).setTime(pareja.getTime() + duracion * Integer.signum(biggerTime));

                } else {
                    // Si ya no encontramos parejas para saldar deudas de tiempo
                    if (biggerTime > 0) {
                        resolucion = Cuidado.builder().parent(objetivo.getPerson()).duration(Math.abs(biggerTime)).build();
                    } else {
                        resolucion = Cuidado.builder().caretaker(objetivo.getPerson()).duration(Math.abs(biggerTime)).build();
                    }

                    lista.add(resolucion);
                }
            }
            allBalances = balances;
        }

        return lista;
    }
}
