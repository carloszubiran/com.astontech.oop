package com.astontech.bo;

/**
 * Created by Carlos Zubiran on 5/9/2016.
 */
public class BaseBO {

    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String test_method() {
        return "super method";
    }

}
