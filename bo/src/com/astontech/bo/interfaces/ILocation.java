package com.astontech.bo.interfaces;

/**
 * Created by Carlos Zubiran on 5/11/2016.
 */
public interface ILocation {

    public final double PI = 3.14;

    public int numberOfWorkspaces();

    public boolean canHaveMeetings();

    public String getLocationName();

    public boolean hasCoffee();

}
