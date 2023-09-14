package com.example.trabajo.service;

import com.example.trabajo.model.Producto;

import java.util.List;

public interface IProductoService {
    Producto crear(Producto prod);

    List<Producto> listar();

    Producto traerProducto(Long codigoProducto);
}
