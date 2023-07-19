package com.ProyectoGrupo6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ProyectoGrupo6.domain.Venta;
import com.ProyectoGrupo6.domain.Cliente;
import com.ProyectoGrupo6.domain.Producto;
import com.ProyectoGrupo6.service.VentaService;
import com.ProyectoGrupo6.service.ClienteService;
import com.ProyectoGrupo6.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("ventas")
public class VentaController {

    @Autowired
    VentaService ventaService;

    @Autowired
    ProductoService productoService;

    @Autowired
    ClienteService clienteService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Venta> ventas = ventaService.getVentas();
        List<Producto> productos = productoService.getProductos(true);
        List<Cliente> clientes = clienteService.getClientes(true);
        model.addAttribute("ventas", ventas);
        model.addAttribute("productos", productos);
        model.addAttribute("clientes", clientes);
        return ("/ventas/listado");
    }

    @GetMapping("/nueva")
    public String ventaNueva(Venta venta) {
        return "/ventas/modifica";
    }

    @PostMapping("guardar")
    public String ventaGuardar(Venta venta) {
        ventaService.save(venta);
        return ("redirect:/ventas/listado");
    }

    @GetMapping("/eliminar/{numeroVenta}")
    public String ventaEliminar(Venta venta) {
        ventaService.delete(venta);
        return "redirect:/ventas/listado";
    }

    @GetMapping("/modificar/{numeroVenta}")
    public String ventaModificar(Venta venta, Model model) {
        venta = ventaService.getVenta(venta);
        List<Producto> productos = productoService.getProductos(true);
        List<Cliente> clientes = clienteService.getClientes(true);
        model.addAttribute("venta", venta);
        model.addAttribute("productos", productos);
        model.addAttribute("clientes", clientes);
        return "/ventas/modifica";
    }

}
