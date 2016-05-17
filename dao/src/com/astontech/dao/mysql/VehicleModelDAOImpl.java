package com.astontech.dao.mysql;

import com.astontech.bo.VehicleModel;
import com.astontech.dao.VehicleModelDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Zubiran on 5/13/2016.
 */
public class VehicleModelDAOImpl extends MySQL implements VehicleModelDAO {

    //region PROPERTIES


    //endregion PROPERTIES

    //region CONSTRUCTORS


    //endregion CONSTRUCTORS

    //region GETTERS / SETTERS


    //endregion GETTERS / SETTERS

    //region CUSTOM METHODS

    @Override
    public VehicleModel getVehicleModelById(int vehicleModelId) {
        Connect();
        VehicleModel vehicleModel = null;   //not instantiated because if no records returned we don't want to use memory.
        try {
            String sp = "{call usp_GetVehicleModel(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, vehicleModelId);
            ResultSet rs = cStmt.executeQuery();

            if (rs.next()) {
                vehicleModel = HydrateObject(rs);
            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return vehicleModel;

    }

    @Override
    public List<VehicleModel> getVehicleModelList() {
        Connect();
            List<VehicleModel> vehicleModelList = new ArrayList<VehicleModel>();
        try {
            String sp = "{call usp_GetVehicleModel(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2,0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {

                vehicleModelList.add(HydrateObject(rs));
            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return vehicleModelList;    }

    @Override
    public int insertVehicleModel(VehicleModel vehicleModel) {
        Connect();
        int id = 0;

        //region index values

        /*
        IN QueryId int(11),
        IN vVehicleModelId int(11),
        IN VehicleModelName varchar(50),
        IN VehicleMakeId int(11)
        * */

        //endregion

        try {
            String sp = "{call usp_ExecuteVehicleModel(?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setString(3, vehicleModel.getVehicleModelName());
            cStmt.setInt(4, vehicleModel.getVehicleMakeId());

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
    public boolean updateVehicleModel(VehicleModel vehicleModel) {
        Connect();
        int id = 0;

        //region index values

        /*
        IN QueryId int(11),
        IN vVehicleModelId int(11),
        IN VehicleModelName varchar(50),
        IN VehicleMakeId int(11)
        * */

        //endregion

        try {
            String sp = "{call usp_ExecuteVehicleModel(?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, 0);
            cStmt.setString(3, vehicleModel.getVehicleModelName());
            cStmt.setInt(4, vehicleModel.getVehicleMakeId());

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
    public boolean deleteVehicleModel(int vehicleModelId) {
        Connect();
        int id = 0;

        //region index values

        /*
        IN QueryId int(11),
        IN vVehicleModelId int(11),
        IN VehicleModelName varchar(50),
        IN VehicleMakeId int(11)
        * */

        //endregion

        try {
            String sp = "{call usp_ExecuteVehicleModel(?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, vehicleModelId);
            cStmt.setString(3, "");
            cStmt.setInt(4, 0);

            ResultSet rs = cStmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return id > 0;
    }

    private static VehicleModel HydrateObject(ResultSet rs) throws SQLException{
        /*
            VehicleModelId,   index 1 INT
            VehicleModelName, index 2 VARCHAR
            VehicleMakeId     index 3 INT
        */
        //notes:    HYDRATING AN OBJECT
        VehicleModel vehicleModel = new VehicleModel();

        vehicleModel.setVehicleModelId(rs.getInt(1));
        vehicleModel.setVehicleModelName(rs.getString(2));
        vehicleModel.setVehicleMakeId(rs.getInt(3));


        return vehicleModel;

    }

    //endregion CUSTOM METHODS

}
