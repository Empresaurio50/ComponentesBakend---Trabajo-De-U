package entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "eventos")
public class Eventos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_parroquia", nullable = false)
    private Parroquias parroquia;


    public Eventos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Parroquias getParroquia() {
        return parroquia;
    }

    public void setParroquia(Parroquias parroquia) {
        this.parroquia = parroquia;
    }
}
