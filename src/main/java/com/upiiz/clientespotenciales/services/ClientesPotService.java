package com.upiiz.clientespotenciales.services;

import com.upiiz.clientespotenciales.models.ClientesPotenciales;
import com.upiiz.clientespotenciales.repository.ClientesPotRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientesPotService {

    ClientesPotRepository clientesPotRepository;

    public ClientesPotService(ClientesPotRepository clientesPotRepository) {
        this.clientesPotRepository = clientesPotRepository;
    }

    public List<ClientesPotenciales> getAllClients(){
        return clientesPotRepository.getClientes();
    }

    public ClientesPotenciales getClientById(Long id){
        return clientesPotRepository.obtenerPorId(id);
    }

    public ClientesPotenciales guardarClient(ClientesPotenciales cliente){
        return clientesPotRepository.guardar(cliente);
    }

    public ClientesPotenciales updateClient(ClientesPotenciales client){
        return clientesPotRepository.actualizar(client);
    }

    public void deleteClient(Long id){
        clientesPotRepository.eliminar(id);
    }

}
