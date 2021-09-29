package m4a.Proyecto_titulacion.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coordinador")
public class Coordinador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_coordinador;

    private String nombre;

    public Coordinador() {
    }

    public Coordinador(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_coordinador() {
        return id_coordinador;
    }

    public void setId_coordinador(Long id_coordinador) {
        this.id_coordinador = id_coordinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}
