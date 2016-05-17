package com.astontech.dao.mysql;

import com.astontech.bo.Phone;
import com.astontech.dao.PhoneDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Zubiran on 5/13/2016.
 */
public class PhoneDAOImpl extends MySQL implements PhoneDAO {

    //region PROPERTIES


    //endregion PROPERTIES

    //region CONSTRUCTORS


    //endregion CONSTRUCTORS

    //region GETTERS / SETTERS


    //endregion GETTERS / SETTERS

    //region CUSTOM METHODS

    @Override
    public Phone getPhoneById(int phoneId) {
        Connect();
        Phone phone = null;   //not instantiated because if no records returned we don't want to use memory.
        try {
            String sp = "{call usp_GetPhone(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, phoneId);
            ResultSet rs = cStmt.executeQuery();

            if (rs.next()) {
                phone = HydrateObject(rs);
            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return phone;

    }

    @Override
    public List<Phone> getPhoneList() {
        Connect();
            List<Phone> phoneList = new ArrayList<Phone>();
        try {
            String sp = "{call usp_GetPhone(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2,0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {

                phoneList.add(HydrateObject(rs));
            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return phoneList;    }

    @Override
    public int insertPhone(Phone phone) {
        Connect();
        int id = 0;

        //region index values

        /*
        IN QueryId int(11),
        IN vPhoneId int(11),
        IN EntityTypeId int(11),
        IN ClientId int(11),
        IN PersonId int(11),
        IN AreaCode int(11),
        IN PhoneNumber int(11),
        IN PhoneNumberPost int(11)
        * */

        //endregion

        // call usp_ExecPerson(10, personId, Title, FirstName, MiddleName, LastName, DisplayFirstName,
        // Gender, BirthDate, SSN)


        try {
            String sp = "{call usp_ExecutePhone(?,?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setInt(3, phone.getEntityTypeId());
            cStmt.setInt(4, phone.getClientId());
            cStmt.setInt(5, phone.getPersonId());
            cStmt.setInt(6, phone.getAreaCode());
            cStmt.setInt(7, phone.getPhoneNumber());
            cStmt.setInt(8, phone.getPhoneNumberPost());

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
    public boolean updatePhone(Phone phone) {
        Connect();
        int id = 0;

        //region index values

        /*
        IN QueryId int(11),
        IN vPhoneId int(11),
        IN EntityTypeId int(11),
        IN ClientId int(11),
        IN PersonId int(11),
        IN AreaCode int(11),
        IN PhoneNumber int(11),
        IN PhoneNumberPost int(11)
        * */

        //endregion

        // call usp_ExecPerson(10, personId, Title, FirstName, MiddleName, LastName, DisplayFirstName,
        // Gender, BirthDate, SSN)


        try {
            String sp = "{call usp_ExecutePhone(?,?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, phone.getPhoneId());
            cStmt.setInt(3, phone.getEntityTypeId());
            cStmt.setInt(4, phone.getClientId());
            cStmt.setInt(5, phone.getPersonId());
            cStmt.setInt(6, phone.getAreaCode());
            cStmt.setInt(7, phone.getPhoneNumber());
            cStmt.setInt(8, phone.getPhoneNumberPost());

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
    public boolean deletePhone(int phoneId) {
        Connect();
        int id = 0;

        //region index values

        /*
        IN QueryId int(11),
        IN vPhoneId int(11),
        IN EntityTypeId int(11),
        IN ClientId int(11),
        IN PersonId int(11),
        IN AreaCode int(11),
        IN PhoneNumber int(11),
        IN PhoneNumberPost int(11)
        * */

        //endregion

        // call usp_ExecPerson(10, personId, Title, FirstName, MiddleName, LastName, DisplayFirstName,
        // Gender, BirthDate, SSN)


        try {
            String sp = "{call usp_ExecutePhone(?,?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, phoneId);
            cStmt.setInt(3, 0);
            cStmt.setInt(4, 0);
            cStmt.setInt(5, 0);
            cStmt.setInt(6, 0);
            cStmt.setInt(7, 0);
            cStmt.setInt(8, 0);

            ResultSet rs = cStmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return id > 0;
    }

    private static Phone HydrateObject(ResultSet rs) throws SQLException{
        /*
          PhoneId,          index 1 INT
          EntityTypeId,     index 2 INT
          ClientId,         index 3 INT
          PersonId,         index 4 INT
          AreaCode,         index 5 INT
          PhoneNumber,      index 6 INT
          PhoneNumberPost   index 7 INT
        */
        //notes:    HYDRATING AN OBJECT
        Phone phone = new Phone();

        phone.setPhoneId(rs.getInt(1));
        phone.setEntityTypeId(rs.getInt(2));
        phone.setClientId(rs.getInt(3));
        phone.setPersonId(rs.getInt(4));
        phone.setAreaCode(rs.getInt(5));
        phone.setPhoneNumber(rs.getInt(6));
        phone.setPhoneNumberPost(rs.getInt(7));

        return phone;

    }

    //endregion CUSTOM METHODS

}
