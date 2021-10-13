package com.user.login.controlador;

import java.util.ArrayList;
import java.util.List;

import com.user.login.modelo.RespuestaGenerica;
import com.user.login.modelo.titulacion.tipo_solicitudt;
import com.user.login.repo.titulacion.Tipo_SolicitudTRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class Tipo_SolicitudTController {
    
    @Autowired
    private Tipo_SolicitudTRepo tipo_SolicitudTRepo;

    @GetMapping("/listaTipoSolicitudT")
    public  List<tipo_solicitudt> ListaTipoSolicitudT(){
        List<tipo_solicitudt> docentes = tipo_SolicitudTRepo.findAll();
        System.out.println(docentes.size());
        return docentes;

    }    

    @GetMapping("/listaTipoSolicitudT/{nombre}")
    public tipo_solicitudt BuscarPorCorreo(@PathVariable String nombre){
        tipo_solicitudt tipoP= tipo_SolicitudTRepo.findByNombre(nombre);
        return tipoP;
        
    }


    @PostMapping("/nuevoTipoSolicitud")
    public ResponseEntity<RespuestaGenerica> CrearNuevoTipoProyecto(@RequestBody tipo_solicitudt tipo){
        
        List<tipo_solicitudt> data = new ArrayList<tipo_solicitudt>();
        RespuestaGenerica<tipo_solicitudt> respuesta = new RespuestaGenerica<>();


        try{
            System.out.println("El nombre es "+tipo.getNombre());
            
            tipo_solicitudt tipoPInsert = tipo_SolicitudTRepo.save(tipo);
            if(tipoPInsert!=null){
                data.add(tipoPInsert);
                respuesta.setMensaje("Tipo de Proyecto nuevo ingresado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }
            
            
           
        }
        catch(Exception ex){
            respuesta.setMensaje("Hubo un problema al insertar el nuevo Tipo de Solicitud");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
            //return new ResponseEntity<>("El objeto no ha sido ingresado",HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.CREATED);    

    }

    @PutMapping("/modificarTipoSolicitud/{id}")
    public ResponseEntity<RespuestaGenerica> ModificarTipoProyecto(@RequestBody tipo_solicitudt newTipoSolicitudT,@PathVariable Integer id){
        List<tipo_solicitudt> data = new ArrayList<tipo_solicitudt>();

        RespuestaGenerica<tipo_solicitudt> respuesta = new RespuestaGenerica<>();

        try{

            tipo_solicitudt v1 = tipo_SolicitudTRepo.findById(id)
            .map(tipo_solicitudt ->{
                tipo_solicitudt.setNombre(newTipoSolicitudT.getNombre());
                return tipo_SolicitudTRepo.save(tipo_solicitudt);
            })
            .orElseGet(()->{
                return new tipo_solicitudt();
            });
                        

            if (v1!=null) {
                data.add(newTipoSolicitudT);
                respuesta.setMensaje("Tipo de Solicitud T Actualizado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0); 
            }else{
                data.add(newTipoSolicitudT);
                respuesta.setMensaje("Tipo de Solicitud T No Actualizado");
                respuesta.setData(data);
                respuesta.setEstado(1); 
            }


            
        }
        catch(Exception ex){
            respuesta.setMensaje("Hubo un problema al actualizar el Tipo de Solicitud T");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
            //return new ResponseEntity<>("El objeto no ha sido ingresado",HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
    }

    @DeleteMapping("/eliminarTipoSolicitud/{id}")
    public ResponseEntity EliminarTipoSolicitud(@PathVariable Integer id ){
        List<tipo_solicitudt> data = new ArrayList<tipo_solicitudt>();
        RespuestaGenerica<tipo_solicitudt> respuesta = new RespuestaGenerica<>();
        try {
            
            tipo_SolicitudTRepo.deleteById(id);
            if(tipo_SolicitudTRepo!=null){
                data.add(new tipo_solicitudt());
                respuesta.setMensaje("Tipo de Solicitud T Eliminado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }else{
                data.add(new tipo_solicitudt());
                respuesta.setMensaje("Tipo de Solicitud T NO Eliminado");
                respuesta.setData(data);
                respuesta.setEstado(1);
            }
        } catch (Exception e) {
            respuesta.setMensaje("Hubo un problema al eliminar el Solicitud T");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
        }
        
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
    }

}
