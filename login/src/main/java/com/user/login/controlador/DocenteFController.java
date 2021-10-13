package com.user.login.controlador;

import java.util.List;

import com.user.login.modelo.fenix.docentesVM4A;
import com.user.login.repo.fenix.DocenteFRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocenteFController {
    
    @Autowired
    private DocenteFRepo docenteFRepo;

    @GetMapping("/listaDocentesF")
    public List<docentesVM4A> ListaDocentesF(){
        List<docentesVM4A> docentes=docenteFRepo.findAll();
        System.out.println(docentes.size());

        return docentes;
    } 
}
