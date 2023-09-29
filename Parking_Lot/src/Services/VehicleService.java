package Services;

import Repositories.VehicleRepository;
import models.Vehicle;
import models.VehicleType;

import java.util.HashMap;

public class VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle getVehicle(String number){
        return this.vehicleRepository.getVehicle(number);
    }

    public Vehicle registerVehicle(String number, VehicleType vehicleType){
        return vehicleRepository.putVehicle(new Vehicle(number,vehicleType));

    }
}
