package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Parroquias
 *
 */
@Entity
@Table(name = "parroquia")
public class Parroquias implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	@OneToMany(mappedBy = "parroquia")
    private List<Colaboradores> colaboradores = new ArrayList<>();
	
	
	private static final long serialVersionUID = 1L;

	public Parroquias() {
		super();
	}

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

	@Override
	public String toString() {
		return  nombre;
	}

	public List<Colaboradores> getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(List<Colaboradores> colaboradores) {
		this.colaboradores = colaboradores;
	}
	
	
	
	
}
