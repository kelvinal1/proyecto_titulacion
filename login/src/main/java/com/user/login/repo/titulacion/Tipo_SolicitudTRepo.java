package com.user.login.repo.titulacion;

import com.user.login.modelo.titulacion.tipo_solicitudt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tipo_SolicitudTRepo extends JpaRepository<tipo_solicitudt,Integer>{
    tipo_solicitudt findByNombre(String nombre); 
}
