package common.helpers;

/**
 * Created by Carlos Zubiran on 5/16/2016.
 */
public class DateHelper {

    //region PROPERTIES


    //endregion PROPERTIES

    //region CONSTRUCTORS


    //endregion CONSTRUCTORS

    //region GETTERS / SETTERS


    //endregion GETTERS / SETTERS

    //region CUSTOM METHODS

    public static java.sql.Date utilDateToSqlDate(java.util.Date date) {

        return new java.sql.Date(date.getTime());

    }


    public static java.util.Date sqlDateToUtilDate(java.sql.Date date) {

        return new java.util.Date(date.getTime());

    }

    //endregion CUSTOM METHODS


}
