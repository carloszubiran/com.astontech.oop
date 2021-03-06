package com.astontech.dao.mysql;

import com.astontech.bo.VehicleMake;
import com.astontech.dao.VehicleMakeDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Zubiran on 5/13/2016.
 */
public class VehicleMakeDAOImpl extends MySQL implements VehicleMakeDAO {

    //region PROPERTIES


    //endregion PROPERTIES

    //region CONSTRUCTORS


    //endregion CONSTRUCTORS

    //region GETTERS / SETTERS


    //endregion GETTERS / SETTERS

    //region CUSTOM METHODS

    @Override
    public VehicleMake getVehicleMakeById(int vehicleMakeId) {
        Connect();
        VehicleMake vehicleMake = null;   //not instantiated because if no records returned we don't want to use memory.
        try {
            String sp = "{call usp_GetVehicleMake(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, vehicleMakeId);
            ResultSet rs = cStmt.executeQuery();

            if (rs.next()) {
                vehicleMake = HydrateObject(rs);
            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return vehicleMake;

    }

    @Override
    public List<VehicleMake> getVehicleMakeList() {
        Connect();
            List<VehicleMake> vehicleMakeList = new ArrayList<VehicleMake>();
        try {
            String sp = "{call usp_GetVehicleMake(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2,0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {

                vehicleMakeList.add(HydrateObject(rs));
            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return vehicleMakeList;    }

    @Override
    public int insertVehicleMake(VehicleMake vehicleMake) {
        Connect();
        int id = 0;

        //region index values

        /*
        IN QueryId int(11),
        IN vVehicleMakeId int(11),
        IN VehicleMakeName varchar(50)
        * */

        //endregion

        try {
            String sp = "{call usp_ExecuteVehicleMake(?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setString(3, vehicleMake.getVehicleMakeName());

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
    public boolean updateVehicleMake(VehicleMake vehicleMake) {
        Connect();
        int id = 0;

        //region index values

        /*
        IN QueryId int(11),
        IN vVehicleMakeId int(11),
        IN VehicleMakeName varchar(50)
        * */

        //endregion

        try {
            String sp = "{call usp_ExecuteVehicleMake(?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, vehicleMake.getVehicleMakeId());
            cStmt.setString(3, vehicleMake.getVehicleMakeName());

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
    public boolean deleteVehicleMake(int vehicleMakeId) {
        Connect();
        int id = 0;

        //region index values

        /*
        IN QueryId int(11),
        IN vVehicleMakeId int(11),
        IN VehicleMakeName varchar(50)
        * */

        //endregion

        try {
            String sp = "{call usp_ExecuteVehicleMake(?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, vehicleMakeId);
            cStmt.setString(3, "");

            ResultSet rs = cStmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return id > 0;

    }

    private static VehicleMake HydrateObject(ResultSet rs) throws SQLException{
        /*
          VehicleMakeId     index 1 INT
          VehicleMakeName   index 1 VARCHAR
          CreateDate        index 1 DATETIME
        */
        //notes:    HYDRATING AN OBJECT
        VehicleMake vehicleMake = new VehicleMake();

        vehicleMake.setVehicleMakeId(rs.getInt(1));
        vehicleMake.setVehicleMakeName(rs.getString(2));
        vehicleMake.setCreateDate(rs.getDate(3));

        return vehicleMake;

    }

    //endregion CUSTOM METHODS

}
