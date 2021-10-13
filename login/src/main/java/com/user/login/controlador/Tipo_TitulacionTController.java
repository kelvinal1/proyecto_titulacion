package com.user.login.controlador;

import java.util.ArrayList;
import java.util.List;

import com.user.login.modelo.RespuestaGenerica;
import com.user.login.modelo.titulacion.tipo_titulaciont;
import com.user.login.repo.titulacion.Tipo_TitulacionTRepo;

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
public class Tipo_TitulacionTController {

    
    @Autowired
    private Tipo_TitulacionTRepo tipo_TitulacionTRepo;

    @GetMapping("/listaTipoTitulacionT")
    public  List<tipo_titulaciont> listaTipoTitulacionT(){
        List<tipo_titulaciont> docentes = tipo_TitulacionTRepo.findAll();
        System.out.println(docentes.size());
        return docentes;

    }    

    @GetMapping("/listaTitulacionTRepo/{nombre}")
    public tipo_titulaciont BuscarPorCorreo(@PathVariable String nombre){
        tipo_titulaciont tipoP= tipo_TitulacionTRepo.findByNombre(nombre);
        return tipoP;
        
    }


    @PostMapping("/nuevoTipoTitulacion")
    public ResponseEntity<RespuestaGenerica> CrearNuevoTipoProyecto(@RequestBody tipo_titulaciont tipo){
        
        List<tipo_titulaciont> data = new ArrayList<tipo_titulaciont>();
        RespuestaGenerica<tipo_titulaciont> respuesta = new RespuestaGenerica<>();


        try{
            System.out.println("El nombre es "+tipo.getNombre());
            
            tipo_titulaciont tipoPInsert = tipo_TitulacionTRepo.save(tipo);
            if(tipoPInsert!=null){
                data.add(tipoPInsert);
                respuesta.setMensaje("Tipo de Titulacion nuevo ingresado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }
            
            
           
        }
        catch(Exception ex){
            respuesta.setMensaje("Hubo un problema al insertar el nuevo Tipo de Titulacion");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
            //return new ResponseEntity<>("El objeto no ha sido ingresado",HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.CREATED);    

    }

    @PutMapping("/modificarTipoTitulacion/{id}")
    public ResponseEntity<RespuestaGenerica> ModificarTipoTitulacion(@RequestBody tipo_titulaciont newTipo_titulaciont,@PathVariable Integer id){
        List<tipo_titulaciont> data = new ArrayList<tipo_titulaciont>();

        RespuestaGenerica<tipo_titulaciont> respuesta = new RespuestaGenerica<>();

        try{

            tipo_titulaciont v1 = tipo_TitulacionTRepo.findById(id)
            .map(tipo_titulaciont ->{
                tipo_titulaciont.setNombre(newTipo_titulaciont.getNombre());
                return tipo_TitulacionTRepo.save(tipo_titulaciont);
            })
            .orElseGet(()->{
                return new tipo_titulaciont();
            });
                        

            if (v1!=null) {
                data.add(newTipo_titulaciont);
                respuesta.setMensaje("Tipo de Titulacion T Actualizado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0); 
            }else{
                data.add(newTipo_titulaciont);
                respuesta.setMensaje("Tipo de Titulacion T No Actualizado");
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

    @DeleteMapping("/eliminarTipoTitulacion/{id}")
    public ResponseEntity EliminarTipoProyecto(@PathVariable Integer id ){
        List<tipo_titulaciont> data = new ArrayList<tipo_titulaciont>();
        RespuestaGenerica<tipo_titulaciont> respuesta = new RespuestaGenerica<>();
        try {
            
            tipo_TitulacionTRepo.deleteById(id);
            if(tipo_TitulacionTRepo!=null){
                data.add(new tipo_titulaciont());
                respuesta.setMensaje("Tipo de Titulacion T Eliminado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }else{
                data.add(new tipo_titulaciont());
                respuesta.setMensaje("Tipo de Titulacion T NO Eliminado");
                respuesta.setData(data);
                respuesta.setEstado(1);
            }
        } catch (Exception e) {
            respuesta.setMensaje("Hubo un problema al eliminar el Titulacion T");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
        }
        
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
    }


    
}
