package com.astontech.dao;

import com.astontech.bo.Phone;

import java.util.List;

/**
 * Created by Carlos Zubiran on 5/13/2016.
 */
public interface PhoneDAO {

    //notes:    GET Methods

    public Phone getPhoneById(int phoneId);
    public List<Phone> getPhoneList();

    //notes:    Execute Methods

    public int insertPhone(Phone phone);
    public boolean updatePhone(Phone phone);
    public boolean deletePhone(int phoneId);



}
