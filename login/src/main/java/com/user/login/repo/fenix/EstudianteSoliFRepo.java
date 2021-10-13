package com.user.login.repo.fenix;

import com.user.login.modelo.fenix.estudianteSolicitudVM4A;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteSoliFRepo extends JpaRepository<estudianteSolicitudVM4A,String> {
    
    estudianteSolicitudVM4A findByEcorreo(String correo);

   
}
