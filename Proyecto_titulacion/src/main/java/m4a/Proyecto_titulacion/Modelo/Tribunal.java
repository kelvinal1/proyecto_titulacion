package m4a.Proyecto_titulacion.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tribunal")
public class Tribunal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id_tribunal;

    private String nombre;

    public Tribunal() {
    }

    public Tribunal(String nombre) {
        this.nombre = nombre;
    }

    public String getId_tribunal() {
        return id_tribunal;
    }

    public void setId_tribunal(String id_tribunal) {
        this.id_tribunal = id_tribunal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
