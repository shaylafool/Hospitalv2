package main;

import java.util.*;
import dao.pacienteDAO;
import dao.medicamentoDAO;
import dao.administracionDAO;
import model.Paciente;
import model.Medicamento;
import model.Administracion;
import java.time.LocalDate;

public class main {

    public static void main(String[] args) {
        
        pacienteDAO pacienteDao = new pacienteDAO();
        medicamentoDAO medicamentoDao = new medicamentoDAO();
        administracionDAO adminDao = new administracionDAO();
        
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== SISTEMA HOSPITALARIO =====");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Registrar medicamento");
            System.out.println("3. Administrar medicamento a paciente");
            System.out.println("4. Ver pacientes");
            System.out.println("5. Ver medicamentos");
            System.out.println("6. Ver pacientes con medicamentos administrados");
            System.out.println("7. Eliminar paciente");
            System.out.println("8. Eliminar medicamento");
            System.out.println("9. Salir");
            System.out.print("Seleccione opción: ");
            
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                
                case 1 -> {
                    System.out.println("== Registrar paciente ==");
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt(); sc.nextLine();
                    System.out.print("Sexo: ");
                    String sexo = sc.nextLine();
                    System.out.print("Tipo de sangre: ");
                    String sangre = sc.nextLine();
                    System.out.print("Alergias: ");
                    String alergias = sc.nextLine();
                    System.out.print("Diagnóstico: ");
                    String diagnostico = sc.nextLine();

                    Paciente p = new Paciente(0, nombre, edad, sexo, sangre, alergias, diagnostico);
                    pacienteDao.insertar(p);
                }

                case 2 -> {
                    System.out.println("== Registrar medicamento ==");
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Descripción: ");
                    String desc = sc.nextLine();
                    System.out.print("Dosis recomendada: ");
                    int dosisRec = sc.nextInt();

                    Medicamento m = new Medicamento(0, nombre,dosisRec, desc );
                    medicamentoDao.insertar(m);
                }

                case 3 -> {
                    System.out.println("== Administrar medicamento ==");
                    System.out.print("ID del paciente: ");
                    int pId = sc.nextInt();
                    System.out.print("ID del medicamento: ");
                    int mId = sc.nextInt(); sc.nextLine();
                    System.out.print("Frecuencia (ej: cada 8 horas): ");
                    String freq = sc.nextLine();
                    System.out.print("Dosis suministrada: ");
                    int dosis = sc.nextInt();

                    Administracion a = new Administracion(0, pId, mId, LocalDate.now(), freq, dosis);
                    adminDao.insertar(a);
                }

                case 4 -> {
                    System.out.println("== Lista de pacientes ==");
                    pacienteDao.listar().forEach(System.out::println);
                }

                case 5 -> {
                    System.out.println("== Lista de medicamentos ==");
                    medicamentoDao.listar().forEach(System.out::println);
                }

                case 6 -> {
                    System.out.println("== Administraciones ==");
                    adminDao.listar().forEach(System.out::println);
                }

                case 7 -> {
                    System.out.println("== Eliminar paciente ==");
                    System.out.print("Ingrese ID del paciente: ");
                    int id = sc.nextInt();
                    pacienteDao.eliminar(id);
                }

                case 8 -> {
                    System.out.println("== Eliminar medicamento ==");
                    System.out.print("Ingrese ID del medicamento: ");
                    int id = sc.nextInt();
                    medicamentoDao.eliminar(id);
                }

                case 9 -> {
                    System.out.println("Saliendo del sistema...");
                }

                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 9);
    }
}
