package ui;

import dao.pacienteDAO;
import model.Paciente;

public class TestPaciente {
    public static void main(String[] args) {

        Paciente p = new Paciente(
            0,
            "Carlos Gómez",
            47,
            "Masculino",
            "O+",
            "Penicilina",
            "Hipertensión"
        );

        pacienteDAO dao = new pacienteDAO();
        dao.insertar(p);
    }
}
