package model;

public class Medicamento {
	
	    private int id;
	    private String nombre;
	    private int miligramos; // o dosis base
	    private String presentacion; // ej: tabletas, jarabe

	    public Medicamento() {}

	    public Medicamento(int id, String nombre, int miligramos, String presentacion) {
	        this.id = id;
	        this.nombre = nombre;
	        this.miligramos = miligramos;
	        this.presentacion = presentacion;
	    }

	    // Getters y setters
	    public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public String getNombre() { return nombre; }
	    public void setNombre(String nombre) { this.nombre = nombre; }

	    public int getMiligramos() { return miligramos; }
	    public void setMiligramos(int miligramos) { this.miligramos = miligramos; }

	    public String getPresentacion() { return presentacion; }
	    public void setPresentacion(String presentacion) { this.presentacion = presentacion; }

	    @Override
	    public String toString() {
	        return id + " - " + nombre + " (" + miligramos + " mg, " + presentacion + ")";
	    }
	}

