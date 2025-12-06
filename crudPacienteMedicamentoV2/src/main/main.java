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

    // Códigos ANSI para colores
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";
    public static final String PURPLE = "\u001B[35m";
    public static final String WHITE = "\u001B[37m";
    public static final String BLACK = "\u001B[30m";
    public static final String BOLD = "\u001B[1m";

    public static void main(String[] args) {
        
        pacienteDAO pacienteDao = new pacienteDAO();
        medicamentoDAO medicamentoDao = new medicamentoDAO();
        administracionDAO adminDao = new administracionDAO();
        
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            limpiarPantalla();
            mostrarMenu();
            
            System.out.print(RED + "Seleccione una opción: " + RESET);
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                
                case 1 -> {
                    limpiarPantalla();
                    System.out.println(CYAN + "╔═══════════════════════════════════════════════╗" + RESET);
                    System.out.println(CYAN + "║" + BOLD + "          REGISTRAR NUEVO PACIENTE            " + RESET + CYAN + "║" + RESET);
                    System.out.println(CYAN + "╚═══════════════════════════════════════════════╝" + RESET);
                    System.out.print(YELLOW + "\nCédula: " + RESET);
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print(YELLOW + "Nombre completo: " + RESET);
                    String nombre = sc.nextLine();
                    System.out.print(YELLOW + "Edad: " + RESET);
                    int edad = sc.nextInt();
                    sc.nextLine();
                    System.out.print(YELLOW + "Sexo (M/F): " + RESET);
                    String sexo = sc.nextLine();
                    System.out.print(YELLOW + "Tipo de sangre: " + RESET);
                    String sangre = sc.nextLine();
                    System.out.print(YELLOW + "Alergias: " + RESET);
                    String alergias = sc.nextLine();
                    System.out.print(YELLOW + "Diagnóstico: " + RESET);
                    String diagnostico = sc.nextLine();

                    Paciente p = new Paciente(id, nombre, edad, sexo, sangre, alergias, diagnostico);
                    pacienteDao.insertar(p);
                    
                    System.out.println(GREEN + "\n✔ Paciente registrado exitosamente" + RESET);
                    pausar(sc);
                }

                case 2 -> {
                    limpiarPantalla();
                    System.out.println(PURPLE + "╔═══════════════════════════════════════════════╗" + RESET);
                    System.out.println(PURPLE + "║" + BOLD + "         REGISTRAR NUEVO MEDICAMENTO          " + RESET + PURPLE + "║" + RESET);
                    System.out.println(PURPLE + "╚═══════════════════════════════════════════════╝" + RESET);
                    System.out.print(YELLOW + "\nCódigo del medicamento: " + RESET);
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print(YELLOW + "Nombre: " + RESET);
                    String nombre = sc.nextLine();
                    System.out.print(YELLOW + "Presentación (tabletas/jarabe/etc): " + RESET);
                    String present = sc.nextLine();
                    System.out.print(YELLOW + "Descripción: " + RESET);
                    String des = sc.nextLine();
                    System.out.print(YELLOW + "Dosis recomendada (mg): " + RESET);
                    int dosisRec = sc.nextInt();
                    sc.nextLine(); // Consumir el salto de línea

                    Medicamento m = new Medicamento(id, nombre, dosisRec, present, des);
                    medicamentoDao.insertar(m);
                    
                    System.out.println(GREEN + "\n✔ Medicamento registrado exitosamente" + RESET);
                    pausar(sc);
                }

                case 3 -> {
                    limpiarPantalla();
                    System.out.println(BLUE + "╔═══════════════════════════════════════════════╗" + RESET);
                    System.out.println(BLUE + "║" + BOLD + "            ADMINISTRAR MEDICAMENTO           " + RESET + BLUE + "║" + RESET);
                    System.out.println(BLUE + "╚═══════════════════════════════════════════════╝" + RESET);
                    System.out.print(YELLOW + "\nID del paciente: " + RESET);
                    int pId = sc.nextInt();
                    System.out.print(YELLOW + "ID del medicamento: " + RESET);
                    int mId = sc.nextInt();
                    sc.nextLine();
                    System.out.print(YELLOW + "Frecuencia (ej: cada 8 horas): " + RESET);
                    String freq = sc.nextLine();
                    System.out.print(YELLOW + "Dosis suministrada (mg): " + RESET);
                    int dosis = sc.nextInt();
                    sc.nextLine(); // Consumir el salto de línea

                    Administracion a = new Administracion(0, pId, mId, LocalDate.now(), freq, dosis);
                    adminDao.insertar(a);
                    
                    System.out.println(GREEN + "\n✔ Medicamento administrado exitosamente" + RESET);
                    pausar(sc);
                }

                case 4 -> {
                    limpiarPantalla();
                    System.out.println(CYAN + "╔═══════════════════════════════════════════════╗" + RESET);
                    System.out.println(CYAN + "║" + BOLD + "              LISTA DE PACIENTES              " + RESET + CYAN + "║" + RESET);
                    System.out.println(CYAN + "╚═══════════════════════════════════════════════╝" + RESET);
                    System.out.println();
                    
                    List<Paciente> pacientes = pacienteDao.listar();
                    if (pacientes.isEmpty()) {
                        System.out.println(YELLOW + "No hay pacientes registrados." + RESET);
                    } else {
                        pacientes.forEach(p -> System.out.println("► " + p));
                    }
                    
                    pausar(sc);
                }

                case 5 -> {
                    limpiarPantalla();
                    System.out.println(PURPLE + "╔═══════════════════════════════════════════════╗" + RESET);
                    System.out.println(PURPLE + "║" + BOLD + "             LISTA DE MEDICAMENTOS            " + RESET + PURPLE + "║" + RESET);
                    System.out.println(PURPLE + "╚═══════════════════════════════════════════════╝" + RESET);
                    System.out.println();
                    
                    List<Medicamento> medicamentos = medicamentoDao.listar();
                    if (medicamentos.isEmpty()) {
                        System.out.println(YELLOW + "No hay medicamentos registrados." + RESET);
                    } else {
                        medicamentos.forEach(m -> System.out.println("► " + m));
                    }
                    
                    pausar(sc);
                }

                case 6 -> {
                    int subop;
                    do {
                        limpiarPantalla();
                        System.out.println(BLUE + "╔═══════════════════════════════════════════════╗" + RESET);
                        System.out.println(BLUE + "║" + BOLD + "          ADMINISTRACIONES REGISTRADAS        " + RESET + BLUE + "║" + RESET);
                        System.out.println(BLUE + "╚═══════════════════════════════════════════════╝" + RESET);
                        System.out.println();
                        
                        List<Administracion> admins = adminDao.listar();
                        if (admins.isEmpty()) {
                            System.out.println(YELLOW + "No hay administraciones registradas." + RESET);
                        } else {
                            admins.forEach(a -> System.out.println("► " + a));
                        }
                        
                        System.out.println(CYAN + "\n╔═══════════════════════════════════════════════╗" + RESET);
                        System.out.println(CYAN + "║" + BOLD + "                   OPCIONES                   " + RESET + CYAN + "║" + RESET);
                        System.out.println(CYAN + "╠═══════════════════════════════════════════════╣" + RESET);
                        System.out.println(CYAN + "║" + RESET + "  1. Volver al menú principal                 " + CYAN + "║" + RESET);
                        System.out.println(CYAN + "║" + RESET + "  2. Reiniciar índice (ID) de administraciones" + CYAN + "║" + RESET);
                        System.out.println(CYAN + "║" + RESET + "  3. Eliminar TODOS los registros             " + CYAN + "║" + RESET);
                        System.out.println(CYAN + "╚═══════════════════════════════════════════════╝" + RESET);
                        System.out.print(RED + "Seleccione una opción: " + RESET);
                        
                        subop = sc.nextInt();
                        sc.nextLine();
                        
                        switch (subop) {
                            case 1 -> {
                                // Volver al menú principal
                            }
                            case 2 -> {
                                if (adminDao.contar() == 0) {
                                    adminDao.reiniciarSecuencia();
                                    System.out.println(GREEN + "\n✔ Secuencia reiniciada correctamente (ID vuelve a 1)" + RESET);
                                } else {
                                    System.out.println(RED + "\n✖ No se puede reiniciar: aún hay administraciones registradas" + RESET);
                                }
                                pausar(sc);
                            }
                            case 3 -> {
                                System.out.println(RED + "\n⚠ ADVERTENCIA: Esto borrará absolutamente TODAS las administraciones." + RESET);
                                System.out.print(YELLOW + "¿Está seguro? (s/n): " + RESET);
                                String confirmar = sc.nextLine();
                                
                                if (confirmar.equalsIgnoreCase("s")) {
                                    adminDao.eliminarTodos();
                                    System.out.println(GREEN + "\n✔ Todos los registros han sido eliminados" + RESET);
                                } else {
                                    System.out.println(YELLOW + "\nOperación cancelada" + RESET);
                                }
                                pausar(sc);
                            }
                            default -> {
                                System.out.println(RED + "\n✖ Opción inválida" + RESET);
                                pausar(sc);
                            }
                        }
                    } while (subop != 1);
                }

                case 7 -> {
                    limpiarPantalla();
                    System.out.println(GREEN + "╔═══════════════════════════════════════════════╗" + RESET);
                    System.out.println(GREEN + "║" + BOLD + "          BUSCAR PACIENTE POR CÉDULA          " + RESET + GREEN + "║" + RESET);
                    System.out.println(GREEN + "╚═══════════════════════════════════════════════╝" + RESET);
                    System.out.print(YELLOW + "\nIngrese la cédula del paciente: " + RESET);
                    
                    if (!sc.hasNextInt()) {
                        System.out.println(RED + "\n✖ Cédula inválida. Debe ser un número." + RESET);
                        sc.next();
                        pausar(sc);
                        continue;
                    }
                    
                    int cedula = sc.nextInt();
                    sc.nextLine();
                    
                    Paciente paciente = pacienteDao.obtenerPorId(cedula);
                    
                    if (paciente != null) {
                        System.out.println(GREEN + "\n✔ Paciente encontrado:" + RESET);
                        System.out.println(CYAN + "╔═══════════════════════════════════════════════╗" + RESET);
                        System.out.println(CYAN + "║" + BOLD + "            INFORMACIÓN DEL PACIENTE          " + RESET + CYAN + "║" + RESET);
                        System.out.println(CYAN + "╠═══════════════════════════════════════════════╣" + RESET);
                        System.out.println(CYAN + "║" + RESET + " Cédula:         " + String.format("%-29s", paciente.getId()) + CYAN + "║" + RESET);
                        System.out.println(CYAN + "║" + RESET + " Nombre:         " + String.format("%-29s", paciente.getNombre()) + CYAN + "║" + RESET);
                        System.out.println(CYAN + "║" + RESET + " Edad:           " + String.format("%-29s", paciente.getEdad() + " años") + CYAN + "║" + RESET);
                        System.out.println(CYAN + "║" + RESET + " Sexo:           " + String.format("%-29s", paciente.getSexo()) + CYAN + "║" + RESET);
                        System.out.println(CYAN + "║" + RESET + " Tipo de sangre: " + String.format("%-29s", paciente.getTipoSangre()) + CYAN + "║" + RESET);
                        System.out.println(CYAN + "║" + RESET + " Alergias:       " + String.format("%-29s", paciente.getAlergias()) + CYAN + "║" + RESET);
                        System.out.println(CYAN + "║" + RESET + " Diagnóstico:    " + String.format("%-29s", paciente.getDiagnostico()) + CYAN + "║" + RESET);
                        System.out.println(CYAN + "╚═══════════════════════════════════════════════╝" + RESET);
                        
                        // Mostrar medicamentos administrados a este paciente
                        List<Administracion> administraciones = adminDao.obtenerPorPaciente(cedula);
                        
                        if (!administraciones.isEmpty()) {
                            System.out.println(PURPLE + "\n╔═══════════════════════════════════════════════╗" + RESET);
                            System.out.println(PURPLE + "║" + BOLD + "           MEDICAMENTOS ADMINISTRADOS         " + RESET + PURPLE + "║" + RESET);
                            System.out.println(PURPLE + "╚═══════════════════════════════════════════════╝" + RESET);
                            for (Administracion admin : administraciones) {
                                Medicamento med = medicamentoDao.obtenerPorId(admin.getMedicamentoId());
                                if (med != null) {
                                    System.out.println("► " + med.getNombre());
                                    System.out.println("  Dosis: " + admin.getDosis() + " mg");
                                    System.out.println("  Frecuencia: " + admin.getFrecuencia());
                                    System.out.println("  Fecha: " + admin.getFecha());
                                    System.out.println();
                                }
                            }
                        } else {
                            System.out.println(YELLOW + "\nEste paciente no tiene medicamentos administrados." + RESET);
                        }
                    } else {
                        System.out.println(RED + "\n✖ No se encontró ningún paciente con la cédula: " + cedula + RESET);
                    }
                    
                    pausar(sc);
                }

                case 8 -> {
                    limpiarPantalla();
                    System.out.println(RED + "╔═══════════════════════════════════════════════╗" + RESET);
                    System.out.println(RED + "║" + BOLD + "               ELIMINAR PACIENTE              " + RESET + RED + "║" + RESET);
                    System.out.println(RED + "╚═══════════════════════════════════════════════╝" + RESET);
                    System.out.print(YELLOW + "\nIngrese ID del paciente: " + RESET);
                    
                    if (!sc.hasNextInt()) {
                        System.out.println(RED + "\n✖ ID inválido" + RESET);
                        sc.next();
                        pausar(sc);
                        continue;
                    }
                    
                    int id = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print(RED + "¿Está seguro de eliminar este paciente? (s/n): " + RESET);
                    String confirmar = sc.nextLine();
                    
                    if (confirmar.equalsIgnoreCase("s")) {
                        adminDao.eliminarPorPaciente(id);
                        pacienteDao.eliminar(id);
                        System.out.println(GREEN + "\n✔ Paciente eliminado exitosamente" + RESET);
                    } else {
                        System.out.println(YELLOW + "\nOperación cancelada" + RESET);
                    }
                    
                    pausar(sc);
                }

                case 9 -> {
                    limpiarPantalla();
                    System.out.println(RED + "╔═══════════════════════════════════════════════╗" + RESET);
                    System.out.println(RED + "║" + BOLD + "             ELIMINAR MEDICAMENTO             " + RESET + RED + "║" + RESET);
                    System.out.println(RED + "╚═══════════════════════════════════════════════╝" + RESET);
                    System.out.print(YELLOW + "\nIngrese ID del medicamento: " + RESET);
                    
                    if (!sc.hasNextInt()) {
                        System.out.println(RED + "\n✖ ID inválido" + RESET);
                        sc.next();
                        pausar(sc);
                        continue;
                    }
                    
                    int id = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print(RED + "¿Está seguro de eliminar este medicamento? (s/n): " + RESET);
                    String confirmar = sc.nextLine();
                    
                    if (confirmar.equalsIgnoreCase("s")) {
                        adminDao.eliminarPorMedicamento(id);
                        medicamentoDao.eliminar(id);
                        System.out.println(GREEN + "\n✔ Medicamento eliminado exitosamente" + RESET);
                    } else {
                        System.out.println(YELLOW + "\nOperación cancelada" + RESET);
                    }
                    
                    pausar(sc);
                }

                case 10 -> {
                    limpiarPantalla();
                    System.out.println(CYAN + "╔═══════════════════════════════════════════════╗" + RESET);
                    System.out.println(CYAN + "║" + BOLD + "   GRACIAS POR USAR EL SISTEMA HOSPITALARIO   " + RESET + CYAN + "║" + RESET);
                    System.out.println(CYAN + "╚═══════════════════════════════════════════════╝" + RESET);
                    System.out.println(GREEN + "\n✔ Cerrando el sistema...\n" + RESET);
                }

                default -> {
                    System.out.println(RED + "\n✖ Opción inválida. Intente nuevamente." + RESET);
                    pausar(sc);
                }
            }

        } while (opcion != 10);
        
        sc.close();
    }
    
    // Método para mostrar el menú principal
    private static void mostrarMenu() {
        System.out.println(BLUE + "╔═══════════════════════════════════════════════╗" + RESET);
        System.out.println(BLUE + "║" + BOLD + GREEN + "          SISTEMA HOSPITALARIO                " + RESET + BLUE + "║" + RESET);
        System.out.println(BLUE + "╠═══════════════════════════════════════════════╣" + RESET);
        System.out.println(BLUE + "║" + RESET + CYAN + "  [1]" + RESET + " Registrar paciente                       " + BLUE + "║" + RESET);
        System.out.println(BLUE + "║" + RESET + CYAN + "  [2]" + RESET + " Registrar medicamento                    " + BLUE + "║" + RESET);
        System.out.println(BLUE + "║" + RESET + CYAN + "  [3]" + RESET + " Administrar medicamento a paciente       " + BLUE + "║" + RESET);
        System.out.println(BLUE + "║" + RESET + CYAN + "  [4]" + RESET + " Ver pacientes                            " + BLUE + "║" + RESET);
        System.out.println(BLUE + "║" + RESET + CYAN + "  [5]" + RESET + " Ver medicamentos                         " + BLUE + "║" + RESET);
        System.out.println(BLUE + "║" + RESET + CYAN + "  [6]" + RESET + " Ver administraciones                     " + BLUE + "║" + RESET);
        System.out.println(BLUE + "║" + RESET + CYAN + "  [7]" + RESET + " Buscar paciente por cédula               " + BLUE + "║" + RESET);
        System.out.println(BLUE + "║" + RESET + CYAN + "  [8]" + RESET + " Eliminar paciente                        " + BLUE + "║" + RESET);
        System.out.println(BLUE + "║" + RESET + CYAN + "  [9]" + RESET + " Eliminar medicamento                     " + BLUE + "║" + RESET);
        System.out.println(BLUE + "║" + RESET + RED + " [10]" + RESET + " Salir                                    " + BLUE + "║" + RESET);
        System.out.println(BLUE + "╚═══════════════════════════════════════════════╝" + RESET);
    }
    
    // Método para limpiar la pantalla
    private static void limpiarPantalla() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Si falla, imprime líneas en blanco
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
    
    // Método para pausar y esperar ENTER
    private static void pausar(Scanner sc) {
        System.out.print(RED + "\nPresione ENTER para continuar..." + RESET);
        sc.nextLine();
    }
}