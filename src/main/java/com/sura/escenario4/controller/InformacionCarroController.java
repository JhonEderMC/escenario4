package com.sura.escenario4.controller;

import com.sura.escenario4.model.InformacionCarro;
import com.sura.escenario4.service.InformacionCarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @PutMapping
    Mono<InformacionCarro>update(@RequestBody InformacionCarro carro) {
        return carroService.findByPlacaLike(carro.getPlaca())
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No car info found with this placa")))
                .flatMap(carro1 -> carroService.save(carro))
                .single();
    }

    @DeleteMapping("/{placa}")
    Mono<Void> delete(@PathVariable("placa") String placa){
        return carroService.delete(placa.toUpperCase());
    }


    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "There is not element stored with that placa")
    @ExceptionHandler({IllegalArgumentException.class})
    public void handelIlegalArgumentExeption(){
    }

}
