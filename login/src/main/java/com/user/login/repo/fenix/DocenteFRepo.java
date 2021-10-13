package com.user.login.repo.fenix;

import com.user.login.modelo.fenix.docentesVM4A;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DocenteFRepo extends JpaRepository<docentesVM4A,Integer> {
    
    docentesVM4A findByCorreo(String correo);
}
