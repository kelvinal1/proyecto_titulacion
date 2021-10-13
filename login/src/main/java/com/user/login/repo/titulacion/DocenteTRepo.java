package com.user.login.repo.titulacion;

import com.user.login.modelo.titulacion.docentet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteTRepo extends JpaRepository<docentet,String>{
    
    docentet findByCedula(String cedula);
    docentet findByCorreo(String correo);
    
}
