package m4a.Proyecto_titulacion.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tutor")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id_tutor;
    
    private String id_docente;

    public Tutor() {
    }

    public Tutor(String id_docente) {
        this.id_docente = id_docente;
    }

    public String getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(String id_tutor) {
        this.id_tutor = id_tutor;
    }

    public String getId_docente() {
        return id_docente;
    }

    public void setId_docente(String id_docente) {
        this.id_docente = id_docente;
    }

    
}
