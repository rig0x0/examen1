package com.upiiz.clientespotenciales.models;

import java.util.Date;

public class ClientesPotenciales {
    private Long Cliente_id;
    private String nombre;
    private String direccion;
    private String telefono;

    public ClientesPotenciales(){}

    public ClientesPotenciales(Long Cliente_id, String nombre, String direccion, String telefono) {
        this.Cliente_id = Cliente_id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Long getCliente_id() {
        return Cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.Cliente_id = cliente_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
