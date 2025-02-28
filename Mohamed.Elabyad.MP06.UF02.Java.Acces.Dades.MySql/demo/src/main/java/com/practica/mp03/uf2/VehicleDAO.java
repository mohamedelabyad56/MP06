package com.practica.mp03.uf2;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VehicleDAO {

    public void addVehicle(String marca, String model, int capacitatMaleter) {
        String sql = "INSERT INTO vehicles (Marca, Model, CapacitatMaleter) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, marca);
            stmt.setString(2, model);
            stmt.setInt(3, capacitatMaleter);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("¡Vehículo añadido correctamente!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getVehicles() {
        String sql = "SELECT * FROM vehicles";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("Id") +
                        ", Marca: " + rs.getString("Marca") +
                        ", Model: " + rs.getString("Model") +
                        ", Capacitat Maleter: " + rs.getInt("CapacitatMaleter"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateVehicle(int id, String marca, String model, int capacitatMaleter) {
        String sql = "UPDATE vehicles SET Marca = ?, Model = ?, CapacitatMaleter = ? WHERE Id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, marca);
            stmt.setString(2, model);
            stmt.setInt(3, capacitatMaleter);
            stmt.setInt(4, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Vehículo actualizado correctamente!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVehicle(int id) {
        String sql = "DELETE FROM vehicles WHERE Id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Vehículo eliminado correctamente!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
