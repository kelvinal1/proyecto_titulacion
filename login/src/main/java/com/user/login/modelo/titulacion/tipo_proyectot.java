package com.user.login.modelo.titulacion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_proyectot")
public class tipo_proyectot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_t_proyecto;

    private String nombre;

    public tipo_proyectot() {
    }

    public tipo_proyectot(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_t_proyecto() {
        return id_t_proyecto;
    }

    public void setId_t_proyecto(Integer id_t_proyecto) {
        this.id_t_proyecto = id_t_proyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    
    
}
