package com.astontech.bo;

/**
 * Created by Carlos Zubiran on 5/10/2016.
 */
public class Email extends BaseBO{

    //region PROPERTIES

    private int EmailId;
    private String EmailAddress;
    private int EmployeeId;
    private EntityType EntityType;

    //endregion PROPERTIES

    //region CONSTRUCTORS

    public Email() {
        this.EntityType = new EntityType();
    }

    public Email(String emailAddress) {
        this.EntityType = new EntityType();
        this.EmailAddress = emailAddress;

    }

    //endregion CONSTRUCTORS

    //region GETTERS / SETTERS

    public int getEmailId() {
        return EmailId;
    }

    public void setEmailId(int emailId) {
        EmailId = emailId;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public EntityType getEntityType() {
        return EntityType;
    }

    public void setEntityType(EntityType entityType) {
        EntityType = entityType;
    }

//endregion GETTERS / SETTERS





}
