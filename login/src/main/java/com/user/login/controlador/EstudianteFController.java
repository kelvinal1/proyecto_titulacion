package com.user.login.controlador;

import com.user.login.repo.fenix.EstudianteFRepo;
import com.user.login.repo.titulacion.EstudianteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.login.modelo.RespuestaGenerica;
import com.user.login.modelo.fenix.*;
import org.springframework.web.bind.annotation.RequestBody;
import com.user.login.modelo.titulacion.estudiantet;

import java.util.ArrayList;
import java.util.List;


@RestController
public class EstudianteFController {

    @Autowired
    private EstudianteFRepo fenixRepo;


    @GetMapping("/listaEstudiantesF")
    public List<estudiantesVM4A> findAll(){
        List<estudiantesVM4A> estudiantes=fenixRepo.findAll();
        System.out.println(estudiantes.size());

        return estudiantes;
    } 

    @GetMapping("/listaEstudianteF/{correo}")
    public estudiantesVM4A BuscarPorCorreo(@PathVariable String correo){
        estudiantesVM4A estudiantet= fenixRepo.findByCorreo(correo);
        return estudiantet;
        
    }


   

   
}
