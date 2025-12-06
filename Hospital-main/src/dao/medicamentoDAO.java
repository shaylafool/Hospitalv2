package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Medicamento;

public class medicamentoDAO {

    // INSERT
    public void insertar(Medicamento m) {
        String sql = "INSERT INTO medicamentos (nombre, miligramos, presentacion) VALUES (?, ?, ?)";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getNombre());
            stmt.setInt(2, m.getMiligramos());
            stmt.setString(3, m.getPresentacion());
            stmt.executeUpdate();

            System.out.println("✔ Medicamento insertado correctamente");

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar medicamento");
            e.printStackTrace();
        }
    }

    // SELECT - listar todos
    public List<Medicamento> listar() {
        List<Medicamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM medicamentos";

        try (Connection conn = conexion.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Medicamento m = new Medicamento(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("miligramos"),
                    rs.getString("presentacion")
                );
                lista.add(m);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar medicamentos");
            e.printStackTrace();
        }

        return lista;
    }

    // SELECT - por ID
    public Medicamento obtenerPorId(int id) {
        String sql = "SELECT * FROM medicamentos WHERE id = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Medicamento(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("miligramos"),
                    rs.getString("presentacion")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener medicamento por ID");
            e.printStackTrace();
        }
        return null;
    }

    // UPDATE
    public void actualizar(Medicamento m) {
        String sql = "UPDATE medicamentos SET nombre = ?, miligramos = ?, presentacion = ? WHERE id = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.getNombre());
            stmt.setInt(2, m.getMiligramos());
            stmt.setString(3, m.getPresentacion());
            stmt.setInt(4, m.getId());
            stmt.executeUpdate();

            System.out.println("Medicamento actualizado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al actualizar medicamento");
            e.printStackTrace();
        }
    }

    // DELETE
    public void eliminar(int id) {
        String sql = "DELETE FROM medicamentos WHERE id = ?";

        try (Connection conn = conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Medicamento eliminado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al eliminar medicamento");
            e.printStackTrace();
        }
    }
}
