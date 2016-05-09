package com.astontech.bo;

import java.util.Date;

/**
 * Created by Carlos Zubiran on 5/9/2016.
 */
public class VehicleMake {

    private int VeicleMakeId;
    private String VehicleMakeName;
    private Date CreateDate;

    public int getVechivleMakeId() {
        return VeicleMakeId;
    }

    public void setVeicleMakeId(int vechivleMakeId) {
        VeicleMakeId = vechivleMakeId;
    }

    public String getVehicleMakeName() {
        return VehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        VehicleMakeName = vehicleMakeName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
