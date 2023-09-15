package com.example.trabajo.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServiceAdvice {

    @ExceptionHandler(value = ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<FaltaId> errorEnId(ChangeSetPersister.NotFoundException e) {
        FaltaId faltaId = FaltaId.builder()
                //.idIncorrecto(Long id)
                .mensaje("No se encontró el ID en la Base de Datos")
                .build();
        return new ResponseEntity<>(faltaId, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<FaltanDatos> completarDatos(NullPointerException e){
        FaltanDatos faltanDatos = FaltanDatos.builder()
                .mensaje("Faltan datos: Nombre, Cantidad y/o Costo")
                .build();
        return new ResponseEntity<>(faltanDatos, HttpStatus.BAD_REQUEST);
    }




}
