package com.user.login.controlador;

import java.util.ArrayList;
import java.util.List;

import com.user.login.modelo.usuario;
import com.user.login.modelo.fenix.coordinadorVM4A;
import com.user.login.modelo.fenix.docentesVM4A;
import com.user.login.modelo.fenix.estudiantesVM4A;
import com.user.login.repo.fenix.CoordinadorFRepo;
import com.user.login.repo.fenix.DocenteFRepo;
import com.user.login.repo.fenix.EstudianteFRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private EstudianteFRepo estudianteFRepo;

    @Autowired
    private DocenteFRepo docenteFRepo;

    @Autowired
    private CoordinadorFRepo coordinadorFRepo;

    @CrossOrigin(origins = "*")
    @GetMapping("/Usuario/{correo}")
    public usuario usuarioR(@PathVariable String correo) {
        List<Object> objetos = new ArrayList<Object>();
        usuario us = new usuario();

        estudiantesVM4A est = estudianteFRepo.findByCorreo(correo);

        if (est != null) {
            us.setRol("Estudiante");
            us.setCedula(est.getCedula());
        } else {
            coordinadorVM4A cor = coordinadorFRepo.findByCorreo(correo);

            if (cor != null) {
                us.setRol("Coordinador");
                us.setCedula(cor.getCedula());

            } else {

                docentesVM4A doc = docenteFRepo.findByCorreo(correo);
                if (doc != null) {
                    us.setRol("Docente");
                    us.setCedula(doc.getCedula());
                    ;
                }

            }

        }

        return us;
    }

}
