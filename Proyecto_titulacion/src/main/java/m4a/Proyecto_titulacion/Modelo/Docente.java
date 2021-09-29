package m4a.Proyecto_titulacion.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_docente;

    private String nombre;

    public Docente() {
    }

    public Docente(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_docente() {
        return id_docente;
    }

    public void setId_docente(Long id_docente) {
        this.id_docente = id_docente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
