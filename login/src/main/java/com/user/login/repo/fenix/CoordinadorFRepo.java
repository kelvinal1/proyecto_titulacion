package com.user.login.repo.fenix;

import com.user.login.modelo.fenix.coordinadorVM4A;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinadorFRepo extends JpaRepository<coordinadorVM4A,Integer> {
    
    coordinadorVM4A findByCorreo(String correo);
    
    coordinadorVM4A findByCedula(String cedula);

}
