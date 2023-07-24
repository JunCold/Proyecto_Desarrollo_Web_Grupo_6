
package com.ProyectoGrupo6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ProyectoGrupo6.domain.Cliente;
import com.ProyectoGrupo6.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    
    @RequestMapping("/listado")
    public String page(Model model) {
        List<Cliente> clientes=clienteService.getClientes(false);
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes",clientes.size());
        return "/cliente/listado";
    }
    
    @GetMapping("/nuevo")
    public String clienteNuevo(Cliente cliente) {
        return "/cliente/modifica";
    }
    @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente){
        clienteService.save(cliente);
        return"redirect:/cliente/listado";
    }
    
    @GetMapping("/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }
    @GetMapping("/modificar/{idCliente}")
    public String clienteModificar(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modifica";
    }

    
}
