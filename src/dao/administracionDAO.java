package dao;

import model.Administracion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class administracionDAO {

    private conexion conexion;

    public administracionDAO() {
        this.conexion = new conexion();
    }

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

    // OBTENER POR PACIENTE
    public List<Administracion> obtenerPorPaciente(int pacienteId) {
        List<Administracion> lista = new ArrayList<>();
        String sql = "SELECT * FROM administracion WHERE paciente_id = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pacienteId);
            ResultSet rs = stmt.executeQuery();

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
            System.out.println("Error al obtener administraciones por paciente");
            e.printStackTrace();
        }

        return lista;
    }

    // ELIMINAR
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
}
