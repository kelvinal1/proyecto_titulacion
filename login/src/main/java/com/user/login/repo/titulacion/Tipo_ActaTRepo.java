package com.user.login.repo.titulacion;

import com.user.login.modelo.titulacion.t_actat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  Tipo_ActaTRepo  extends JpaRepository<t_actat, Integer>{

    t_actat findByNombre(String nombre);
    
}
