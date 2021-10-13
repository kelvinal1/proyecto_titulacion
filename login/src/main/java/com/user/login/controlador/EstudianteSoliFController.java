package com.user.login.controlador;

import java.util.List;
import java.util.Optional;

import com.user.login.modelo.fenix.estudianteSolicitudVM4A;
import com.user.login.repo.fenix.EstudianteSoliFRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstudianteSoliFController{
    

    @Autowired
    private EstudianteSoliFRepo estudianteSoliFRepo;


    @CrossOrigin(origins="*")
    @GetMapping("/listaEstudiantesSoliF")
    public List<estudianteSolicitudVM4A> findAll(){
        List<estudianteSolicitudVM4A> estudiantes=estudianteSoliFRepo.findAll();
        System.out.println(estudiantes.size());

        return estudiantes;
    } 

    @CrossOrigin(origins="*")
    @GetMapping("/listaEstudianteSFC/{correo}")
    public estudianteSolicitudVM4A BuscarPorCorreo(@PathVariable String correo){
        estudianteSolicitudVM4A estudiantet= estudianteSoliFRepo.findByEcorreo(correo);
        return estudiantet;
        
    }

    @CrossOrigin(origins="*")
    @GetMapping("/listaEstudianteSFI/{id}")
    public estudianteSolicitudVM4A BuscarPorCedula(@PathVariable String id){
        Optional<estudianteSolicitudVM4A> estudiantet= estudianteSoliFRepo.findById(id);
        return estudiantet.get();
        
    }
}
