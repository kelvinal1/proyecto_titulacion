package com.user.login.modelo.titulacion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "informest")
public class informest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_inform;
    
    private String nombre;

    //TODO insertar la varible para recibir la fecha de sistema: Tipo SQL


}
