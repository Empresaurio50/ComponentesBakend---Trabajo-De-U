package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Personas
 *
 */
@MappedSuperclass
public abstract class Personas implements Serializable {


	private String nombre;
	private String apellido;
	private String telefono;
	private static final long serialVersionUID = 1L;

	public Personas() {
		super();
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}   
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {

	    this.telefono = telefono;
	}
   
}