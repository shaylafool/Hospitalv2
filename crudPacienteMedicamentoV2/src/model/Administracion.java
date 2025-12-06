package model;

import java.time.LocalDate;

public class Administracion {
	private int id;
	private int pacienteId;
	private int medicamentoId;
	private LocalDate fecha;
	private String frecuencia;
	private int dosis;

	public Administracion() {
	}

	public Administracion(final int id, final int pacienteId, final int medicamentoId, final LocalDate fecha,
			final String frecuencia, final int dosis) {
		this.id = id;
		this.pacienteId = pacienteId;
		this.medicamentoId = medicamentoId;
		this.fecha = fecha;
		this.frecuencia = frecuencia;
		this.dosis = dosis;
	}

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getPacienteId() {
		return this.pacienteId;
	}

	public void setPacienteId(final int pacienteId) {
		this.pacienteId = pacienteId;
	}

	public int getMedicamentoId() {
		return this.medicamentoId;
	}

	public void setMedicamentoId(final int medicamentoId) {
		this.medicamentoId = medicamentoId;
	}

	public LocalDate getFecha() {
		return this.fecha;
	}

	public void setFecha(final LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getFrecuencia() {
		return this.frecuencia;
	}

	public void setFrecuencia(final String frecuencia) {
		this.frecuencia = frecuencia;
	}

	public int getDosis() {
		return this.dosis;
	}

	public void setDosis(final int dosis) {
		this.dosis = dosis;
	}

	@Override
	public String toString() {
		return "Administración #" + this.id + " -> Paciente: " + this.pacienteId + ", Medicamento: "
				+ this.medicamentoId + ", Fecha: " + String.valueOf(this.fecha) + ", Frecuencia: " + this.frecuencia
				+ ", Dosis: " + this.dosis;
	}
}