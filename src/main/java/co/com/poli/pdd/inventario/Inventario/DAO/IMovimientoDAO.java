/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pdd.inventario.Inventario.DAO;

import co.com.poli.pdd.inventario.Inventario.Model.Movimiento;
import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public interface IMovimientoDAO {

    public Movimiento crearMovimiento(Movimiento movimineto);

    public Movimiento modificarMovimiento(Movimiento movimineto);
    
    public boolean eliminarMovimiento(String idMovimiento);

    public ArrayList<Movimiento> listarMovimiento();
    
    public Movimiento getMovimiento(Movimiento movimiento);
}
