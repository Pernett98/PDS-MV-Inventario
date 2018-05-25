/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pdd.inventario.Inventario.Business.impl;

import co.com.poli.pdd.inventario.Inventario.Business.IProductoBusiness;
import co.com.poli.pdd.inventario.Inventario.DAO.IProductoDAO;
import co.com.poli.pdd.inventario.Inventario.Model.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian
 */
@Service
public class ProductoBusiness implements IProductoBusiness{

    @Autowired
    private IProductoDAO productoDAO;
    
    @Override
    public Producto crearProducto(Producto producto) {
        List<Producto> listProducto = productoDAO.listarProducto();
        if (listProducto.contains(producto)) {
            return null;
        }else{
            return productoDAO.crearProducto(producto);
        }
    }

    @Override
    public Producto modificarProducto(Producto producto) {
        List<Producto> listProducto = productoDAO.listarProducto();
        if (!listProducto.contains(producto)) {
            return null;
        }else{
            return productoDAO.modificarProducto(producto);
        }
    }
    
}
