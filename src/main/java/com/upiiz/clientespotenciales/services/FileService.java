package com.upiiz.clientespotenciales.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upiiz.clientespotenciales.models.ClientesPotenciales;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    private static final String FILE_PATH = "src/main/resources/clientes_potenciales.json"; // Ruta del archivo

    public void guardarCliente(ClientesPotenciales cliente) {
        List<ClientesPotenciales> clientes = leerClientesDesdeArchivo();

        // Agregar el nuevo cliente
        clientes.add(cliente);

        // Escribir de nuevo el archivo
        escribirClientesEnArchivo(clientes);
    }

    public void actualizarCliente(ClientesPotenciales cliente) {
        List<ClientesPotenciales> clientes = leerClientesDesdeArchivo();

        // Buscar y actualizar el cliente
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCliente_id().equals(cliente.getCliente_id())) {
                clientes.set(i, cliente);
                break;
            }
        }

        // Escribir de nuevo el archivo
        escribirClientesEnArchivo(clientes);
    }

    public void eliminarCliente(Long id) {
        List<ClientesPotenciales> clientes = leerClientesDesdeArchivo();

        // Filtrar el cliente a eliminar
        clientes.removeIf(cliente -> cliente.getCliente_id().equals(id));

        // Escribir de nuevo el archivo
        escribirClientesEnArchivo(clientes);
    }

    private List<ClientesPotenciales> leerClientesDesdeArchivo() {
        List<ClientesPotenciales> clientes = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(FILE_PATH);

        // Leer el archivo existente si existe
        if (file.exists()) {
            try {
                ClientesPotenciales[] existingClientes = objectMapper.readValue(file, ClientesPotenciales[].class);
                for (ClientesPotenciales c : existingClientes) {
                    clientes.add(c);
                }
            } catch (IOException e) {
                e.printStackTrace(); // Manejo de excepciones
            }
        }

        return clientes;
    }

    private void escribirClientesEnArchivo(List<ClientesPotenciales> clientes) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File(FILE_PATH), clientes);
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
    }
}