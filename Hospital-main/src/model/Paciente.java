package model;
public class Paciente {
	
    private int id;
    private String nombre;
    private int edad;
    private String sexo;
    private String tipoSangre;
    private String alergias;
    private String diagnostico;

    public Paciente() {}

    public Paciente(int id, String nombre, int edad, String sexo, String tipoSangre,
                    String alergias, String diagnostico) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.tipoSangre = tipoSangre;
        this.alergias = alergias;
        this.diagnostico = diagnostico;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getTipoSangre() { return tipoSangre; }
    public void setTipoSangre(String tipoSangre) { this.tipoSangre = tipoSangre; }

    public String getAlergias() { return alergias; }
    public void setAlergias(String alergias) { this.alergias = alergias; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    @Override
    public String toString() {
        return id + " - " + nombre + " (edad: " + edad + ", sangre: " + tipoSangre + ")";
    }
}


