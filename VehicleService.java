package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Vehicle;
import com.cg.repository.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;

	public String addVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
		return "Vehicle Added Successfully";
	}
	
	public Vehicle updateVehicle(int vId, String type) {
		
		Vehicle vehicle = vehicleRepository.findById(vId).get();
		vehicle.setType(type);
		return vehicle;
	}
	
	public List<Vehicle> deleteVehicle(int vId){
		
		vehicleRepository.deleteById(vId);
		return vehicleRepository.findAll();
	}
}
