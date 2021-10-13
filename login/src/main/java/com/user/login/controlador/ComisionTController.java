package com.user.login.controlador;

import java.util.ArrayList;
import java.util.List;

import com.user.login.modelo.RespuestaGenerica;
import com.user.login.modelo.titulacion.comisiont;
import com.user.login.repo.titulacion.ComisionTRepo;

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
public class ComisionTController {


    @Autowired
    private ComisionTRepo  comisionRepoT;


    @GetMapping("/listaComisionT")
    public  List<comisiont> ListaComisionT(){
        List<comisiont> docentes = comisionRepoT.findAll();
        System.out.println(docentes.size());
        return docentes;

    }    

    @GetMapping("/listaComsionT/{nombre}")
    public comisiont BuscarPorNombre(@PathVariable String nombre){
        comisiont comisionv = comisionRepoT.findByNombre(nombre);
        return comisionv;
        
    }


    @PostMapping("/nuevaComisionT")
    public ResponseEntity<RespuestaGenerica> CrearNuevaComisionT(@RequestBody comisiont comisions){
        
        List<comisiont> data = new ArrayList<comisiont>();
        RespuestaGenerica<comisiont> respuesta = new RespuestaGenerica<>();


        try{
            System.out.println("El nombre es "+comisions.getNombre());
            
            comisiont corInsert = comisionRepoT.save(comisions);
            if(corInsert!=null){
                data.add(corInsert);
                respuesta.setMensaje("Comision nueva ingresada exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }
            
            
           
        }
        catch(Exception ex){
            respuesta.setMensaje("Hubo un problema al insertar el nuevo Comision");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
            //return new ResponseEntity<>("El vehículo no ha sido ingresado",HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.CREATED);    

    }


    @PutMapping("/modificarComisionT/{id}")
    public ResponseEntity<RespuestaGenerica> ModificarComisionT(@RequestBody comisiont newComision,@PathVariable Integer id){
     List<comisiont> data = new ArrayList<comisiont>();

     RespuestaGenerica<comisiont> respuesta = new RespuestaGenerica<>();

     try{

        comisiont v1 =comisionRepoT.findById(id)
        .map(comisiont ->{
            comisiont.setNombre(newComision.getNombre());
            return comisionRepoT.save(comisiont);
        })
        .orElseGet(()->{
            return new comisiont();
        });
                     

        if (v1!=null) {
            data.add(newComision);
            respuesta.setMensaje("Comision T Actualizado exitosamente");
            respuesta.setData(data);
            respuesta.setEstado(0); 
        }else{
            data.add(newComision);
            respuesta.setMensaje("Comision T No Actualizado");
            respuesta.setData(data);
            respuesta.setEstado(1); 
        }


         
     }
     catch(Exception ex){
        respuesta.setMensaje("Hubo un problema al actualizar la Comision T");
        respuesta.setData(data);
        respuesta.setEstado(1);
        System.out.println("No se pudo almacenar el objeto en la base de datos");
         //return new ResponseEntity<>("El vehículo no ha sido ingresado",HttpStatus.INTERNAL_SERVER_ERROR);
         
     }
     return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
    }


    @DeleteMapping("/eliminarComisionT/{id}")
    public ResponseEntity EliminarComisionT(@PathVariable Integer id ){
        List<comisiont> data = new ArrayList<comisiont>();
        RespuestaGenerica<comisiont> respuesta = new RespuestaGenerica<>();
        try {
            
            comisionRepoT.deleteById(id);
            if(comisionRepoT!=null){
                data.add(new comisiont());
                respuesta.setMensaje("Comision T Eliminado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }else{
                data.add(new comisiont());
                respuesta.setMensaje("Comision T no Eliminado");
                respuesta.setData(data);
                respuesta.setEstado(1);
            }
        } catch (Exception e) {
            respuesta.setMensaje("Hubo un problema al eliminar  la Comision T");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
        }
        
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
    }




    
}
