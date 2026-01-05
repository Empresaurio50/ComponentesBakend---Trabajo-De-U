package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "archivo_adjunto")
public class ArchivoAdjunto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombreArchivo;
    private String tipoArchivo;
    private String ruta;
    private long tamano;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "idEntrevista"
    )
    private Entrevistas entrevista;

    private static final long serialVersionUID = 1L;

    public ArchivoAdjunto() {}

    public int getId() {
        return id;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public long getTamano() {
        return tamano;
    }

    public void setTamano(long tamano) {
        this.tamano = tamano;
    }

    public Entrevistas getEntrevista() {
        return entrevista;
    }

    public void setEntrevista(Entrevistas entrevista) {
        this.entrevista = entrevista;
    }
}