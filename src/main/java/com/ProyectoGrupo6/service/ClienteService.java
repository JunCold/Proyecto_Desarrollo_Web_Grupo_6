package com.ProyectoGrupo6.service;

import com.ProyectoGrupo6.domain.Cliente;
import java.util.List;

public interface ClienteService {
    public List <Cliente> getClientes(boolean activo);
    public void save(Cliente cliente);
    public void delete(Cliente cliente);
}
