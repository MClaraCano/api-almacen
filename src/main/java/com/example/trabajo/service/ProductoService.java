package com.example.trabajo.service;

import com.example.trabajo.model.Producto;
import com.example.trabajo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public Producto crear(Producto prod) throws NullPointerException {
        if (prod.getNombre() == null || prod.getNombre() == "" || prod.getCosto() == null || prod.getCantidad_disponible() == null){
            throw new NullPointerException();
        }
        return productoRepository.save(prod);
    }

    @Override
    public List<Producto> listar() {
        List<Producto> listaProd = productoRepository.findAll();
        return listaProd;
    }

    @Override
    public Producto traerProducto(Long codigoProducto) throws ChangeSetPersister.NotFoundException {
        Producto prod = productoRepository.findById(codigoProducto).orElse(null);
        if (prod == null){
            throw new ChangeSetPersister.NotFoundException();
        }
        return prod;
    }

    @Override
    public void eliminar(Long codigoProducto) {
        productoRepository.deleteById(codigoProducto);
    }

    @Override
    public Producto editarProducto(Long codigoProducto, Producto producto) throws ChangeSetPersister.NotFoundException {
        Producto produOriginal = this.traerProducto(codigoProducto);

        producto.setCodigo_producto(produOriginal.getCodigo_producto());
        this.crear(producto);

        return producto;
    }


}
