package com.example.trabajo.service;

import com.example.trabajo.model.Producto;
import com.example.trabajo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public Producto crear(Producto prod) {
        return productoRepository.save(prod);
    }

    @Override
    public List<Producto> listar() {
        List<Producto> listaProd = productoRepository.findAll();
        return listaProd;
    }

    @Override
    public Producto traerProducto(Long codigoProducto) {
        Producto prod = productoRepository.findById(codigoProducto).orElse(null);
        return prod;
    }


}
