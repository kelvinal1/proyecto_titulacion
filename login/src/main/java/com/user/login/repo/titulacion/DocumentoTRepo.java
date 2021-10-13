package com.user.login.repo.titulacion;

import com.user.login.modelo.titulacion.documentot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoTRepo extends JpaRepository<documentot,Integer> {
    
    documentot findByNombre(String nombre);
}
