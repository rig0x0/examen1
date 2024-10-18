package com.upiiz.clientespotenciales.controllers;

import com.upiiz.clientespotenciales.models.ClientesPotenciales;
import com.upiiz.clientespotenciales.services.ClientesPotService;
import com.upiiz.clientespotenciales.services.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientespotenciales")
public class ClientesPotController {

    private final ClientesPotService clientesPotService;
    private final FileService fileService;

    public ClientesPotController(ClientesPotService clientesPotService, FileService fileService) {
        this.clientesPotService = clientesPotService;
        this.fileService = fileService;
    }

    @GetMapping
    public ResponseEntity<List<ClientesPotenciales>> getEmpleados() {
        return ResponseEntity.ok(clientesPotService.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientesPotenciales> getEmpleadoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clientesPotService.getClientById(id));
    }

    @PostMapping
    public ResponseEntity<ClientesPotenciales> addEmpleado(@RequestBody ClientesPotenciales empleado) {
        ClientesPotenciales nuevoCliente = clientesPotService.guardarClient(empleado);

        // Guardar el cliente en el archivo JSON
        fileService.guardarCliente(nuevoCliente);

        return ResponseEntity.ok(nuevoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientesPotenciales> actualizarEmpleado(@RequestBody ClientesPotenciales empleado, @PathVariable Long id) {
        empleado.setCliente_id(id);

        // Actualizar en la base de datos y en el archivo JSON
        clientesPotService.updateClient(empleado);
        fileService.actualizarCliente(empleado);

        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
        clientesPotService.deleteClient(id);

        // Eliminar del archivo JSON
        fileService.eliminarCliente(id);

        return ResponseEntity.noContent().build();
    }
}