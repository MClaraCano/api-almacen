package com.example.trabajo.controller;

import com.example.trabajo.model.Producto;
import com.example.trabajo.model.Venta;
import com.example.trabajo.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    IVentaService iVentaService;


    @PostMapping("/crear")
    ResponseEntity<Venta> crearVenta(@RequestBody Venta venta){
        Venta ventita = iVentaService.crear(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(ventita);
    }

    @GetMapping("/traer")
    ResponseEntity<List<Venta>> listarVentas(){
        return ResponseEntity.status(HttpStatus.OK).body(iVentaService.listar());
    }

    @GetMapping("/traer/{codigo_venta}")
    ResponseEntity<Venta> traerVenta(@PathVariable Long codigo_venta) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(iVentaService.traerVenta(codigo_venta));
    }

    @DeleteMapping("/borrar/{codigo_venta}")
    ResponseEntity<String> eliminarVenta(@PathVariable Long codigo_venta){
        iVentaService.eliminar(codigo_venta);
        return ResponseEntity.status(HttpStatus.OK).body("Venta con código " + codigo_venta + " fue eliminada");
    }

    @PutMapping("/editar/{codigo_venta}")
    ResponseEntity<Venta> editarVenta(@PathVariable Long codigo_venta,
                                         @RequestBody Venta venta) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(iVentaService.editarVenta(codigo_venta, venta));
    }

}
