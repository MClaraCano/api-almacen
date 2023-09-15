package com.example.trabajo.service;

import com.example.trabajo.model.Producto;
import com.example.trabajo.model.Venta;
import com.example.trabajo.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    VentaRepository ventaRepository;

    @Override
    public Venta crear(Venta venta) throws NullPointerException{
        if (venta.getFecha_venta() == null || venta.getTotal() == null || venta.getUncliente() == null || venta.getListaProductos() == null){
            throw new NullPointerException();
        }
        return ventaRepository.save(venta);
    }

    @Override
    public List<Venta> listar() {
        List<Venta> listaVentas = ventaRepository.findAll();
        return listaVentas;
    }

    @Override
    public Venta traerVenta(Long codigoVenta) throws ChangeSetPersister.NotFoundException {
        Venta prod = ventaRepository.findById(codigoVenta).orElse(null);
        if (prod == null){
            throw new ChangeSetPersister.NotFoundException();
        }
        return prod;
    }

    @Override
    public void eliminar(Long codigoVenta) {
        ventaRepository.deleteById(codigoVenta);
    }

    @Override
    public Venta editarVenta(Long codigoVenta, Venta venta) throws ChangeSetPersister.NotFoundException {
        Venta ventaOriginal = this.traerVenta(codigoVenta);

        venta.setCodigo_venta(ventaOriginal.getCodigo_venta());
        this.crear(venta);

        return venta;
    }
}
