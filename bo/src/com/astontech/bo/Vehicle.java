package com.astontech.bo;

import java.util.Date;

/**
 * Created by Carlos Zubiran on 5/9/2016.
 */
public class Vehicle extends BaseBO{

    private int VehicleId;
    private int Year;
    private String LicensePLate;
    private int VIN;
    private String Color;
    private boolean IsPurchase;
    private int PurchasePrice;
    private Date PurchaseDate;
    private int VehicleModelId;

    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getLicensePLate() {
        return LicensePLate;
    }

    public void setLicensePLate(String licensePLate) {
        LicensePLate = licensePLate;
    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public boolean isPurchase() {
        return IsPurchase;
    }

    public void setPurchase(boolean purchase) {
        IsPurchase = purchase;
    }

    public int getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public Date getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    public int getVehicleModelId() {
        return VehicleModelId;
    }

    public void setVehicleModelId(int vehicleModelId) {
        VehicleModelId = vehicleModelId;
    }
}
