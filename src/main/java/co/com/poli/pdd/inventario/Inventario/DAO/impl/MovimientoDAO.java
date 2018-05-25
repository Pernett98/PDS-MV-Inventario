/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pdd.inventario.Inventario.DAO.impl;

import co.com.poli.pdd.inventario.Inventario.DAO.IMovimientoDAO;
import co.com.poli.pdd.inventario.Inventario.Data.MovimientoData;
import co.com.poli.pdd.inventario.Inventario.Model.Movimiento;
import java.util.ArrayList;
import java.util.List;

public class MovimientoDAO implements IMovimientoDAO {

    @Override
    public Movimiento crearMovimiento(Movimiento movimineto) {
        List<Movimiento> listmovimientos = MovimientoData.getMovimientos();
        listmovimientos.add(movimineto);
        MovimientoData.setMovimientos(listmovimientos);
        return movimineto;
    }

    @Override
    public Movimiento modificarMovimiento(Movimiento movimineto) {
        List<Movimiento> listmovimientos = MovimientoData.getMovimientos();
        int index = listmovimientos.indexOf(movimineto);
        listmovimientos.set(index, movimineto);
        MovimientoData.setMovimientos(listmovimientos);
        return movimineto;
    }

    @Override
    public boolean eliminarMovimiento(String idMovimiento) {
        List<Movimiento> listmovimientos = MovimientoData.getMovimientos();
        int index = listmovimientos.indexOf(new Movimiento(idMovimiento, null, null, null, null));
        listmovimientos.remove(index);
        MovimientoData.setMovimientos(listmovimientos);
        return true;
    }

    @Override
    public ArrayList<Movimiento> listarMovimiento() {
        return (ArrayList<Movimiento>) MovimientoData.getMovimientos();
    }

    @Override
    public Movimiento getMovimiento(Movimiento movimiento) {
        List<Movimiento> listmovimientos = MovimientoData.getMovimientos();
        int index = listmovimientos.indexOf(movimiento);
        return listmovimientos.get(index);
    }

}
