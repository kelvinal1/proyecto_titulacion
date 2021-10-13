package com.user.login.repo.titulacion;

import com.user.login.modelo.titulacion.coordinadort;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinadorTRepo extends JpaRepository<coordinadort,String> {
    

    coordinadort findByCedula(String cedula);

    coordinadort findByCorreo(String correo);
}
