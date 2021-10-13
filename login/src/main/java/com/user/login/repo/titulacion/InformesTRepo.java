package com.user.login.repo.titulacion;

import com.user.login.modelo.titulacion.informest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformesTRepo extends JpaRepository<informest, Integer> {

    informest findByNombre(String nombre);
}
    