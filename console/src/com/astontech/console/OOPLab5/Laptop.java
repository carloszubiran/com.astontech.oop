package com.astontech.console.OOPLab5;

/**
 * Created by Carlos Zubiran on 5/12/2016.
 */
public class Laptop implements IComputer {

    //region PROPERTIES
    private double DisplaySize;
    private int DiskSize;
    private int RamSize;
    private boolean SSD = false;
    private boolean Display = false;

    //endregion PROPERTIES

    //region CONSTRUCTORS


    public Laptop() {
    }

    public Laptop(double displaySize, int diskSize, int ramSize, boolean SSD) {
        DisplaySize = displaySize;
        DiskSize = diskSize;
        RamSize = ramSize;
        this.SSD = SSD;
    }


    //endregion CONSTRUCTORS

    //region GETTERS / SETTERS

    public double getDisplaySize() {
        return DisplaySize;
    }

    public void setDisplaySize(double displaySize) {
        DisplaySize = displaySize;
    }

    public int getDiskSize() {
        return DiskSize;
    }

    public void setDiskSize(int diskSize) {
        DiskSize = diskSize;
    }

    public int getRamSize() {
        return RamSize;
    }

    public void setRamSize(int ramSize) {
        RamSize = ramSize;
    }

    public boolean isSSD() {
        return SSD;
    }

    public void setSSD(boolean SSD) {
        this.SSD = SSD;
    }


    //endregion GETTERS / SETTERS

    //region CUSTOM METHODS

    @Override
    public boolean hasSSD() {
        if (SSD) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean hasDisplay() {
        return true;
    }

    //endregion CUSTOM METHODS


}
