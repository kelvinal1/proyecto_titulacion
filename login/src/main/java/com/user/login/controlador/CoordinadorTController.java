package com.user.login.controlador;

import java.util.ArrayList;
import java.util.List;

import com.user.login.modelo.RespuestaGenerica;
import com.user.login.modelo.titulacion.coordinadort;
import com.user.login.repo.titulacion.CoordinadorTRepo;

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
public class CoordinadorTController {
    
    @Autowired
    private CoordinadorTRepo coordinadorTRepo;

    @GetMapping("/listaCoordinadoresT")
    public  List<coordinadort> ListaDocentesT(){
        List<coordinadort> docentes = coordinadorTRepo.findAll();
        System.out.println(docentes.size());
        return docentes;

    }    

    @GetMapping("/listaCoordinadorT/{correo}")
    public coordinadort BuscarPorCorreo(@PathVariable String correo){
        coordinadort docentet=coordinadorTRepo.findByCorreo(correo);
        return docentet;
        
    }

    @GetMapping("/verificarCoordinadorT/{correo}")
    public boolean verificarCorreo(@PathVariable String correo){
        try {

            if (correo.contains("@tecazuay.edu.ec")) {

                coordinadort coordinadort= coordinadorTRepo.findByCorreo(correo);
                if (coordinadort.getCorreo().equals("")) {
                    return false;
                } else {
                    return true;
                }

            }else{
                return false;
            }
           
            
        } catch (Exception e) {
           return false;
        }
       
    }

    @PostMapping("/nuevoCoordinador")
    public ResponseEntity<RespuestaGenerica> CrearNuevoCoordinadorT(@RequestBody coordinadort coor){
        
        List<coordinadort> data = new ArrayList<coordinadort>();
        RespuestaGenerica<coordinadort> respuesta = new RespuestaGenerica<>();


        try{
            System.out.println("El correo es "+coor.getCorreo());
            
            coordinadort corInsert = coordinadorTRepo.save(coor);
            if(corInsert!=null){
                data.add(corInsert);
                respuesta.setMensaje("Coordinador nuevo ingresado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }
            
            
           
        }
        catch(Exception ex){
            respuesta.setMensaje("Hubo un problema al insertar el nuevo coordinador");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
            //return new ResponseEntity<>("El vehículo no ha sido ingresado",HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.CREATED);    

    }

    @PutMapping("/modificarCoor/{cedula}")
    public ResponseEntity<RespuestaGenerica> ModificarDocenteT(@RequestBody coordinadort newCoordinadort,@PathVariable String cedula){
        List<coordinadort> data = new ArrayList<coordinadort>();

        RespuestaGenerica<coordinadort> respuesta = new RespuestaGenerica<>();

        try{

            coordinadort v1 = coordinadorTRepo.findById(cedula)
            .map(coordinadort ->{
                coordinadort.setCorreo(newCoordinadort.getCorreo());
                coordinadort.setNombre(newCoordinadort.getNombre());
                return coordinadorTRepo.save(coordinadort);
            })
            .orElseGet(()->{
                return new coordinadort();
            });
                        

            if (v1!=null) {
                data.add(newCoordinadort);
                respuesta.setMensaje("Coordinador T Actualizado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0); 
            }else{
                data.add(newCoordinadort);
                respuesta.setMensaje("Coordinador T No Actualizado");
                respuesta.setData(data);
                respuesta.setEstado(1); 
            }


            
        }
        catch(Exception ex){
            respuesta.setMensaje("Hubo un problema al actualizar el Coordinador T");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
            //return new ResponseEntity<>("El vehículo no ha sido ingresado",HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
    }

    @DeleteMapping("/eliminarCoor/{cedula}")
    public ResponseEntity EliminarDocenteT(@PathVariable String cedula ){
        List<coordinadort> data = new ArrayList<coordinadort>();
        RespuestaGenerica<coordinadort> respuesta = new RespuestaGenerica<>();
        try {
            
            coordinadorTRepo.deleteById(cedula);
            if(coordinadorTRepo!=null){
                data.add(new coordinadort());
                respuesta.setMensaje("Coordinador T Eliminado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }else{
                data.add(new coordinadort());
                respuesta.setMensaje("Coordinador T NO Eliminado");
                respuesta.setData(data);
                respuesta.setEstado(1);
            }
        } catch (Exception e) {
            respuesta.setMensaje("Hubo un problema al eliminar el Coordinador T");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
        }
        
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
    }



}
