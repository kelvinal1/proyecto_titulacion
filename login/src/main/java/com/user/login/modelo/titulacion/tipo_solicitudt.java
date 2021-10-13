package com.user.login.modelo.titulacion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_solicitudt")
public class tipo_solicitudt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_solicitud;

    private String nombre;

    public tipo_solicitudt() {
    }

    public tipo_solicitudt(Integer id_tipo_solicitud, String nombre) {
        this.id_tipo_solicitud = id_tipo_solicitud;
        this.nombre = nombre;
    }

    public Integer getId_tipo_solicitud() {
        return id_tipo_solicitud;
    }

    public void setId_tipo_solicitud(Integer id_tipo_solicitud) {
        this.id_tipo_solicitud = id_tipo_solicitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
