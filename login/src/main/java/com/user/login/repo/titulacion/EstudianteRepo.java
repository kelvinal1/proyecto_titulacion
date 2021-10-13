package com.user.login.repo.titulacion;

import java.util.List;

import com.user.login.modelo.titulacion.estudiantet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepo extends JpaRepository<estudiantet,String> {

    estudiantet findByCedula(String cedula);

    estudiantet findByCorreo(String correo);
}
