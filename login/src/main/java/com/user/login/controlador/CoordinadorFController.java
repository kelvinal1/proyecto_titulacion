package com.user.login.controlador;


import java.util.List;

import com.user.login.modelo.fenix.coordinadorVM4A;
import com.user.login.repo.fenix.CoordinadorFRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoordinadorFController {
    

    @Autowired
    private CoordinadorFRepo coordinadorFRepo;

    @GetMapping("/listaCoordinadoresF")
    public List<coordinadorVM4A> ListaCoordinadoresF(){
        List<coordinadorVM4A> coordinadores=coordinadorFRepo.findAll();
        System.out.println(coordinadores.size());

        return coordinadores;
    } 
}
