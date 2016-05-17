package com.astontech.dao.mysql;

import com.astontech.bo.Vehicle;
import com.astontech.dao.VehicleDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Zubiran on 5/13/2016.
 */
public class VehicleDAOImpl extends MySQL implements VehicleDAO {

    //region PROPERTIES


    //endregion PROPERTIES

    //region CONSTRUCTORS


    //endregion CONSTRUCTORS

    //region GETTERS / SETTERS


    //endregion GETTERS / SETTERS

    //region CUSTOM METHODS

    @Override
    public Vehicle getVehicleById(int vehicleId) {
        Connect();
        Vehicle vehicle = null;   //not instantiated because if no records returned we don't want to use memory.
        try {
            String sp = "{call usp_GetVehicle(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, vehicleId);
            ResultSet rs = cStmt.executeQuery();

            if (rs.next()) {
                vehicle = HydrateObject(rs);
            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return vehicle;

    }

    @Override
    public List<Vehicle> getVehicleList() {
        Connect();
            List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        try {
            String sp = "{call usp_GetVehicle(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2,0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {

                vehicleList.add(HydrateObject(rs));
            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return vehicleList;    }

    @Override
    public int insertVehicle(Vehicle vehicle) {
        Connect();
        int id = 0;

        //region index values

        /*
        IN QueryId 			int(11),        index 1
        IN vVehicleId 		int(11),        index 2
        IN `Year`			int(11),        index 3
        IN LicencePlate		varchar(10),    index 4
        IN VIN				varchar(20),	index 5
        IN Color			varchar(10),	index 6
        IN IsPurchase		tinyint(1),     index 7
        IN PurchasePrice	int(11),        index 8
        IN PurchaseDate		datetime,       index 9
        IN VehicleModelId	int(11)         index 10
        * */

        //endregion

        try {
            String sp = "{call usp_ExecuteVehicle(?,?,?,?,?," +
                                                 "?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setInt(3, vehicle.getYear());
            cStmt.setString(4, vehicle.getLicensePlate());
            cStmt.setString(5, vehicle.getVIN());
            cStmt.setString(6, vehicle.getColor());
            cStmt.setBoolean(7, vehicle.isPurchase());
            cStmt.setInt(8, vehicle.getPurchasePrice());
            cStmt.setDate(9, DateHelper.utilDateToSqlDate(vehicle.getPurchaseDate()));
            cStmt.setInt(10, vehicle.getVehicleId());

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
    public boolean updateVehicle(Vehicle vehicle) {
        Connect();
        int id = 0;

        //region index values

        /*
        IN QueryId 			int(11),        index 1
        IN vVehicleId 		int(11),        index 2
        IN `Year`			int(11),        index 3
        IN LicencePlate		varchar(10),    index 4
        IN VIN				varchar(20),	index 5
        IN Color			varchar(10),	index 6
        IN IsPurchase		tinyint(1),     index 7
        IN PurchasePrice	int(11),        index 8
        IN PurchaseDate		datetime,       index 9
        IN VehicleModelId	int(11)         index 10
        * */

        //endregion

        try {
            String sp = "{call usp_ExecuteVehicle(?,?,?,?,?," +
                    "?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, vehicle.getVehicleId());
            cStmt.setInt(3, vehicle.getYear());
            cStmt.setString(4, vehicle.getLicensePlate());
            cStmt.setString(5, vehicle.getVIN());
            cStmt.setString(6, vehicle.getColor());
            cStmt.setBoolean(7, vehicle.isPurchase());
            cStmt.setInt(8, vehicle.getPurchasePrice());
            cStmt.setDate(9, DateHelper.utilDateToSqlDate(vehicle.getPurchaseDate()));
            cStmt.setInt(10, vehicle.getVehicleId());

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
    public boolean deleteVehicle(int vehicleId) {
        return false;
    }

    private static Vehicle HydrateObject(ResultSet rs) throws SQLException{
        /*
          VehicleId,        index 1 INT
          Year,             index 2 INT
          LicencePlate,     index 3 VARCHAR
          VIN,              index 4 VARCHAR
          Color,            index 5 VARCHAR
          IsPurchase,       index 6 TINYINT
          PurchasePrice,    index 7 INT
          PurchaseDate,     index 8 DATETIME
          VehicleModelId    index 9 INT

        */
        //notes:    HYDRATING AN OBJECT
        Vehicle vehicle = new Vehicle();

        vehicle.setVehicleId(rs.getInt(1));
        vehicle.setYear(rs.getInt(2));
        vehicle.setLicensePlate(rs.getString(3));
        vehicle.setVIN(rs.getString(4));
        vehicle.setColor(rs.getString(5));
        vehicle.setPurchase(rs.getBoolean(6));
        vehicle.setPurchasePrice(rs.getInt(7));
        vehicle.setPurchaseDate(rs.getDate(8));
        vehicle.getVehicleModel().setId(rs.getInt(9));

        return vehicle;

    }

    //endregion CUSTOM METHODS

}
