package entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity

public class Asignadas implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "entrevista_id", nullable = false)
    private Entrevistas entrevista;

    @Column(name = "tipo_opcion")
    private String tipoOpcion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

	public Entrevistas getEntrevista() {
		return entrevista;
	}

	public void setEntrevista(Entrevistas entrevista) {
		this.entrevista = entrevista;
	}

	public String getTipoOpcion() {
		return tipoOpcion;
	}

	public void setTipoOpcion(String tipoOpcion) {
		this.tipoOpcion = tipoOpcion;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
}
