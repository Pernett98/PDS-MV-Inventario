/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pdd.inventario.Inventario.DAO;

import co.com.poli.pdd.inventario.Inventario.Model.Producto;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public interface IProductoDAO {

    public Producto crearProducto(Producto producto);

    public Producto modificarProducto(Producto producto);

    public ArrayList<Producto> listarProducto();
    
    public boolean productoExite(Producto producto);
    
    public Producto getProducto(Producto producto);
}
