package com.user.login.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.user.login.modelo.RespuestaGenerica;
import com.user.login.modelo.titulacion.documentot;
import com.user.login.repo.titulacion.DocumentoTRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class DocumentoTController {

    @Autowired
    private DocumentoTRepo documentoTRepo;

    @GetMapping("/listarDocumentosT/")
    public List<documentot> listaDocs() {
        List<documentot> lista = documentoTRepo.findAll();

        return lista;

    }

    @GetMapping("/listarDocumentosT/{id}")
    public documentot BuscarPorId(@PathVariable Integer id) {
        Optional<documentot> doc = documentoTRepo.findById(id);
        return doc.get();

    }

    @PostMapping("/nuevoDocumentoT/")
    public ResponseEntity<RespuestaGenerica> CrearNuevoDocumento(@RequestBody documentot doc) {
        List<documentot> data = new ArrayList<documentot>();
        RespuestaGenerica<documentot> respuesta = new RespuestaGenerica<>();
        try {
            System.out.println("El nombre es: " + doc.getNombre());
            documentot docInsert = documentoTRepo.save(doc);

            if (docInsert != null) {
                data.add(docInsert);
                respuesta.setMensaje("Documento ingresado exitosamente");
                respuesta.setEstado(0);
            }

        } catch (Exception e) {
            respuesta.setMensaje("Hubo un problema al crear el nuevo Documento");
            respuesta.setData(data);
            respuesta.setEstado(1);
        }
        return new ResponseEntity<RespuestaGenerica>(respuesta, HttpStatus.CREATED);
    }

    @PutMapping("/modificarDocumentoT/{id}")
    public ResponseEntity<RespuestaGenerica> modificarDocumento(@PathVariable Integer id, @RequestBody documentot newDoc) {
       
        List<documentot> data = new ArrayList<documentot>();
        RespuestaGenerica<documentot> respuesta = new RespuestaGenerica<>();
        try { 
            documentot d1 = documentoTRepo.findById(id).map(
                documentot->{
                    documentot.setNombre(newDoc.getNombre());
                    return documentoTRepo.save(documentot);
                }
            )
         .orElseGet(()->{
             return new documentot();
         });

         if (d1!=null) {
             data.add(newDoc);
             respuesta.setMensaje("Registro actualizado exitosamente");
             respuesta.setData(data);
             respuesta.setEstado(0);
             
         } else {
            data.add(newDoc);
            respuesta.setMensaje("Hubo un error al  actualizar Documento");
            respuesta.setData(data);
            respuesta.setEstado(1);
             
         }

        } catch (Exception e) {
            respuesta.setMensaje("Hubo un problema al modificar el nuevo Documento en la base de datos");
            respuesta.setData(data);
            respuesta.setEstado(1);
        }
        return new ResponseEntity<RespuestaGenerica>(respuesta, HttpStatus.OK);
    }
}

//TODO se considera que no se podra eliminar la documentacion en ninguno de los procesos: por lo indicado por JH en reunion