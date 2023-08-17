package com.ProyectoGrupo6.controller;

import com.ProyectoGrupo6.domain.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ProyectoGrupo6.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        return "/inventario/listado";
    }
  
    @PostMapping("/query1")
    public String consultaQuery (@RequestParam(value = "codigoProducto") Long codigoProducto, Model model){
        var productos= productoService.findByCodigo(codigoProducto);
        model.addAttribute("productos",productos);
        model.addAttribute("codigoProducto",codigoProducto);
        return "/inventario/listado";
    }
    
    @GetMapping("/aumentar/{idProducto}")
    public String productoAumentar (Producto producto,Long cantidad, Model model){
        
        producto= productoService.aumentarProducto(producto.getCodigoProducto(), cantidad);
        model.addAttribute("producto",producto);
        model.addAttribute("cantidadAumentar", cantidad);
        return "redirect:/inventario/listado";
    }
    
    @GetMapping("/disminuir/{idProducto}")
    public String productoDisminuir(Producto producto, Long cantidad, Model model){
        producto=productoService.disminuirProducto(producto.getCodigoProducto(), cantidad);
        model.addAttribute("cantidadDisminuir",cantidad);
        model.addAttribute("producto",producto);
        return "redirect:/inventario/listado";
    }
    

}
