package finalproject.cashtracking.rcts.services;

import finalproject.cashtracking.rcts.entities.Truck;
import finalproject.cashtracking.rcts.exceptions.TruckNotFoundException;
import finalproject.cashtracking.rcts.repositories.CashBoxRepository;
import finalproject.cashtracking.rcts.repositories.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TruckService {

    @Autowired
    TruckRepository truckRepository;
    @Autowired
    CashBoxRepository cashBoxRepository;

    private Truck startRoute(Long id){
        Optional<Truck> optionalTruck = truckRepository.findById(id);
        if(optionalTruck.isPresent()){
            Truck truck = optionalTruck.get();
            truck.setTravel(true);
            return truckRepository.save(truck);
        }else {
            throw new TruckNotFoundException("TruckNotFound");
        }
    }

    private Truck endRoute(Long id){
        Optional<Truck> optionalTruck = truckRepository.findById(id);
        if(optionalTruck.isPresent()){
            Truck truck = optionalTruck.get();
            truck.setTravel(false);
            return truckRepository.save(truck);
        }else {
            throw new TruckNotFoundException("TruckNotFound");
        }
    }

    private Truck setTruckLocation(Long id, double latitude, double longitude) {
        Optional<Truck> optionalTruck = truckRepository.findById(id);
        if (optionalTruck.isPresent()) {
            Truck truck = optionalTruck.get();
            truck.setLatitude(latitude);
            truck.setLongitude(longitude);
            return truckRepository.save(truck);
        } else {
            throw new TruckNotFoundException("TruckNotFound");
        }
    }

}
