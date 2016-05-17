package com.astontech.dao.mysql;

import com.astontech.bo.Person;
import com.astontech.dao.PersonDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Zubiran on 5/13/2016.
 */
public class PersonDAOImpl extends MySQL implements PersonDAO {

    //region PROPERTIES


    //endregion PROPERTIES

    //region CONSTRUCTORS


    //endregion CONSTRUCTORS

    //region GETTERS / SETTERS


    //endregion GETTERS / SETTERS

    //region CUSTOM METHODS

    @Override
    public Person getPersonById(int personId) {
        Connect();
        Person person = null;   //not instantiated because if no records returned we don't want to use memory.
        try {
            String sp = "{call usp_GetPerson(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, personId);
            ResultSet rs = cStmt.executeQuery();

            if (rs.next()) {
                person = HydrateObject(rs);
            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return person;

    }

    @Override
    public List<Person> getPersonList() {
        Connect();
            List<Person> personList = new ArrayList<Person>();
        try {
            String sp = "{call usp_GetPerson(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2,0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {

                personList.add(HydrateObject(rs));
            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return personList;

    }

    @Override
    public int insertPerson(Person person) {

        Connect();
        int id = 0;

        //region index values

        /*
     	 IN QueryId int(11),                Index 1
         IN vPersonId int(11),              Index 2
         IN Title varchar(5),               Index 3
         IN FirstName varchar(50),          Index 4
         IN MiddleName varchar(50),         Index 5
         IN LastName varchar(50),           Index 6
         IN DisplayFirstName varchar(50),   Index 7
         IN Gender char(1),                 Index 8
         IN BirthDate DateTime,             Index 9
         IN SSN varchar(45)                 Index 10
        * */

        //endregion

        // call usp_ExecPerson(10, personId, Title, FirstName, MiddleName, LastName, DisplayFirstName,
        // Gender, BirthDate, SSN)


        try {
            String sp = "{call usp_ExecutePerson(?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setString(3, person.getTitle());
            cStmt.setString(4, person.getFirstName());
            cStmt.setString(5, person.getMiddleName());
            cStmt.setString(6, person.getLastName());
            cStmt.setString(7, person.getDisplayFirstName());
            cStmt.setString(8, person.getGender());
            cStmt.setDate(9, DateHelper.utilDateToSqlDate(person.getBirthDate()));
            cStmt.setString(10, person.getSSN());

            ResultSet rs = cStmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return id;
    }

    @Override
    public boolean updatePerson(Person person) {
        Connect();
        int id = 0;

        //region index values

        /*
     	 IN QueryId int(11),                Index 1
         IN vPersonId int(11),              Index 2
         IN Title varchar(5),               Index 3
         IN FirstName varchar(50),          Index 4
         IN MiddleName varchar(50),         Index 5
         IN LastName varchar(50),           Index 6
         IN DisplayFirstName varchar(50),   Index 7
         IN Gender char(1),                 Index 8
         IN BirthDate DateTime,             Index 9
         IN SSN varchar(45)                 Index 10
        * */

        //endregion

        // call usp_ExecPerson(10, personId, Title, FirstName, MiddleName, LastName, DisplayFirstName,
        // Gender, BirthDate, SSN)


        try {
            String sp = "{call usp_ExecutePerson(?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, UPDATE);                            // Changed from insert method
            cStmt.setInt(2, person.getPersonId());              // Changed from insert method
            cStmt.setString(3, person.getTitle());
            cStmt.setString(4, person.getFirstName());
            cStmt.setString(5, person.getMiddleName());
            cStmt.setString(6, person.getLastName());
            cStmt.setString(7, person.getDisplayFirstName());
            cStmt.setString(8, person.getGender());
            cStmt.setDate(9, DateHelper.utilDateToSqlDate(person.getBirthDate()));
            cStmt.setString(10, person.getSSN());

            ResultSet rs = cStmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return id > 0;
    }

    @Override
    public boolean deletePerson(int personId) {
        Connect();
        int id = 0;

        //region index values

        /*
     	 IN QueryId int(11),                Index 1
         IN vPersonId int(11),              Index 2
         IN Title varchar(5),               Index 3
         IN FirstName varchar(50),          Index 4
         IN MiddleName varchar(50),         Index 5
         IN LastName varchar(50),           Index 6
         IN DisplayFirstName varchar(50),   Index 7
         IN Gender char(1),                 Index 8
         IN BirthDate DateTime,             Index 9
         IN SSN varchar(45)                 Index 10
        * */

        //endregion

        // call usp_ExecPerson(10, personId, Title, FirstName, MiddleName, LastName, DisplayFirstName,
        // Gender, BirthDate, SSN)


        try {
            String sp = "{call usp_ExecutePerson(?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, personId);
            cStmt.setString(3, "");
            cStmt.setString(4, "");
            cStmt.setString(5, "");
            cStmt.setString(6, "");
            cStmt.setString(7, "");
            cStmt.setString(8, "");
            cStmt.setDate(9, new java.sql.Date(0));
            cStmt.setString(10, "");

            ResultSet rs = cStmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return id > 0;    }

    private static Person HydrateObject(ResultSet rs) throws SQLException{
        /*
           a.PersonId,         index 1 INT
           a.Title,            index 2 VARCHAR
           a.FirstName,        index 3 VARCHAR
           a.MiddleName        index 4 VARCHAR
           a.LastName,         index 5 VARCHAR
           a.CreateDate,       index 6 VARCHAR
           a.DisplayFirstName, index 7 VARCHAR
           a.IsDeleted,        index 8 DATETIME
           a.Gender,           index 9 VARCHAR
           a.BirthDate,        index 10 DATETIME
           a.SSN               index 11 VARCHAR
        */
        //notes:    HYDRATING AN OBJECT
        Person person = new Person();

        person.setPersonId(rs.getInt(1));
        person.setTitle(rs.getString(2));
        person.setFirstName(rs.getString(3));
        person.setMiddleName(rs.getString(4));
        person.setLastName(rs.getString(5));
        person.setCreateDate(rs.getDate(6));
        person.setDisplayFirstName(rs.getString(7));
        person.setDeleted(rs.getBoolean(8));
        person.setGender(rs.getString(9));
        person.setBirthDate(rs.getDate(10));
        person.setSSN(rs.getString(11));

        return person;

    }

    //endregion CUSTOM METHODS

}
