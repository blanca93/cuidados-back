package com.prueba.cuidados.controller;

import com.prueba.cuidados.controller.converter.CuidadosDtoConverter;
import com.prueba.cuidados.controller.dto.BalanceDto;
import com.prueba.cuidados.controller.dto.CuidadoDto;
import com.prueba.cuidados.controller.dto.PersonaDto;
import com.prueba.cuidados.service.CuidadosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CuidadosController {

    private final CuidadosService service;
    private final CuidadosDtoConverter converter;

    @GetMapping("cuidados")
    public List<CuidadoDto> getAllCuidados() {
        return converter.cuidadoToCuidadoDto(service.getAllCuidados());
    }

    @GetMapping("balance")
    public List<BalanceDto> getBalance() {
        return converter.balanceToBalanceDto(service.getBalance());
    }

    @GetMapping("saldo-deudas")
    public List<CuidadoDto> getSaldo() {
        return converter.cuidadoToCuidadoDto(service.getSaldo());
    }

    @PostMapping("cuidados")
    public void saveCuidado(@Valid @RequestBody final CuidadoDto cuidado) {
        service.saveCuidado(converter.cuidadoDtoToCuidado(cuidado));
    }

    @GetMapping("personas")
    public List<PersonaDto> getAllPersonas() {
        return converter.personaToPersonaDto(service.getAllPersonas());
    }

    @PostMapping("personas")
    public void savePersona(@RequestBody final String persona) {
        service.savePersona(persona);
    }
}
