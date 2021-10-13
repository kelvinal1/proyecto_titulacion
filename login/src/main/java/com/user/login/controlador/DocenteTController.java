package com.user.login.controlador;

import java.util.ArrayList;
import java.util.List;

import com.user.login.modelo.RespuestaGenerica;
import com.user.login.modelo.titulacion.docentet;
import com.user.login.repo.titulacion.DocenteTRepo;

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
public class DocenteTController {

    @Autowired
    private DocenteTRepo docenteTRepo;

    @GetMapping("/listaDocentesT")
    public  List<docentet> ListaDocentesT(){
        List<docentet> docentes = docenteTRepo.findAll();
        System.out.println(docentes.size());
        return docentes;

    }    

    @GetMapping("/listaDocenteT/{correo}")
    public docentet BuscarPorCorreo(@PathVariable String correo){
        docentet docentet=docenteTRepo.findByCorreo(correo);
        return docentet;
        
    }

    @GetMapping("/verificarDocenteT/{correo}")
    public boolean verificarCorreo(@PathVariable String correo){
        try {

            if (correo.contains("@tecazuay.edu.ec")) {

                docentet docentet= docenteTRepo.findByCorreo(correo);
                if (docentet.getCorreo().equals("")) {
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

    @PostMapping("/nuevoDocente")
    public ResponseEntity<RespuestaGenerica> CrearNuevoEstudianteT(@RequestBody docentet don){
        
        List<docentet> data = new ArrayList<docentet>();
        RespuestaGenerica<docentet> respuesta = new RespuestaGenerica<>();


        try{
            System.out.println("El correo es "+don.getCorreo());
            
            docentet docenteInsert = docenteTRepo.save(don);
            if(docenteInsert!=null){
                data.add(docenteInsert);
                respuesta.setMensaje("Docente nuevo ingresado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }
            
            
           
        }
        catch(Exception ex){
            respuesta.setMensaje("Hubo un problema al insertar el nuevo docente");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
            //return new ResponseEntity<>("El vehículo no ha sido ingresado",HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.CREATED);    

    }

    @PutMapping("/modificarDoc/{cedula}")
    public ResponseEntity<RespuestaGenerica> ModificarDocenteT(@RequestBody docentet newDocentet,@PathVariable String cedula){
        List<docentet> data = new ArrayList<docentet>();

        RespuestaGenerica<docentet> respuesta = new RespuestaGenerica<>();

        try{

            docentet v1 = docenteTRepo.findById(cedula)
            .map(docentet ->{
                docentet.setCorreo(newDocentet.getCorreo());
                docentet.setNombre(newDocentet.getNombre());
                return docenteTRepo.save(docentet);
            })
            .orElseGet(()->{
                return new docentet();
            });
                        

            if (v1!=null) {
                data.add(newDocentet);
                respuesta.setMensaje("Docente T Actualizado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0); 
            }else{
                data.add(newDocentet);
                respuesta.setMensaje("Docente T No Actualizado");
                respuesta.setData(data);
                respuesta.setEstado(1); 
            }


            
        }
        catch(Exception ex){
            respuesta.setMensaje("Hubo un problema al actualizar el Docente T");
            respuesta.setData(data);
            respuesta.setEstado(1);
            System.out.println("No se pudo almacenar el objeto en la base de datos");
            //return new ResponseEntity<>("El vehículo no ha sido ingresado",HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        return new ResponseEntity<RespuestaGenerica>(respuesta,HttpStatus.OK);
    }

    @DeleteMapping("/eliminarDoc/{cedula}")
    public ResponseEntity EliminarDocenteT(@PathVariable String cedula ){
        List<docentet> data = new ArrayList<docentet>();
        RespuestaGenerica<docentet> respuesta = new RespuestaGenerica<>();
        try {
            
            docenteTRepo.deleteById(cedula);
            if(docenteTRepo!=null){
                data.add(new docentet());
                respuesta.setMensaje("Docente T Eliminado exitosamente");
                respuesta.setData(data);
                respuesta.setEstado(0);
            }else{
                data.add(new docentet());
                respuesta.setMensaje("Docente T NO Eliminado");
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
