package com.sura.escenario4.controller;

import com.sura.escenario4.model.Desplazamiento;
import com.sura.escenario4.service.DesplazamientoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.DateTimeException;
import java.time.LocalDate;

@RestController
@RequestMapping("/desp")
public class DesplazamientoController {

    @Autowired
    DesplazamientoServiceInterface serviceDesplaza;

    @GetMapping
    Flux<Desplazamiento> getAll(){
        return serviceDesplaza.getAll();
    }

    @PostMapping
    Mono<Desplazamiento> save(@RequestBody Desplazamiento desplazamiento){
        return serviceDesplaza.save(desplazamiento);
    }

    @GetMapping("/placa/{placa}")
    Flux<Desplazamiento> findAllByPlaca(@PathVariable("placa") String placa){
        return serviceDesplaza.findAllByPlacaIsLikeIgnoreCase(placa);
    }

    @GetMapping("/destino/{destino}")
    Flux<Desplazamiento> findAllByDestino(@PathVariable("destino") String destino){
        return serviceDesplaza.findAllByDestinoIsLike(destino);
    }

    @GetMapping("/fecha/{origen}")
    Flux<Desplazamiento> findAllByfechaOrigenGreat(@PathVariable("origen") String origen){
        return serviceDesplaza.findAllByFechaOrigenGreaterThanEqual(LocalDate.parse(origen))
                .onErrorMap(throwable ->
                    new DateTimeException("Date should be format: YYYY-MMM-dd: "+origen)
                );

    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Date should be format: YYYY-MM-dd")
    @ExceptionHandler({DateTimeException.class})
    public void handerDateTimeExepction(){}


}
