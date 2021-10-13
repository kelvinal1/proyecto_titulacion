package com.user.login.modelo.titulacion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tribunalt")
public class tribunalt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tribunal;

    private String nombre;

    public tribunalt() {
    }

    public tribunalt(Integer id_tribunal, String nombre) {
        this.id_tribunal = id_tribunal;
        this.nombre = nombre;
    }

    public Integer getId_tribunal() {
        return id_tribunal;
    }

    public void setId_tribunal(Integer id_tribunal) {
        this.id_tribunal = id_tribunal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
