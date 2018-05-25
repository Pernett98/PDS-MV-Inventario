/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.poli.pdd.inventario.Inventario.Controller;

import co.com.poli.pdd.inventario.Inventario.Business.IProductoBusiness;
import co.com.poli.pdd.inventario.Inventario.Model.Producto;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
public class ProductoController {

    @Autowired
    private IProductoBusiness productoBusiness;

    @PostMapping("/productos")
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoBusiness.crearProducto(producto);
    }

    @PutMapping("/productos")
    public Producto modificarProducto(@RequestBody Producto producto) {
        return productoBusiness.modificarProducto(producto);
    }

}
