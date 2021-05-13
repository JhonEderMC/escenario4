package com.sura.escenario4.repository;

import com.sura.escenario4.model.Desplazamiento;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

public interface DesplazamientoRepository extends ReactiveCrudRepository<Desplazamiento, String> {
    Flux<Desplazamiento> findAllByPlacaIsLikeIgnoreCase(String placa);
    Flux<Desplazamiento> findAllByDestinoIsLike(String destino);
    Flux<Desplazamiento> findAllByFechaOrigenGreaterThanEqual(LocalDate date);
}
