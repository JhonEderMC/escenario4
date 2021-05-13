package com.sura.escenario4.service;

import com.sura.escenario4.model.Desplazamiento;
import com.sura.escenario4.repository.DesplazamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public class DesplazamientoService implements DesplazamientoServiceInterface{

    @Autowired
    DesplazamientoRepository repository;
    @Override
    public Flux<Desplazamiento> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Desplazamiento> save(Desplazamiento desplazamiento) {
        return repository.save(desplazamiento);
    }

    @Override
    public Flux<Desplazamiento> findAllByPlacaIsLikeIgnoreCase(String placa) {
        return repository.findAllByPlacaIsLikeIgnoreCase(placa.toUpperCase());
    }

    @Override
    public Flux<Desplazamiento> findAllByDestinoIsLike(String destino) {
        return repository.findAllByDestinoIsLike(destino.toUpperCase());
    }

    @Override
    public Flux<Desplazamiento> findAllByFechaOrigenGreaterThanEqual(LocalDate date) {
        return repository.findAllByFechaOrigenGreaterThanEqual(date);
    }
}
