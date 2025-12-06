package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Paciente;

public class pacienteDAO {

    // INSERT
    public void insertar(Paciente p) {
        String sql = "INSERT INTO pacientes (nombre, edad, sexo, tipo_sangre, alergias, diagnostico) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNombre());
            stmt.setInt(2, p.getEdad());
            stmt.setString(3, p.getSexo());
            stmt.setString(4, p.getTipoSangre());
            stmt.setString(5, p.getAlergias());
            stmt.setString(6, p.getDiagnostico());
            stmt.executeUpdate();

            System.out.println("Paciente insertado correctamente");

        } catch (SQLException e) {
            System.out.println(" Error al insertar paciente");
            e.printStackTrace();
        }
    }

    // SELECT - listar todos
    public List<Paciente> listar() {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";

        try (Connection conn = conexion.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Paciente p = new Paciente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("sexo"),
                    rs.getString("tipo_sangre"),
                    rs.getString("alergias"),
                    rs.getString("diagnostico")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar pacientes");
            e.printStackTrace();
        }

        return lista;
    }

    // SELECT - obtener por ID
    public Paciente obtenerPorId(int id) {
        String sql = "SELECT * FROM pacientes WHERE id = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Paciente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("sexo"),
                    rs.getString("tipo_sangre"),
                    rs.getString("alergias"),
                    rs.getString("diagnostico")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener paciente por ID");
            e.printStackTrace();
        }

        return null;
    }

    // UPDATE
    public void actualizar(Paciente p) {
        String sql = "UPDATE pacientes SET nombre = ?, edad = ?, sexo = ?, tipo_sangre = ?, alergias = ?, diagnostico = ? WHERE id = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNombre());
            stmt.setInt(2, p.getEdad());
            stmt.setString(3, p.getSexo());
            stmt.setString(4, p.getTipoSangre());
            stmt.setString(5, p.getAlergias());
            stmt.setString(6, p.getDiagnostico());
            stmt.setInt(7, p.getId());
            stmt.executeUpdate();

            System.out.println("Paciente actualizado correctamente");

        } catch (SQLException e) {
            System.out.println(" Error al actualizar paciente");
            e.printStackTrace();
        }
    }

    // DELETE
    public void eliminar(int id) {
        String sql = "DELETE FROM pacientes WHERE id = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Paciente eliminado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al eliminar paciente");
            e.printStackTrace();
        }
    }
}
