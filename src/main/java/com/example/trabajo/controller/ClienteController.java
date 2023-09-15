package com.example.trabajo.controller;

import com.example.trabajo.model.Cliente;
import com.example.trabajo.model.Producto;
import com.example.trabajo.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    IClienteService iClienteService;

    @PostMapping("/crear")
    ResponseEntity<Cliente> crearProducto(@RequestBody Cliente cliente){
        Cliente cli = iClienteService.crear(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cli);
    }

    @GetMapping("/traer")
    ResponseEntity<List<Cliente>> listarClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(iClienteService.listar());
    }

    @GetMapping("/traer/{id_cliente}")
    ResponseEntity<Cliente> traerCliente(@PathVariable Long id_cliente) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(iClienteService.traerCliente(id_cliente));
    }

    @DeleteMapping("/borrar/{id_cliente}")
    ResponseEntity<String> eliminarCliente(@PathVariable Long id_cliente){
        iClienteService.eliminar(id_cliente);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente con ID: " + id_cliente + ", fue eliminado");
    }

    @PutMapping("/editar/{id_cliente}")
    ResponseEntity<Cliente> editarProdu(@PathVariable Long id_cliente,
                                         @RequestBody Cliente cliente) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(iClienteService.editarCliente(id_cliente, cliente));
    }

}
