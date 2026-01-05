package entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ayudas
 *
 */
@Entity
public class Ayudas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String Descripcion;
    private Byte activo;

    @OneToMany(mappedBy = "ayuda", fetch = FetchType.LAZY)
    private List<Entrevistas> entrevistas;

    private static final long serialVersionUID = 1L;

    public Ayudas() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


	public List<Entrevistas> getEntrevistas() {
		return entrevistas;
	}

	public void setEntrevistas(List<Entrevistas> entrevistas) {
		this.entrevistas = entrevistas;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Byte getActivo() {
		return activo;
	}

	public void setActivo(Byte activo) {
		this.activo = activo;
	}
    
}
