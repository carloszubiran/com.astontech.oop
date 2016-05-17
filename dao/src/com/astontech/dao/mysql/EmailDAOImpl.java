package com.astontech.dao.mysql;

import com.astontech.bo.Email;
import com.astontech.dao.EmailDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Zubiran on 5/13/2016.
 */
public class EmailDAOImpl extends MySQL implements EmailDAO {

    //region PROPERTIES


    //endregion PROPERTIES

    //region CONSTRUCTORS


    //endregion CONSTRUCTORS

    //region GETTERS / SETTERS


    //endregion GETTERS / SETTERS

    //region CUSTOM METHODS

    @Override
    public Email getEmailById(int emailId) {
        Connect();
        Email email = null;   //not instantiated because if no records returned we don't want to use memory.
        try {
            String sp = "{call usp_GetEmail(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, emailId);
            ResultSet rs = cStmt.executeQuery();

            if (rs.next()) {
                email = HydrateObject(rs);
            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return email;

    }

    @Override
    public List<Email> getEmailList() {
        Connect();
            List<Email> emailList = new ArrayList<Email>();
        try {
            String sp = "{call usp_GetEmail(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2,0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {

                emailList.add(HydrateObject(rs));
            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return emailList;    }

    @Override
    public int insertEmail(Email email) {

        Connect();
        int id = 0;

        //region INDEX VALUES

        /*
            IN QueryId 			int(11),
            IN vEmailId 		int(11),
            IN EmailAddress		varchar(50),
            IN EmployeeId		int(11),
            IN EntityTypeId		int(11)
        * */

        //endregion

        try {
            String sp = "{call usp_ExecuteEmail(?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setString(3, email.getEmailAddress());
            cStmt.setInt(4, email.getEmployeeId());
            cStmt.setInt(5, email.getEntityType().getId());

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
    public boolean updateEmail(Email email) {
        Connect();
        int id = 0;

        //region INDEX VALUES

        /*
            IN QueryId 			int(11),
            IN vEmailId 		int(11),
            IN EmailAddress		varchar(50),
            IN EmployeeId		int(11),
            IN EntityTypeId		int(11)
        * */

        //endregion

        try {
            String sp = "{call usp_ExecuteEmail(?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, email.getEmailId());
            cStmt.setString(3, email.getEmailAddress());
            cStmt.setInt(4, email.getEmployeeId());
            cStmt.setInt(5, email.getEntityType().getId());

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
    public boolean deleteEmail(int emailId) {
        Connect();
        int id = 0;

        //region INDEX VALUES

        /*
            IN QueryId 			int(11),
            IN vEmailId 		int(11),
            IN EmailAddress		varchar(50),
            IN EmployeeId		int(11),
            IN EntityTypeId		int(11)
        * */

        //endregion

        try {
            String sp = "{call usp_ExecuteEmail(?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, emailId);
            cStmt.setString(3, "");
            cStmt.setInt(4, 0);
            cStmt.setInt(5, 0);

            ResultSet rs = cStmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return id > 0;    }

    private static Email HydrateObject(ResultSet rs) throws SQLException{
        /*
          EmailId,          index 1 INT
          EmailAddress,     index 2 VARCHAR
          EmployeeId,       index 3 INT
          EntityTypeId      index 4 INT
        */
        //notes:    HYDRATING AN OBJECT
        Email email = new Email();

        email.setEmailId(rs.getInt(1));
        email.setEmailAddress(rs.getString(2));
        email.setEmployeeId(rs.getInt(3));
        email.getEntityType().setId(rs.getInt(4));


        return email;

    }

    //endregion CUSTOM METHODS

}
