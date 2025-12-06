package model;

public class Paciente {
	private int id;
	private String nombre;
	private int edad;
	private String sexo;
	private String tipoSangre;
	private String alergias;
	private String diagnostico;

	public Paciente() {
	}

	public Paciente(final int id, final String nombre, final int edad, final String sexo, final String tipoSangre,
			final String alergias, final String diagnostico) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.tipoSangre = tipoSangre;
		this.alergias = alergias;
		this.diagnostico = diagnostico;
	}

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(final int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(final String sexo) {
		this.sexo = sexo;
	}

	public String getTipoSangre() {
		return this.tipoSangre;
	}

	public void setTipoSangre(final String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	public String getAlergias() {
		return this.alergias;
	}

	public void setAlergias(final String alergias) {
		this.alergias = alergias;
	}

	public String getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(final String diagnostico) {
		this.diagnostico = diagnostico;
	}

	@Override
	public String toString() {
		return this.id + " - " + this.nombre + " (edad: " + this.edad + ", sexo: " + this.sexo + ", sangre: "
				+ this.tipoSangre + ", alergias: " + this.alergias + ", diagnóstico: " + this.diagnostico;
	}
}