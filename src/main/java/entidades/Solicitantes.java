package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Solicitantes
 *
 */
@Entity
public class Solicitantes extends Personas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cedula;
    
    @ManyToMany(mappedBy = "solicitantes")
    private List<Entrevistas> entrevistas = new ArrayList<>();
    
    private static final long serialVersionUID = 1L;

    public Solicitantes() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

	public List<Entrevistas> getEntrevistas() {
		return entrevistas;
	}

	public void setEntrevistas(List<Entrevistas> entrevistas) {
		this.entrevistas = entrevistas;
	}

	@Override
	public String toString() {
		return "Solicitantes [id=" + id + ", cedula=" + cedula + "]";
	}
    
    
}
