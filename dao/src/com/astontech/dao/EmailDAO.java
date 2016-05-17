package com.astontech.dao;

import com.astontech.bo.Email;

import java.util.List;

/**
 * Created by Carlos Zubiran on 5/13/2016.
 */
public interface EmailDAO {

    //notes:    GET Methods

    public Email getEmailById(int emailId);
    public List<Email> getEmailList();

    //notes:    Execute Methods

    public int insertEmail(Email email);
    public boolean updateEmail(Email email);
    public boolean deleteEmail(int emailId);



}
