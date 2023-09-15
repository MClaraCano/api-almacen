package com.example.trabajo.service;

import com.example.trabajo.model.Venta;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface IVentaService {
    Venta crear(Venta venta);

    List<Venta> listar();

    Venta traerVenta(Long codigoVenta) throws ChangeSetPersister.NotFoundException;

    void eliminar(Long codigoVenta);

    Venta editarVenta(Long codigoVenta, Venta venta) throws ChangeSetPersister.NotFoundException;
}
