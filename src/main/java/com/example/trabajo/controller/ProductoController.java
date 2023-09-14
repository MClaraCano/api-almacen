package com.example.trabajo.controller;

import com.example.trabajo.model.Producto;
import com.example.trabajo.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    IProductoService iProductoService;

    @PostMapping("/crear")
    ResponseEntity<Producto> crearProducto(@RequestBody Producto prod){
        Producto producto = iProductoService.crear(prod);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    @GetMapping("/traer")
    ResponseEntity<List<Producto>> listarProductos(){
        return ResponseEntity.status(HttpStatus.OK).body(iProductoService.listar());
    }

    @GetMapping("/traer/{codigo_producto}")
    ResponseEntity<Producto> traerProducto(@PathVariable Long codigo_producto){
        return ResponseEntity.status(HttpStatus.OK).body(iProductoService.traerProducto(codigo_producto));
    }

}
