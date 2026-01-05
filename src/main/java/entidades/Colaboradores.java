package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Colaboradores
 *
 */
@Entity
@Table(name = "colaborador")
public class Colaboradores extends Personas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String clave;
	
	@ManyToOne
    @JoinColumn(name = "idParroquia")
    private Parroquias parroquia;
	
	public Colaboradores() {
		super();
	}

	public Parroquias getParroquias() {
		return parroquia;
	}

	public void setParroquias(Parroquias parroquias) {
		this.parroquia = parroquias;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		
		this.clave = clave;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

