/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pdd.inventario.Inventario.Data;

import co.com.poli.pdd.inventario.Inventario.Model.Movimiento;
import co.com.poli.pdd.inventario.Inventario.Model.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public class MovimientoData {
    
    
    private static List<Movimiento> Movimientos;
    
    static {
         Movimientos = new ArrayList<Movimiento>() {
             {
                 add(new Movimiento("001", new Producto("001", "chicle", 50D, 500D),"Entrada" , 80D, 50D));
                 add(new Movimiento("002", new Producto("001", "banana", 50D, 500D),"Entrada" , 80D, 50D));
             }
         };
     }

    public static List<Movimiento> getMovimientos() {
        return Movimientos;
    }

    public static void setMovimientos(List<Movimiento> Movimientos) {
        MovimientoData.Movimientos = Movimientos;
    }
    
}
