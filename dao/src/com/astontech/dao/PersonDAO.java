package com.astontech.dao;

import com.astontech.bo.Person;

import java.util.List;

/**
 * Created by Carlos Zubiran on 5/13/2016.
 */
public interface PersonDAO {

    //notes:    GET Methods

    public Person getPersonById(int personId);
    public List<Person> getPersonList();

    //notes:    Execute Methods

    public int insertPerson(Person person);
    public boolean updatePerson(Person person);
    public boolean deletePerson(int personId);



}
