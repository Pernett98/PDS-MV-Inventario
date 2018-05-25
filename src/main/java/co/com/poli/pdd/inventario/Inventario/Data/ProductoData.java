package co.com.poli.pdd.inventario.Inventario.Data;

import co.com.poli.pdd.inventario.Inventario.Model.Producto;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sebastian
 */
public class ProductoData {
    
     private static List<Producto> listaProductos;
 
     static {
         listaProductos = new ArrayList<Producto>() {
             {
                 add(new Producto("001", "chicle", 80D, 500D));
                 add(new Producto("002", "banana", 20D, 200D));
                 add(new Producto("003", "papas", 15D, 1500D));
                 add(new Producto("004", "chocolate", 5D, 200D));
                 add(new Producto("005", "leche", 80D, 300D));
             }
         };
     }
 
     public static List<Producto> getListaProductos() {
         return listaProductos;
     }
 
     public static void setListaPedidos(List<Producto> listaProductos) {
         ProductoData.listaProductos = listaProductos;
     }
    
}
