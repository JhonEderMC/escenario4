package com.sura.escenario4.controller;

import com.sura.escenario4.model.InformacionCarro;
import com.sura.escenario4.service.InformacionCarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Locale;

@RestController
@RequestMapping("/carinfo")
public class InformacionCarroController {

    @Autowired
    InformacionCarroService carroService;

    @GetMapping
    Flux<InformacionCarro> getAll(){
        return carroService.getAll();
    }

    @GetMapping("/placa/{placa}")
    Flux<InformacionCarro> findByPlaca(@PathVariable("placa") String placa){
        return carroService.findByPlacaLike(placa);
    }

    @GetMapping("/marca/{marca}")
    Flux<InformacionCarro> findByMarca(@PathVariable("marca") String marca){
        return carroService.findByMarcaLike(marca);
    }

    @PostMapping
    Mono<InformacionCarro> save(@RequestBody InformacionCarro carro){
        return carroService.save(carro);
    }

}
