package Repositories;

import models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    private Map<String, Vehicle> vehicleStore;

    public VehicleRepository(HashMap<String, Vehicle> vehicleStore) {
        this.vehicleStore = vehicleStore;
    }

    public Vehicle getVehicle(String number) {
        return vehicleStore.get(number);
    }

    public Vehicle putVehicle(Vehicle vehicle) {
        vehicleStore.put(vehicle.getNumber(),vehicle);
        return vehicle;


    }
}
