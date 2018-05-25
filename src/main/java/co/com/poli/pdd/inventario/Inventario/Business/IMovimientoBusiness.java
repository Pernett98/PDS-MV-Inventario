/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pdd.inventario.Inventario.Business;

import co.com.poli.pdd.inventario.Inventario.Model.Movimiento;

/**
 *
 * @author Sebastian
 */
public interface IMovimientoBusiness {
    public Movimiento crearMovimiento(Movimiento movimiento);
    public Movimiento modificarMovimiento(Movimiento movimiento);
    public boolean eliminarMovimiento(String idMovimiento);
    public Double getInventario();
}
