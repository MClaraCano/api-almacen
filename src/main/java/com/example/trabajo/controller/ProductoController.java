package com.example.trabajo.controller;

import com.example.trabajo.model.Producto;
import com.example.trabajo.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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
    ResponseEntity<Producto> traerProducto(@PathVariable Long codigo_producto) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(iProductoService.traerProducto(codigo_producto));
    }

    @DeleteMapping("/borrar/{codigo_producto}")
    ResponseEntity<String> eliminarProducto(@PathVariable Long codigo_producto){
        iProductoService.eliminar(codigo_producto);
        return ResponseEntity.status(HttpStatus.OK).body("Producto con código " + codigo_producto + " fue eliminado");
    }

    @PutMapping("/editar/{codigo_producto}")
    ResponseEntity<Producto> editarProdu(@PathVariable Long codigo_producto,
                                         @RequestBody Producto producto) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(iProductoService.editarProducto(codigo_producto, producto));
    }

}
