package com.astontech.dao;

import com.astontech.bo.Vehicle;

import java.util.List;

/**
 * Created by Carlos Zubiran on 5/13/2016.
 */
public interface VehicleDAO {

    //notes:    GET Methods

    public Vehicle getVehicleById(int vehicleId);
    public List<Vehicle> getVehicleList();

    //notes:    Execute Methods

    public int insertVehicle(Vehicle vehicle);
    public boolean updateVehicle(Vehicle vehicle);
    public boolean deleteVehicle(int vehicleId);



}
