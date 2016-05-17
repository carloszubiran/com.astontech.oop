package com.astontech.bo.interfaces;

import com.astontech.bo.Employee;

/**
 * Created by Carlos Zubiran on 5/11/2016.
 */
public class Home implements ILocation {

    //region PROPERTIES

    private String Address;
    private Employee Owner;

    //endregion PROPERTIES

    //region CONSTRUCTORS


    //endregion CONSTRUCTORS

    //region GETTERS / SETTERS

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Employee getOwner() {
        return Owner;
    }

    public void setOwner(Employee owner) {
        Owner = owner;
    }


    //endregion GETTERS / SETTERS

    //region CUSTOM METHODS

    @Override
    public int numberOfWorkspaces() {
        return 1;
    }

    @Override
    public boolean canHaveMeetings() {
        return false;
    }

    @Override
    public String getLocationName() {
        return this.Owner.getFirstName() + "'s Home";
    }

    @Override
    public boolean hasCoffee() {
        return true;
    }


    //endregion CUSTOM METHODS


}
