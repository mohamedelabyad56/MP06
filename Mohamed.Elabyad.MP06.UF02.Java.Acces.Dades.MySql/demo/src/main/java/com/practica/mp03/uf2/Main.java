package com.practica.mp03.uf2;

public class Main {
    public static void main(String[] args) {
        VehicleDAO vehicleDAO = new VehicleDAO();

  
        vehicleDAO.addVehicle("Toyota", "Corolla", 400);

    
        vehicleDAO.getVehicles();

        vehicleDAO.updateVehicle(1, "Honda", "Civic", 450);

        
        vehicleDAO.deleteVehicle(1);
    }
}
