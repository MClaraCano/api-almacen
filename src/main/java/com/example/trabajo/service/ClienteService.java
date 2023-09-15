package com.example.trabajo.service;

import com.example.trabajo.model.Cliente;
import com.example.trabajo.model.Producto;
import com.example.trabajo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    ClienteRepository clienteRepository;


    @Override
    public Cliente crear(Cliente cliente) throws NullPointerException {
        if (cliente.getNombre() == null || cliente.getNombre() == "" || cliente.getDni() == null || cliente.getApellido() == null || cliente.getApellido() == "") {
            throw new NullPointerException();
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> listaCli = clienteRepository.findAll();
        return listaCli;
    }

    @Override
    public Cliente traerCliente(Long idCliente) throws ChangeSetPersister.NotFoundException {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        if (cliente == null) {
            throw new ChangeSetPersister.NotFoundException();
        }
        return cliente;
    }

    @Override
    public void eliminar (Long idCliente){
        clienteRepository.deleteById(idCliente);
    }

    @Override
    public Cliente editarCliente (Long idCliente, Cliente cliente) throws ChangeSetPersister.NotFoundException {
        Cliente clienteOriginal = this.traerCliente(idCliente);

        cliente.setId_cliente(clienteOriginal.getId_cliente());
        this.crear(cliente);

        return cliente;

    }
    }
