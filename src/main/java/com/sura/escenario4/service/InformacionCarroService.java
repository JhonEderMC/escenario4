package com.sura.escenario4.service;

import com.sura.escenario4.model.InformacionCarro;
import com.sura.escenario4.repository.InformacionCarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Locale;

@Service
public class InformacionCarroService implements  InformacionCarroServiceInterface{

    @Autowired
    InformacionCarroRepository carroRepository;

    public Flux<InformacionCarro> getAll(){
        return carroRepository.findAll();

    }
    @Override
    public Mono<InformacionCarro> save(InformacionCarro carro) {
        return carroRepository.save(carro)
                .map(car ->{
                    car.setPlaca(car.getPlaca().toUpperCase(Locale.ROOT));
                    car.setMarca(car.getMarca().toUpperCase(Locale.ROOT));
                    car.setModelo(car.getModelo().toUpperCase(Locale.ROOT));
                  return car;
                });
                //.switchIfEmpty(Mono.error(new IllegalArgumentException("The car information is required")));
    }

    @Override
    public Flux<InformacionCarro> findByPlacaLike(String placa) {
        return carroRepository.findAllByPlacaIsLike(placa);
                //.switchIfEmpty(Mono.error(new IllegalArgumentException("There are not car information with that placa")));
    }
}
