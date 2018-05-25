/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pdd.inventario.Inventario.Business.impl;

import co.com.poli.pdd.inventario.Inventario.Business.IMovimientoBusiness;
import co.com.poli.pdd.inventario.Inventario.DAO.IMovimientoDAO;
import co.com.poli.pdd.inventario.Inventario.DAO.IProductoDAO;
import co.com.poli.pdd.inventario.Inventario.Model.Movimiento;
import co.com.poli.pdd.inventario.Inventario.Model.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian
 */
@Service
public class MovimientoBusiness implements IMovimientoBusiness {

    @Autowired
    private IMovimientoDAO movimientoDAO;

    @Autowired
    private IProductoDAO productoDAO;

    @Override
    public Movimiento crearMovimiento(Movimiento movimiento) {
        List<Movimiento> listMovimiento = movimientoDAO.listarMovimiento();
        if (listMovimiento.contains(movimiento)) {
            return null;
        } else {
            switch (movimiento.getTipoMovimiento()) {
                case "Entrada":
                    if (validarEntrada(movimiento)) {
                        return movimientoDAO.crearMovimiento(movimiento);
                    }
                    break;
                case "Salida":
                    if (validarSalida(movimiento)) {
                        movimiento.setPrecio(0D);
                        return movimientoDAO.crearMovimiento(movimiento);
                    }
                    break;
                default:
                    break;
            }
            return null;
        }
    }

    @Override
    public Movimiento modificarMovimiento(Movimiento movimiento) {
        List<Movimiento> listMovimiento = movimientoDAO.listarMovimiento();
        Movimiento movientoAntes = movimientoDAO.getMovimiento(movimiento);
        if (!listMovimiento.contains(movimiento)) {
            return null;
        } else {
            if (movientoAntes.getTipoMovimiento().equals(movimiento.getTipoMovimiento())) {
                switch (movimiento.getTipoMovimiento()) {
                    case "Entrada":
                        if (validarEntrada(movimiento)) {
                            return movimientoDAO.crearMovimiento(movimiento);
                        }
                        break;
                    case "Salida":
                        if (validarSalida(movimiento)) {
                            movimiento.setPrecio(0D);
                            return movimientoDAO.crearMovimiento(movimiento);
                        }
                        break;
                    default:
                        break;
                }
            }
            return null;
        }
    }

    @Override
    public boolean eliminarMovimiento(String idMovimiento) {
        List<Movimiento> listMovimiento = movimientoDAO.listarMovimiento();
        Movimiento movientoAntes = movimientoDAO.getMovimiento(new Movimiento(idMovimiento, null, null, null, null));
        if (!listMovimiento.contains(movientoAntes)) {
            return false;
        } else {
            Producto producto = movientoAntes.getProducto();
            switch (movientoAntes.getTipoMovimiento()) {
                case "Entrada":
                    producto.setExistencia(producto.getExistencia() - movientoAntes.getCantidad());
                    productoDAO.modificarProducto(producto);
                    break;
                case "Salida":
                    producto.setExistencia(producto.getExistencia() + movientoAntes.getCantidad());
                    productoDAO.modificarProducto(producto);
                    break;
                default:
                    break;
            }
            return movimientoDAO.eliminarMovimiento(movientoAntes.getIdMovimiento());
        }
    }

    public Double getInventario() {
        List<Movimiento> listMovimiento = movimientoDAO.listarMovimiento();
    }

    private boolean validarEntrada(Movimiento movimiento) {
        if (movimiento.getPrecio() > 0 && productoDAO.productoExite(movimiento.getProducto())) {
            Producto prod = productoDAO.getProducto(movimiento.getProducto());
            prod.setExistencia(prod.getExistencia() + movimiento.getCantidad());
            productoDAO.modificarProducto(prod);
            return true;
        } else {
            return false;
        }
    }

    private boolean validarSalida(Movimiento movimiento) {
        Producto prod = productoDAO.getProducto(movimiento.getProducto());
        if (prod != null && prod.getExistencia() < movimiento.getCantidad() && movimiento.getCantidad() > 0) {
            Double nuevaExistencia = prod.getExistencia() - movimiento.getCantidad();
            if (nuevaExistencia >= 0) {
                prod.setExistencia(nuevaExistencia);
                productoDAO.modificarProducto(prod);
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

}
