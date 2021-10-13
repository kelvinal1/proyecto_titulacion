package com.user.login.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.user.login.modelo.RespuestaGenerica;
import com.user.login.modelo.titulacion.informest;
import com.user.login.repo.titulacion.InformesTRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class InformesTController {

    @Autowired
    private InformesTRepo informesTRepo;

    @GetMapping("/listarInformesT/")
    public List<informest> listaInformes() {

        List<informest> lista = informesTRepo.findAll();
        return lista;
    }

    @GetMapping("/listarInformesT/{id}")
    public informest bucarPorId(@PathVariable Integer id) {

        Optional<informest> informe = informesTRepo.findById(id);
        return informe.get();
    }

    @PostMapping("/nuevoInformeT/")
    public ResponseEntity<RespuestaGenerica> CrearNuevoInforme(@RequestBody informest info) {
        List<informest> data = new ArrayList<informest>();
        RespuestaGenerica<informest> respuesta = new RespuestaGenerica<>();
        try {
            System.out.println("El nombre es:" + info.getNombre());
            informest infoInsert = informesTRepo.save(info);
            if (infoInsert != null) {
                data.add(infoInsert);
                respuesta.setData(data);
                respuesta.setMensaje("Informe ingresado exitosamente");
                respuesta.setEstado(0);

            }

        } catch (Exception e) {
            respuesta.setMensaje("Hubo un problema al crear el nuevo Documento");
            respuesta.setData(data);
            respuesta.setEstado(1);
            
        }

        return new ResponseEntity<RespuestaGenerica>(respuesta, HttpStatus.CREATED);
    }

    
    @DeleteMapping("/eliminarInformeT/{id}")
    public ResponseEntity EliminarInformeT(@PathVariable Integer id ){
        List<informest> data = new ArrayList<informest>();
        RespuestaGenerica<informest> respuesta = new RespuestaGenerica<>();
        try {
            
            informesTRepo.deleteById(id);
            if(informesTRepo!=null){
                data.add(new informest());
                respuesta.setMensaje("Informe T Eliminado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }else{
                data.add(new informest());
                respuesta.setMensaje("Informe T no Eliminado");
                respuesta.setData(data);
                respuesta.setEstado(1);
            }
        } catch (Exception e) {
            respuesta.setMensaje("Hubo un problema al eliminar el Informe T");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
        }
        
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
    }

}
