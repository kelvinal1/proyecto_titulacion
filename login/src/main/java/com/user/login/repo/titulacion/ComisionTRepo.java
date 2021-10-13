package com.user.login.repo.titulacion;

import com.user.login.modelo.titulacion.comisiont;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComisionTRepo extends JpaRepository<comisiont, Integer> {

    comisiont findByNombre(String nombre);
    
}
