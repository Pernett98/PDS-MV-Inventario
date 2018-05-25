/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pdd.inventario.Inventario.Controller;

import co.com.poli.pdd.inventario.Inventario.Business.IMovimientoBusiness;
import co.com.poli.pdd.inventario.Inventario.Model.Movimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sebastian
 */
@RestController
@RequestMapping(value = "/")
public class MovimientoController {

    @Autowired
    private IMovimientoBusiness movimientoBusiness;

    @PostMapping("/movimientos")
    public Movimiento crearProducto(@RequestBody Movimiento movimiento) {
        return movimientoBusiness.crearMovimiento(movimiento);
    }

    @PutMapping("/movimientos")
    public Movimiento modificarProducto(@RequestBody Movimiento movimiento) {
        return movimientoBusiness.modificarMovimiento(movimiento);
    }

    @DeleteMapping("/movimientos/{id}")
    public boolean modificarProducto(@PathVariable(value = "id") String id) {
        return movimientoBusiness.eliminarMovimiento(id);
    }

    @GetMapping("/movimientos/inventario")
    public Double getInventario() {
        return movimientoBusiness.getInventario();
    }

}
