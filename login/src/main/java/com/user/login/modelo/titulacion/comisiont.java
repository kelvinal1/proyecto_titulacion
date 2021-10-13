package com.user.login.modelo.titulacion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "comisiont")
public class comisiont {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id_comision;
    
    private String nombre;

    public comisiont(String nombre) {
        this.nombre = nombre;
    }

    public comisiont(){

    }

    public Integer getId_comision() {
        return id_comision;
    }

    public void setId_comision(Integer id_comision) {
        this.id_comision = id_comision;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
