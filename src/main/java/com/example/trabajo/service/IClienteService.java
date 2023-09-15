package com.example.trabajo.service;

import com.example.trabajo.model.Cliente;
import com.example.trabajo.model.Producto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface IClienteService {
    Cliente crear(Cliente cliente);

    List<Cliente> listar();

    Cliente traerCliente(Long idCliente) throws ChangeSetPersister.NotFoundException;

    void eliminar(Long idCliente);

    Cliente editarCliente(Long idCliente, Cliente cliente) throws ChangeSetPersister.NotFoundException;
}
