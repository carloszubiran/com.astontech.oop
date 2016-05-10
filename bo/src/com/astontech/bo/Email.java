package com.astontech.bo;

/**
 * Created by Carlos Zubiran on 5/10/2016.
 */
public class Email extends BaseBO{

    //region PROPERTIES

    private int EmailId;
    private String EmailAddress;
    private int EmployeeId;
    private EntityType EmailType;

    //endregion PROPERTIES

    //region CONSTRUCTORS

    public Email() {
        this.EmailType = new EntityType();
    }

    public Email(String emailAddress) {
        this.EmailType = new EntityType();
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

    public EntityType getEmailType() {
        return EmailType;
    }

    public void setEmailType(EntityType emailType) {
        EmailType = emailType;
    }

//endregion GETTERS / SETTERS





}
