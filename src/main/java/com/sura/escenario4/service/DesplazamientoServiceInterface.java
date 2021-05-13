package com.sura.escenario4.service;

import com.sura.escenario4.model.Desplazamiento;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface DesplazamientoServiceInterface {
    Flux<Desplazamiento> getAll();
    Mono<Desplazamiento> save(Desplazamiento desplazamiento);
    Flux<Desplazamiento> findAllByPlacaIsLikeIgnoreCase(String placa);
    Flux<Desplazamiento> findAllByDestinoIsLike(String destino);
    Flux<Desplazamiento> findAllByFechaOrigenGreaterThanEqual(LocalDate date);
}
