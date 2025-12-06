package model;

public class Medicamento {
	private int id;
	private String nombre;
	private int miligramos;
	private String descripcion;
	private String presentacion;

	public Medicamento() {
	}

	public Medicamento(final int id, final String nombre, final int miligramos, final String descripcion,
			final String presentacion) {
		this.id = id;
		this.nombre = nombre;
		this.miligramos = miligramos;
		this.descripcion = descripcion;
		this.presentacion = presentacion;
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

	public int getMiligramos() {
		return this.miligramos;
	}

	public void setMiligramos(final int miligramos) {
		this.miligramos = miligramos;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPresentacion() {
		return this.presentacion;
	}

	public void setPresentacion(final String presentacion) {
		this.presentacion = presentacion;
	}

	@Override
	public String toString() {
		return this.id + " - " + this.nombre + " (mg: " + this.miligramos + ", presentacion: " + this.presentacion
				+ ", descripcion: " + this.descripcion;
	}
}