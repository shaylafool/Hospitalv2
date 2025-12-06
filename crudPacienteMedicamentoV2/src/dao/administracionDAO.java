package dao;

import model.Administracion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class administracionDAO {

    // INSERTAR ADMINISTRACIÓN
    public void insertar(Administracion a) {
        String sql = "INSERT INTO administracion (paciente_id, medicamento_id, fecha, frecuencia, dosis) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, a.getPacienteId());
            stmt.setInt(2, a.getMedicamentoId());
            stmt.setDate(3, java.sql.Date.valueOf(a.getFecha()));
            stmt.setString(4, a.getFrecuencia());
            stmt.setInt(5, a.getDosis());

            stmt.executeUpdate();
            System.out.println("Administración insertada correctamente");

        } catch (SQLException e) {
            System.out.println("Error al insertar administración");
            e.printStackTrace();
        }
    }

    // OBTENER TODAS
    public List<Administracion> listar() {
        List<Administracion> lista = new ArrayList<>();
        String sql = "SELECT * FROM administracion";

        try (Connection conn = conexion.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Administracion a = new Administracion(
                    rs.getInt("id"),
                    rs.getInt("paciente_id"),
                    rs.getInt("medicamento_id"),
                    rs.getDate("fecha").toLocalDate(),
                    rs.getString("frecuencia"),
                    rs.getInt("dosis")
                );
                lista.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener administraciones");
            e.printStackTrace();
        }

        return lista;
    }

    // OBTENER POR PACIENTE - MÉTODO CORREGIDO
    public List<Administracion> obtenerPorPaciente(int pacienteId) {
        List<Administracion> lista = new ArrayList<>();
        String sql = "SELECT * FROM administracion WHERE paciente_id = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pacienteId);  // Primero establece el parámetro
            ResultSet rs = stmt.executeQuery();  // Luego ejecuta la query

            while (rs.next()) {
                Administracion a = new Administracion(
                    rs.getInt("id"),
                    rs.getInt("paciente_id"),
                    rs.getInt("medicamento_id"),
                    rs.getDate("fecha").toLocalDate(),
                    rs.getString("frecuencia"),
                    rs.getInt("dosis")
                );
                lista.add(a);
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error al obtener administraciones por paciente");
            e.printStackTrace();
        }

        return lista;
    }

    // ELIMINAR POR ID
    public void eliminar(int id) {
        String sql = "DELETE FROM administracion WHERE id = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Administración eliminada correctamente");

        } catch (SQLException e) {
            System.out.println("Error al eliminar administración");
            e.printStackTrace();
        }
    }

    // ELIMINAR POR PACIENTE
    public void eliminarPorPaciente(int pacienteId) {
        String sql = "DELETE FROM administracion WHERE paciente_id = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pacienteId);
            stmt.executeUpdate();
            System.out.println("Administraciones del paciente eliminadas correctamente");

        } catch (SQLException e) {
            System.out.println("Error al eliminar administraciones del paciente");
            e.printStackTrace();
        }
    }

    // ELIMINAR POR MEDICAMENTO
    public void eliminarPorMedicamento(int medicamentoId) {
        String sql = "DELETE FROM administracion WHERE medicamento_id = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, medicamentoId);
            stmt.executeUpdate();
            System.out.println("Administraciones del medicamento eliminadas correctamente");

        } catch (SQLException e) {
            System.out.println("Error al eliminar administraciones del medicamento");
            e.printStackTrace();
        }
    }

    // CONTAR REGISTROS
    public int contar() {
        String sql = "SELECT COUNT(*) AS total FROM administracion";

        try (Connection conn = conexion.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            System.out.println("Error al contar administraciones");
            e.printStackTrace();
        }

        return 0;
    }

    // REINICIAR SECUENCIA
    public void reiniciarSecuencia() {
        String sql = "ALTER SEQUENCE administracion_id_seq RESTART WITH 1";

        try (Connection conn = conexion.obtenerConexion();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("Secuencia reiniciada correctamente");

        } catch (SQLException e) {
            System.out.println("Error al reiniciar secuencia");
            e.printStackTrace();
        }
    }

    // ELIMINAR TODOS LOS REGISTROS
    public void eliminarTodos() {
        String sql = "DELETE FROM administracion";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.executeUpdate();
            System.out.println("Todos los registros de administración fueron eliminados.");

        } catch (SQLException e) {
            System.out.println("Error al eliminar todos los registros de administración");
            e.printStackTrace();
        }
    }
}