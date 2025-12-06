package ui;

import dao.pacienteDAO;
import dao.medicamentoDAO;
import dao.administracionDAO;
import model.Paciente;
import model.Medicamento;
import model.Administracion;
import java.time.LocalDate;

public class TestFinal {
    public static void main(String[] args) {

        pacienteDAO pDAO = new pacienteDAO();
        medicamentoDAO mDAO = new medicamentoDAO();
        administracionDAO aDAO = new administracionDAO();

        System.out.println("============== 1. Insertar paciente ==============");
        Paciente pac = new Paciente(0, "Juan Ramirez", 60, "M", "O+", "Penicilina", "Diabetes");
        pDAO.insertar(pac);

        System.out.println("\n============== 2. Insertar medicamento ==============");
        Medicamento med = new Medicamento(0, "Metformina", 500, "Tabletas");
        mDAO.insertar(med);

        System.out.println("\n============== 3. Asignar medicamento al paciente ==============");
        Administracion admin = new Administracion(
            0,
            1, // id del paciente
            1, // id del medicamento
            LocalDate.now(),
            "cada 12 horas",
            1
        );
        aDAO.insertar(admin);

        System.out.println("\n============== 4. Listar pacientes ==============");
        pDAO.listar().forEach(System.out::println);

        System.out.println("\n============== 5. Listar medicamentos ==============");
        mDAO.listar().forEach(System.out::println);

        System.out.println("\n============== 6. Listar administraciones ==============");
        aDAO.listar().forEach(System.out::println);

        System.out.println("\n============== 7. VER qué medicamento tiene un paciente ==============");
        System.out.println("Paciente Juan Ramirez tiene el medicamento:");
        
        mDAO.listar().stream().forEach(System.out::println);
    }
}
