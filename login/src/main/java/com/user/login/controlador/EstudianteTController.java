package com.user.login.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.user.login.modelo.RespuestaGenerica;
import com.user.login.modelo.titulacion.estudiantet;
import com.user.login.repo.titulacion.EstudianteRepo;

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
public class EstudianteTController {
    
    @Autowired
    private EstudianteRepo estudianteRepo;

    @GetMapping("/listaEstudiantesT")
    public List<estudiantet> ListaEstudiantesT(){
        List<estudiantet> estudiantes=estudianteRepo.findAll();
        System.out.println(estudiantes.size());

        return estudiantes;
    } 

    @GetMapping("/listaEstudianteT/{correo}")
    public estudiantet BuscarPorCorreo(@PathVariable String correo){
        estudiantet estudiantet= estudianteRepo.findByCorreo(correo);
        return estudiantet;
        
    }

    @GetMapping("/verificarEstudianteT/{correo}")
    public boolean verificarCorreo(@PathVariable String correo){
        try {

            if (correo.contains("@tecazuay.edu.ec")) {

                estudiantet estudiantet= estudianteRepo.findByCorreo(correo);
                if (estudiantet.getCorreo().equals("")) {
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

    @PostMapping("/nuevoEst")
    public ResponseEntity<RespuestaGenerica> CrearNuevoEstudianteT(@RequestBody estudiantet vehiculo){
        
        List<estudiantet> data = new ArrayList<estudiantet>();
        RespuestaGenerica<estudiantet> respuesta = new RespuestaGenerica<>();


        try{
            System.out.println("El correo es "+vehiculo.getCorreo());
            
            estudiantet vehiculoInsert = estudianteRepo.save(vehiculo);
            if(vehiculoInsert!=null){
                data.add(vehiculoInsert);
                respuesta.setMensaje("Estudiante nuevo ingresado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }
            
            
           
        }
        catch(Exception ex){
            respuesta.setMensaje("Hubo un problema al insertar el nuevo estudiantes");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
            //return new ResponseEntity<>("El vehículo no ha sido ingresado",HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.CREATED);    

    }

    @PutMapping("/modificarEst/{cedula}")
    public ResponseEntity<RespuestaGenerica> ModificarEstudianteT(@RequestBody estudiantet newEstudiantet,@PathVariable String cedula){
        List<estudiantet> data = new ArrayList<estudiantet>();

        RespuestaGenerica<estudiantet> respuesta = new RespuestaGenerica<>();

        try{

            estudiantet v1 = estudianteRepo.findById(cedula)
            .map(estudiantet ->{
                estudiantet.setCorreo(newEstudiantet.getCorreo());
                estudiantet.setNombre(newEstudiantet.getNombre());
                return estudianteRepo.save(estudiantet);
            })
            .orElseGet(()->{
                return new estudiantet();
            });
                        

            if (v1!=null) {
                data.add(newEstudiantet);
                respuesta.setMensaje("Estudiante T Actualizado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0); 
            }else{
                data.add(newEstudiantet);
                respuesta.setMensaje("Estudiante T No Actualizado");
                respuesta.setData(data);
                respuesta.setEstado(1); 
            }


            
        }
        catch(Exception ex){
            respuesta.setMensaje("Hubo un problema al actualizar el estudainte T");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
            //return new ResponseEntity<>("El vehículo no ha sido ingresado",HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
    }

    @DeleteMapping("/eliminarEst/{cedula}")
    public ResponseEntity EliminarEstudianteT(@PathVariable String cedula ){
        List<estudiantet> data = new ArrayList<estudiantet>();
        RespuestaGenerica<estudiantet> respuesta = new RespuestaGenerica<>();
        try {
            
            estudianteRepo.deleteById(cedula);
            if(estudianteRepo!=null){
                data.add(new estudiantet());
                respuesta.setMensaje("Estudiante T Eliminado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }else{
                data.add(new estudiantet());
                respuesta.setMensaje("Estuidiante T NO Eliminado");
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
