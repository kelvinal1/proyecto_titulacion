package com.user.login.controlador;

import java.util.ArrayList;
import java.util.List;

import com.user.login.modelo.RespuestaGenerica;
import com.user.login.modelo.titulacion.tribunalt;
import com.user.login.repo.titulacion.TribunalTRepo;

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
public class TribunalTController {

    @Autowired
    private TribunalTRepo tribunaltRepo;

    @GetMapping("/listaTribuanlT")
    public List<tribunalt> ListaTribunalT(){
        List<tribunalt> tribunal=tribunaltRepo.findAll();
        System.out.println(tribunal.size());

        return tribunal;
    } 
/*
    @GetMapping("/listaTribunalT/{nombre}")
    public tribunalt BuscarPorCorreo(@PathVariable String nombre){
        tribunalt tribunalt= tribunaltRepo.findbyNombre(nombre);
        return tribunalt;
        
    }
*/
    @PostMapping("/nuevoTrib")
    public ResponseEntity<RespuestaGenerica> CrearNuevoTribunalT(@RequestBody tribunalt tribunal){
        
        List<tribunalt> data = new ArrayList<tribunalt>();
        RespuestaGenerica<tribunalt> respuesta = new RespuestaGenerica<>();


        try{
            System.out.println("Nombre de tribunal "+tribunal.getNombre());
            
            tribunalt tribunalInsert = tribunaltRepo.save(tribunal);
            if(tribunalInsert!=null){
                data.add(tribunalInsert);
                respuesta.setMensaje("Tribunal creado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }
            
            
           
        }
        catch(Exception ex){
            respuesta.setMensaje("Hubo un problema al crear nuevo miembro de tribunal");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
            //return new ResponseEntity<>("El Tribunal no ha sido ingresado",HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.CREATED);    

    }

    @PutMapping("/modificarTrib/{id}")
    public ResponseEntity<RespuestaGenerica> ModificarTribunalT(@RequestBody tribunalt newTribunalt,@PathVariable Integer id){
        List<tribunalt> data = new ArrayList<tribunalt>();

        RespuestaGenerica<tribunalt> respuesta = new RespuestaGenerica<>();

        try{

            tribunalt v1 = tribunaltRepo.findById(id)
            .map(tribunalt ->{
                   tribunalt.setNombre(newTribunalt.getNombre());
                return tribunaltRepo.save(tribunalt);
            })
            .orElseGet(()->{
                return new tribunalt();
            });
                        

            if (v1!=null) {
                data.add(newTribunalt);
                respuesta.setMensaje("Miembro T Actualizado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0); 
            }else{
                data.add(newTribunalt);
                respuesta.setMensaje("Miembro T No Actualizado");
                respuesta.setData(data);
                respuesta.setEstado(1); 
            }


            
        }
        catch(Exception ex){
            respuesta.setMensaje("Hubo un problema al actualizar el registro T");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
            //return new ResponseEntity<>("Nuevo miembro de tribunal no ha sido ingresado",HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
    }

    @DeleteMapping("/eliminarTrib/{id}")
    public ResponseEntity EliminarTribunalT(@PathVariable Integer id ){
        List<tribunalt> data = new ArrayList<tribunalt>();
        RespuestaGenerica<tribunalt> respuesta = new RespuestaGenerica<>();
        try {
            
            tribunaltRepo.deleteById(id);
            if(tribunaltRepo!=null){
                data.add(new tribunalt());
                respuesta.setMensaje("Miembro tribunal T Eliminado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }else{
                data.add(new tribunalt());
                respuesta.setMensaje("Miembro tribunal T NO Eliminado");
                respuesta.setData(data);
                respuesta.setEstado(1);
            }
        } catch (Exception e) {
            respuesta.setMensaje("Hubo un problema al eliminar el Miembro tribunal T");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
        }
        
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
    }
}
