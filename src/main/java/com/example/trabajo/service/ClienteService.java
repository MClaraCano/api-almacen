package com.example.trabajo.service;

import com.example.trabajo.model.Producto;
import com.example.trabajo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    ClienteRepository clienteRepository;


}
