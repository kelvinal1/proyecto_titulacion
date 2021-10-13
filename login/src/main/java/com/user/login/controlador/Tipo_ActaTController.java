package com.user.login.controlador;

import java.util.ArrayList;
import java.util.List;

import com.user.login.modelo.RespuestaGenerica;
import com.user.login.modelo.titulacion.t_actat;
import com.user.login.repo.titulacion.Tipo_ActaTRepo;

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
public class Tipo_ActaTController {

    @Autowired
    private Tipo_ActaTRepo tipo_actaRepoT;




    @GetMapping("/listaActasT")
    public  List<t_actat> ListaActasT(){
        List<t_actat> docentes = tipo_actaRepoT.findAll();
        System.out.println(docentes.size());
        return docentes;

    }    

    @GetMapping("/listaActasT/{nombre}")
    public t_actat BuscarPorNombre(@PathVariable String nombre){
        t_actat actat = tipo_actaRepoT.findByNombre(nombre);
        return actat;
        
    }

    @PostMapping("/nuevasActasT")
    public ResponseEntity<RespuestaGenerica> CrearNuevaActaT(@RequestBody t_actat actas){
        
        List<t_actat> data = new ArrayList<t_actat>();
        RespuestaGenerica<t_actat> respuesta = new RespuestaGenerica<>();


        try{
            System.out.println("El nombre es "+actas.getNombre());
            
            t_actat corInsert = tipo_actaRepoT.save(actas);
            if(corInsert!=null){
                data.add(corInsert);
                respuesta.setMensaje("Acta nueva ingresado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }
            
            
           
        }
        catch(Exception ex){
            respuesta.setMensaje("Hubo un problema al insertar el nuevo Acta");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
            //return new ResponseEntity<>("El vehículo no ha sido ingresado",HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.CREATED);    

    }


   
    @PutMapping("/modificarActaT/{id}")
    public ResponseEntity<RespuestaGenerica> ModificarActaT(@RequestBody t_actat newActa,@PathVariable Integer id){
     List<t_actat> data = new ArrayList<t_actat>();

     RespuestaGenerica<t_actat> respuesta = new RespuestaGenerica<>();

     try{

        t_actat v1 = tipo_actaRepoT.findById(id)
        .map(t_actat ->{
            t_actat.setNombre(newActa.getNombre());
            return tipo_actaRepoT.save(t_actat);
        })
        .orElseGet(()->{
            return new t_actat();
        });
                     

        if (v1!=null) {
            data.add(newActa);
            respuesta.setMensaje("Acta T Actualizado exitosamente");
            respuesta.setData(data);
            respuesta.setEstado(0); 
        }else{
            data.add(newActa);
            respuesta.setMensaje("Acta T No Actualizado");
            respuesta.setData(data);
            respuesta.setEstado(1); 
        }


         
     }
     catch(Exception ex){
        respuesta.setMensaje("Hubo un problema al actualizar el Acta T");
        respuesta.setData(data);
        respuesta.setEstado(1);
        System.out.println("No se pudo almacenar el objeto en la base de datos");
         //return new ResponseEntity<>("El vehículo no ha sido ingresado",HttpStatus.INTERNAL_SERVER_ERROR);
         
     }
     return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
    }



    @DeleteMapping("/eliminarActaT/{id}")
    public ResponseEntity EliminarActaT(@PathVariable Integer id ){
        List<t_actat> data = new ArrayList<t_actat>();
        RespuestaGenerica<t_actat> respuesta = new RespuestaGenerica<>();
        try {
            
            tipo_actaRepoT.deleteById(id);
            if(tipo_actaRepoT!=null){
                data.add(new t_actat());
                respuesta.setMensaje("Acta T Eliminado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }else{
                data.add(new t_actat());
                respuesta.setMensaje("Acta T no Eliminado");
                respuesta.setData(data);
                respuesta.setEstado(1);
            }
        } catch (Exception e) {
            respuesta.setMensaje("Hubo un problema al eliminar el Acta T");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
        }
        
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
    }







    
}
