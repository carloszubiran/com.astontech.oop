package com.astontech.bo;

/**
 * Created by Carlos Zubiran on 5/9/2016.
 */
public class VehicleModel extends BaseBO{

    private String VehicleModelName;
    private int VehicleMakeId;

    public String getVehicleModelName() {
        return VehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        VehicleModelName = vehicleModelName;
    }

    public int getVehicleMakeId() {
        return VehicleMakeId;
    }

    public void setVehicleMakeId(int vehicleMakeId) {
        VehicleMakeId = vehicleMakeId;
    }
}
