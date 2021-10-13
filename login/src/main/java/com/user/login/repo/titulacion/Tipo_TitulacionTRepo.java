package com.user.login.repo.titulacion;

import com.user.login.modelo.titulacion.tipo_titulaciont;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tipo_TitulacionTRepo extends JpaRepository<tipo_titulaciont,Integer>{
    tipo_titulaciont findByNombre(String nombre);
}
