package com.astontech.dao;

import com.astontech.bo.VehicleModel;

import java.util.List;

/**
 * Created by Carlos Zubiran on 5/13/2016.
 */
public interface VehicleModelDAO {

    //notes:    GET Methods

    public VehicleModel getVehicleModelById(int vehicleModelId);
    public List<VehicleModel> getVehicleModelList();

    //notes:    Execute Methods

    public int insertVehicleModel(VehicleModel vehicleModel);
    public boolean updateVehicleModel(VehicleModel vehicleModel);
    public boolean deleteVehicleModel(int vehicleModelId);



}
