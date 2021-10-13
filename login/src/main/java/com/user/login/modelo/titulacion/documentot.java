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
@Table(name = "documentot")
public class documentot {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_doc;
    
    private String nombre;

    //TODO variable que almacene el documento Bytea
}
