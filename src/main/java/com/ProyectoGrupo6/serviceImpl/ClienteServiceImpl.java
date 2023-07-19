package com.ProyectoGrupo6.serviceImpl;

import org.springframework.stereotype.Service;
import com.ProyectoGrupo6.dao.ClienteDao;
import com.ProyectoGrupo6.domain.Cliente;
import com.ProyectoGrupo6.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes(boolean activos) {
        List<Cliente> Clientes = clienteDao.findAll();
        if (activos) {
            Clientes.removeIf(x -> !x.isActivo());
        }
        return Clientes;
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

}
