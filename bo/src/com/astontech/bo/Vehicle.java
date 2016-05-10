package com.astontech.bo;

import javax.swing.plaf.synth.Region;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Carlos Zubiran on 5/9/2016.
 */
public class Vehicle extends BaseBO{

    //region PROPERTIES

    private int VehicleId;
    private int Year;
    private String LicensePlate;
    private String VIN;
    private String Color;
    private boolean IsPurchase;
    private int PurchasePrice;
    private Date PurchaseDate;
    private List<VehicleMake> vehicleMakes;
    private List<VehicleModel> vehicleModels;
    private List<VehicleStatus> vehicleStatuses;

    //endregion PROPERTIES

    //region CONSTRUCTORS

    public Vehicle() {

        vehicleMakes = new ArrayList<>();
        vehicleModels = new ArrayList<>();
        vehicleStatuses = new ArrayList<>();

    }

    public Vehicle(int vehicleId) {
        VehicleId = vehicleId;
    }

    public Vehicle(int vehicleId, int year, String licensePlate,
                   String VIN, String color, boolean isPurchase,
                   int purchasePrice, Date purchaseDate,
                   List<VehicleMake> vehicleMakes,
                   List<VehicleModel> vehicleModels,
                   List<VehicleStatus> vehicleStatuses) {
        VehicleId = vehicleId;
        Year = year;
        LicensePlate = licensePlate;
        this.VIN = VIN;
        Color = color;
        IsPurchase = isPurchase;
        PurchasePrice = purchasePrice;
        PurchaseDate = purchaseDate;
        this.vehicleMakes = vehicleMakes;
        this.vehicleModels = vehicleModels;
        this.vehicleStatuses = vehicleStatuses;
    }

    //endregion

    //region GETTERS / SETTERS

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

    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
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

    public List<VehicleMake> getVehicleMakes() {
        return vehicleMakes;
    }

    public void setVehicleMakes(List<VehicleMake> vehicleMakes) {
        this.vehicleMakes = vehicleMakes;
    }

    public List<VehicleModel> getVehicleModels() {
        return vehicleModels;
    }

    public void setVehicleModels(List<VehicleModel> vehicleModels) {
        this.vehicleModels = vehicleModels;
    }

    public List<VehicleStatus> getVehicleStatuses() {
        return vehicleStatuses;
    }

    public void setVehicleStatuses(List<VehicleStatus> vehicleStatuses) {
        this.vehicleStatuses = vehicleStatuses;
    }

    //endregion GETTERS / SETTERS

    //region CUSTOM / METHODS

    public String getVinColorYearAndLicensePlateOfVehicle() {

        return "Vin: " + getVIN() + ", Color: "
                + getColor() + ", Year: " + getYear() + ", LicensePlate: " + getLicensePlate();

    }

    public String getPurchasePriceAndDate() {

        return "Purchase Price: " + getPurchasePrice() + "Purchase Date: " + getPurchaseDate();

    }

    //endregion







}
