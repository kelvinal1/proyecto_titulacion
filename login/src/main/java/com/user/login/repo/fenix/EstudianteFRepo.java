package com.user.login.repo.fenix;

import com.user.login.modelo.fenix.estudiantesVM4A;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteFRepo extends JpaRepository<estudiantesVM4A,Integer> {
    
    
   estudiantesVM4A findByCedula(String cedula);

   estudiantesVM4A findByCorreo(String correo);
   
}
