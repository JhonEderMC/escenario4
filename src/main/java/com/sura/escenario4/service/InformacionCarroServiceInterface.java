package com.sura.escenario4.service;

import com.sura.escenario4.model.InformacionCarro;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InformacionCarroServiceInterface {
    Mono<InformacionCarro> save(InformacionCarro carro);
    Flux<InformacionCarro> findByPlacaLike(String placa);
    Flux<InformacionCarro> findByMarcaLike(String marca);
}
