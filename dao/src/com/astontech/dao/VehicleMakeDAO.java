package com.astontech.dao;

import com.astontech.bo.VehicleMake;

import java.util.List;

/**
 * Created by Carlos Zubiran on 5/13/2016.
 */
public interface VehicleMakeDAO {

    //notes:    GET Methods

    public VehicleMake getVehicleMakeById(int vehicleMakeId);
    public List<VehicleMake> getVehicleMakeList();

    //notes:    Execute Methods

    public int insertVehicleMake(VehicleMake vehicleMake);
    public boolean updateVehicleMake(VehicleMake vehicleMake);
    public boolean deleteVehicleMake(int vehicleMakeId);



}
