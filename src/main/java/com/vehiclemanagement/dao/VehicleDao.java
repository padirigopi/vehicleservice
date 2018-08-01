package com.vehiclemanagement.dao;

import java.util.List;

import com.vehiclemanagement.model.Vehicle;

public interface VehicleDao {

	List<Vehicle> getAllVehicles();
	void saveVehicle(Vehicle vehicle);
	Vehicle getVehicle(String vehicleID);
	void deleteVehicle(String vehicleID);
}
