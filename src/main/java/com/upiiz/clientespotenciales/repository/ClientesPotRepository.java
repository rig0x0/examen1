package com.upiiz.clientespotenciales.repository;

import com.upiiz.clientespotenciales.models.ClientesPotenciales;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClientesPotRepository {
    private List<ClientesPotenciales> clientes = new ArrayList<>();
    private AtomicLong id = new AtomicLong();

    public ClientesPotenciales guardar(ClientesPotenciales cliente){
        cliente.setCliente_id(id.incrementAndGet());
        clientes.add(cliente);
        return cliente;
    }

    public List<ClientesPotenciales> getClientes(){
        return clientes;
    }

    public ClientesPotenciales obtenerPorId(Long id){
        return clientes.stream().filter(clientes -> clientes.getCliente_id().equals(id)).findFirst().orElse(null);
    }

    public void eliminar(Long id){
        clientes.removeIf(clientes -> clientes.getCliente_id().equals(id));
    }

    public ClientesPotenciales actualizar(ClientesPotenciales cliente){
        eliminar(cliente.getCliente_id());
        clientes.add(cliente);
        return cliente;
    }
}
