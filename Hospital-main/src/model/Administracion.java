package model;
import java.time.LocalDate;

public class Administracion {
	
	    private int id;
	    private int pacienteId;
	    private int medicamentoId;
	    private LocalDate fecha;
	    private String frecuencia; // ej: "cada 8 horas"
	    private int dosis; // cantidad por toma

	    public Administracion() {}

	    public Administracion(int id, int pacienteId, int medicamentoId, LocalDate fecha,
	                          String frecuencia, int dosis) {
	        this.id = id;
	        this.pacienteId = pacienteId;
	        this.medicamentoId = medicamentoId;
	        this.fecha = fecha;
	        this.frecuencia = frecuencia;
	        this.dosis = dosis;
	    }

	    // Getters y setters
	    public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public int getPacienteId() { return pacienteId; }
	    public void setPacienteId(int pacienteId) { this.pacienteId = pacienteId; }

	    public int getMedicamentoId() { return medicamentoId; }
	    public void setMedicamentoId(int medicamentoId) { this.medicamentoId = medicamentoId; }

	    public LocalDate getFecha() { return fecha; }
	    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

	    public String getFrecuencia() { return frecuencia; }
	    public void setFrecuencia(String frecuencia) { this.frecuencia = frecuencia; }

	    public int getDosis() { return dosis; }
	    public void setDosis(int dosis) { this.dosis = dosis; }

	    @Override
	    public String toString() {
	        return id + " - pacienteId:" + pacienteId + " medicamentoId:" + medicamentoId + " fecha:" + fecha;
	    }
	}
