package com.example.trabajo.service;

import com.example.trabajo.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{

    @Autowired
    VentaRepository ventaRepository;
}
