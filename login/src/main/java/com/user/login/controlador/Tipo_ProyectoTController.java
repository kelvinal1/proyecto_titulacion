package com.user.login.controlador;

import java.util.ArrayList;
import java.util.List;

import com.user.login.modelo.RespuestaGenerica;
import com.user.login.modelo.titulacion.tipo_proyectot;
import com.user.login.repo.titulacion.Tipo_ProyectoTRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tipo_ProyectoTController {
    

    @Autowired
    private Tipo_ProyectoTRepo tipo_ProyectoTRepo;

    @GetMapping("/listaTipoProyectosT")
    public  List<tipo_proyectot> ListaTipoProyectosT(){
        List<tipo_proyectot> docentes = tipo_ProyectoTRepo.findAll();
        System.out.println(docentes.size());
        return docentes;

    }    

    @GetMapping("/listaTipoProyecto/{nombre}")
    public tipo_proyectot BuscarPorCorreo(@PathVariable String nombre){
        tipo_proyectot tipoP= tipo_ProyectoTRepo.findByNombre(nombre);
        return tipoP;
        
    }


    @PostMapping("/nuevoTipoProyecto")
    public ResponseEntity<RespuestaGenerica> CrearNuevoTipoProyecto(@RequestBody tipo_proyectot tipo){
        
        List<tipo_proyectot> data = new ArrayList<tipo_proyectot>();
        RespuestaGenerica<tipo_proyectot> respuesta = new RespuestaGenerica<>();


        try{
            System.out.println("El nombre es "+tipo.getNombre());
            
            tipo_proyectot tipoPInsert = tipo_ProyectoTRepo.save(tipo);
            if(tipoPInsert!=null){
                data.add(tipoPInsert);
                respuesta.setMensaje("Tipo de Proyecto nuevo ingresado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }
            
            
           
        }
        catch(Exception ex){
            respuesta.setMensaje("Hubo un problema al insertar el nuevo Tipo de Proyecto");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
            //return new ResponseEntity<>("El vehículo no ha sido ingresado",HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.CREATED);    

    }

    @PutMapping("/modificarTipoProyecto/{id}")
    public ResponseEntity<RespuestaGenerica> ModificarTipoProyecto(@RequestBody tipo_proyectot newTipoProyecto,@PathVariable Integer id){
        List<tipo_proyectot> data = new ArrayList<tipo_proyectot>();

        RespuestaGenerica<tipo_proyectot> respuesta = new RespuestaGenerica<>();

        try{

            tipo_proyectot v1 = tipo_ProyectoTRepo.findById(id)
            .map(tipo_proyectot ->{
                tipo_proyectot.setNombre(newTipoProyecto.getNombre());
                return tipo_ProyectoTRepo.save(tipo_proyectot);
            })
            .orElseGet(()->{
                return new tipo_proyectot();
            });
                        

            if (v1!=null) {
                data.add(newTipoProyecto);
                respuesta.setMensaje("Tipo de Proyecto T Actualizado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0); 
            }else{
                data.add(newTipoProyecto);
                respuesta.setMensaje("Tipo de Proyecto T No Actualizado");
                respuesta.setData(data);
                respuesta.setEstado(1); 
            }


            
        }
        catch(Exception ex){
            respuesta.setMensaje("Hubo un problema al actualizar el Tipo de Proyecto T");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
            //return new ResponseEntity<>("El vehículo no ha sido ingresado",HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
    }

    @DeleteMapping("/eliminarTipoProyecto/{id}")
    public ResponseEntity EliminarTipoProyecto(@PathVariable Integer id ){
        List<tipo_proyectot> data = new ArrayList<tipo_proyectot>();
        RespuestaGenerica<tipo_proyectot> respuesta = new RespuestaGenerica<>();
        try {
            
            tipo_ProyectoTRepo.deleteById(id);
            if(tipo_ProyectoTRepo!=null){
                data.add(new tipo_proyectot());
                respuesta.setMensaje("Tipo de Proyecto T Eliminado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }else{
                data.add(new tipo_proyectot());
                respuesta.setMensaje("Tipo de Proyecto T NO Eliminado");
                respuesta.setData(data);
                respuesta.setEstado(1);
            }
        } catch (Exception e) {
            respuesta.setMensaje("Hubo un problema al eliminar el estudiante T");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
        }
        
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
    }


}
