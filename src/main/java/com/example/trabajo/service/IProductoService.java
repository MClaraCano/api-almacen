package com.example.trabajo.service;

import com.example.trabajo.model.Producto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface IProductoService {
    Producto crear(Producto prod);

    List<Producto> listar();

    Producto traerProducto(Long codigoProducto) throws ChangeSetPersister.NotFoundException;

    void eliminar(Long codigoProducto);

    Producto editarProducto(Long codigoProducto, Producto producto) throws ChangeSetPersister.NotFoundException;
}
