package com.sura.escenario4.repository;

import com.sura.escenario4.model.InformacionCarro;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface InformacionCarroRepository extends ReactiveCrudRepository<InformacionCarro, String> {
    Flux<InformacionCarro> findAllByPlacaIsLike(String placa);

}
