using MySql.Data.MySqlClient;
using System.Collections.Generic;
using MyApp.Models; // Asegúrate de importar el espacio de nombres correcto

public class VehicleRepository
{
    private readonly string _connectionString;

    public VehicleRepository(string connectionString)
    {
        _connectionString = connectionString;
    }

    // Operació CREATE
    public void Create(string marca, string model, int capacitat)
    {
        using (var conn = new MySqlConnection(_connectionString))
        {
            conn.Open();
            var query = @"INSERT INTO vehicles 
                        (Marca, Model, CapacitatMaleter) 
                        VALUES (@marca, @model, @capacitat)";
            
            var cmd = new MySqlCommand(query, conn);
            cmd.Parameters.AddWithValue("@marca", marca);
            cmd.Parameters.AddWithValue("@model", model);
            cmd.Parameters.AddWithValue("@capacitat", capacitat);
            
            cmd.ExecuteNonQuery();
        }
    }

    // Operació READ (tots els registres)
    public List<Vehicle> ReadAll()
    {
        var vehicles = new List<Vehicle>();
        
        using (var conn = new MySqlConnection(_connectionString))
        {
            conn.Open();
            var query = "SELECT * FROM vehicles";
            var cmd = new MySqlCommand(query, conn);
            
            using (var reader = cmd.ExecuteReader())
            {
                while (reader.Read())
                {
                    vehicles.Add(new Vehicle(
                        reader.GetInt32("Id"),
                        reader.GetString("Marca"),
                        reader.GetString("Model"),
                        reader.GetInt32("CapacitatMaleter")
                    ));
                }
            }
        }
        return vehicles;
    }

    // Operació UPDATE
    public void Update(int id, string marca, string model, int capacitat)
    {
        using (var conn = new MySqlConnection(_connectionString))
        {
            conn.Open();
            var query = @"UPDATE vehicles 
                        SET Marca = @marca, 
                            Model = @model, 
                            CapacitatMaleter = @capacitat 
                        WHERE Id = @id";
            
            var cmd = new MySqlCommand(query, conn);
            cmd.Parameters.AddWithValue("@id", id);
            cmd.Parameters.AddWithValue("@marca", marca);
            cmd.Parameters.AddWithValue("@model", model);
            cmd.Parameters.AddWithValue("@capacitat", capacitat);
            
            cmd.ExecuteNonQuery();
        }
    }

    // Operació DELETE
    public void Delete(int id)
    {
        using (var conn = new MySqlConnection(_connectionString))
        {
            conn.Open();
            var query = "DELETE FROM vehicles WHERE Id = @id";
            var cmd = new MySqlCommand(query, conn);
            cmd.Parameters.AddWithValue("@id", id);
            cmd.ExecuteNonQuery();
        }
    }
}
