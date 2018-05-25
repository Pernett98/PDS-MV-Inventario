/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pdd.inventario.Inventario.DAO.impl;

import co.com.poli.pdd.inventario.Inventario.DAO.IProductoDAO;
import co.com.poli.pdd.inventario.Inventario.Data.ProductoData;
import co.com.poli.pdd.inventario.Inventario.Model.Producto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sebastian
 */
@Repository
public class ProductoDAO implements IProductoDAO {

    @Override
    public Producto crearProducto(Producto producto) {
        List<Producto> listproductos = ProductoData.getListaProductos();
        listproductos.add(producto);
        ProductoData.setListaPedidos(listproductos);
        return producto;
    }

    @Override
    public Producto modificarProducto(Producto producto) {
        List<Producto> listproductos = ProductoData.getListaProductos();
        int index = listproductos.indexOf(producto);
        listproductos.set(index, producto);
        ProductoData.setListaPedidos(listproductos);
        return producto;
    }

    @Override
    public ArrayList<Producto> listarProducto() {
        return (ArrayList<Producto>) ProductoData.getListaProductos();
    }

    @Override
    public boolean productoExite(Producto producto) {
        List<Producto> listproductos = ProductoData.getListaProductos();
        return listproductos.contains(producto);
    }

    @Override
    public Producto getProducto(Producto producto) {
        List<Producto> listproductos = ProductoData.getListaProductos();
        int index = listproductos.indexOf(producto);
        return listproductos.get(index);
    }

}
