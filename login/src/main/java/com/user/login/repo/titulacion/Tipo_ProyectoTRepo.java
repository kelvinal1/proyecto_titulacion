package com.user.login.repo.titulacion;

import com.user.login.modelo.titulacion.tipo_proyectot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tipo_ProyectoTRepo extends JpaRepository<tipo_proyectot,Integer> {
    
    tipo_proyectot findByNombre(String nombre);
}
