/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pdd.inventario.Inventario.Business;

import co.com.poli.pdd.inventario.Inventario.Model.Producto;

/**
 *
 * @author Sebastian
 */
public interface IProductoBusiness {
    public Producto crearProducto(Producto producto);
    public Producto modificarProducto(Producto producto);
}
