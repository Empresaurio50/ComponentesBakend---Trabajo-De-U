package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Entrevistas implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToMany
	@JoinTable(name = "entrevista_solicitante", joinColumns = @JoinColumn(name = "idEntrevista"), inverseJoinColumns = @JoinColumn(name = "idSolicitante"))
	private List<Solicitantes> solicitantes = new ArrayList<>();

	@OneToMany(mappedBy = "entrevista", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ArchivoAdjunto> archivos = new ArrayList<>();

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private String empleo;
	private String ingresosEstables;
	private String aporteFamiliar;

	private Integer ingresoMensual;

	private String menores;
	private String adultosMayores;
	private String discapacidad;

	private Integer integrantes;

	private String viviendaPropia;
	private String pagaAlquiler;
	private String problemasVivienda;

	private String enfermedadCronica;
	private String medicacionCostosa;

	private String faltaComida;
	private String dependenciaDonaciones;

	@Column(length = 500)
	private String observaciones;

	@ManyToOne
	@JoinColumn(name = "idColaborador")
	private Colaboradores colaborador;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "ayuda_id")
	private Ayudas ayuda;

	@OneToOne
	@JoinColumn(name = "idParroquia")
	private Parroquias parroquias;

	@OneToMany(mappedBy = "entrevista", cascade = CascadeType.ALL)
	private List<Asignadas> asignadas;

	private static final long serialVersionUID = 1L;

	public Entrevistas() {
		this.fecha = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEmpleo() {
		return empleo;
	}

	public void setEmpleo(String empleo) {
		this.empleo = empleo;
	}

	public String getIngresosEstables() {
		return ingresosEstables;
	}

	public void setIngresosEstables(String ingresosEstables) {
		this.ingresosEstables = ingresosEstables;
	}

	public String getAporteFamiliar() {
		return aporteFamiliar;
	}

	public void setAporteFamiliar(String aporteFamiliar) {
		this.aporteFamiliar = aporteFamiliar;
	}

	public Integer getIngresoMensual() {
		return ingresoMensual;
	}

	public void setIngresoMensual(Integer ingresoMensual) {
		this.ingresoMensual = ingresoMensual;
	}

	public String getMenores() {
		return menores;
	}

	public void setMenores(String menores) {
		this.menores = menores;
	}

	public String getAdultosMayores() {
		return adultosMayores;
	}

	public void setAdultosMayores(String adultosMayores) {
		this.adultosMayores = adultosMayores;
	}

	public String getDiscapacidad() {
		return discapacidad;
	}

	public void setDiscapacidad(String discapacidad) {
		this.discapacidad = discapacidad;
	}

	public Integer getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(Integer integrantes) {
		this.integrantes = integrantes;
	}

	public String getViviendaPropia() {
		return viviendaPropia;
	}

	public void setViviendaPropia(String viviendaPropia) {
		this.viviendaPropia = viviendaPropia;
	}

	public String getPagaAlquiler() {
		return pagaAlquiler;
	}

	public void setPagaAlquiler(String pagaAlquiler) {
		this.pagaAlquiler = pagaAlquiler;
	}

	public String getProblemasVivienda() {
		return problemasVivienda;
	}

	public void setProblemasVivienda(String problemasVivienda) {
		this.problemasVivienda = problemasVivienda;
	}

	public String getEnfermedadCronica() {
		return enfermedadCronica;
	}

	public void setEnfermedadCronica(String enfermedadCronica) {
		this.enfermedadCronica = enfermedadCronica;
	}

	public String getMedicacionCostosa() {
		return medicacionCostosa;
	}

	public void setMedicacionCostosa(String medicacionCostosa) {
		this.medicacionCostosa = medicacionCostosa;
	}

	public String getFaltaComida() {
		return faltaComida;
	}

	public void setFaltaComida(String faltaComida) {
		this.faltaComida = faltaComida;
	}

	public String getDependenciaDonaciones() {
		return dependenciaDonaciones;
	}

	public void setDependenciaDonaciones(String dependenciaDonaciones) {
		this.dependenciaDonaciones = dependenciaDonaciones;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Colaboradores getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaboradores colaborador) {
		this.colaborador = colaborador;
	}

	public List<Solicitantes> getListSolicitantes() {
		return solicitantes;
	}

	public void setListSolicitantes(List<Solicitantes> listSolicitantes) {
		this.solicitantes = listSolicitantes;
	}

	public Parroquias getParroquias() {
		return parroquias;
	}

	public void setParroquias(Parroquias parroquias) {
		this.parroquias = parroquias;
	}

	public Ayudas getAyuda() {
		return ayuda;
	}

	public void setAyuda(Ayudas ayuda) {
		this.ayuda = ayuda;
	}

	public List<Asignadas> getAsignadas() {
		return asignadas;
	}

	public void setAsignadas(List<Asignadas> asignadas) {
		this.asignadas = asignadas;
	}

	public List<ArchivoAdjunto> getArchivos() {
		return archivos;
	}

	public void setArchivos(List<ArchivoAdjunto> archivos) {
		this.archivos = archivos;
	}

}