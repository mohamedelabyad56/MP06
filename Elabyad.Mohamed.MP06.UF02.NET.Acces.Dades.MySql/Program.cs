using System;

class Program
{
    static void Main()
    {
        // Configura la connexió (actualitza amb les teves credencials)
        var connectionString = "Server=localhost;Database=MP06_UF02_AEA1;User=root;Password=root;";
        var repo = new VehicleRepository(connectionString);

        // Part 1: Simulació CRUD amb dades literals (5 punts)
        Console.WriteLine("=== Simulació amb dades literals ===");
        repo.Create("Toyota", "Corolla", 500); // Create
        Console.WriteLine("Vehicle creat.");

        var vehicles = repo.ReadAll(); // Read
        Console.WriteLine("\nLlista de vehicles:");
        foreach (var v in vehicles)
            Console.WriteLine($"{v.Id} | {v.Marca} {v.Model} ({v.CapacitatMaleter}L)");

        repo.Update(1, "Toyota", "Camry", 600); // Update
        Console.WriteLine("\nVehicle actualitzat.");

        repo.Delete(1); // Delete
        Console.WriteLine("Vehicle eliminat.");

        // Part 2: Demanar dades per consola (2 punts)
        Console.WriteLine("\n=== Mode interactiu ===");
        while (true)
        {
            Console.WriteLine("\nOperacions: [C]rear, [L]listar, [A]ctualitzar, [E]liminar, [S]ortir");
            var opcio = Console.ReadLine()?.ToUpper();

            switch (opcio)
            {
                case "C":
                    Console.Write("Marca: ");
                    var marca = Console.ReadLine();
                    Console.Write("Model: ");
                    var model = Console.ReadLine();
                    Console.Write("Capacitat del maleter (L): ");
                    int capacitat = int.Parse(Console.ReadLine());
                    repo.Create(marca, model, capacitat);
                    break;

                case "L":
                    foreach (var v in repo.ReadAll())
                        Console.WriteLine($"{v.Id} | {v.Marca} {v.Model} ({v.CapacitatMaleter}L)");
                    break;

                case "A":
                    Console.Write("ID del vehicle a actualitzar: ");
                    int idUpdate = int.Parse(Console.ReadLine());
                    Console.Write("Nova marca: ");
                    var novaMarca = Console.ReadLine();
                    Console.Write("Nou model: ");
                    var nouModel = Console.ReadLine();
                    Console.Write("Nova capacitat: ");
                    int novaCapacitat = int.Parse(Console.ReadLine());
                    repo.Update(idUpdate, novaMarca, nouModel, novaCapacitat);
                    break;

                case "E":
                    Console.Write("ID del vehicle a eliminar: ");
                    int idDelete = int.Parse(Console.ReadLine());
                    repo.Delete(idDelete);
                    break;

                case "S":
                    return;

                default:
                    Console.WriteLine("Opció no vàlida.");
                    break;
            }
        }
    }
}