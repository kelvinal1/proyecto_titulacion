package com.user.login.modelo.titulacion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "t_actat")
public class t_actat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id_t_acta;

    private String nombre;

    public t_actat(String nombre) {
        this.nombre = nombre;
    }
    public t_actat(){
        
    }

    public Integer getId_t_acta() {
        return id_t_acta;
    }

    public void setId_t_acta(Integer id_t_acta) {
        this.id_t_acta = id_t_acta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    

    
}
