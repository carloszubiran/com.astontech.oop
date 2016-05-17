package com.astontech.bo;

import common.helpers.StringHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Carlos Zubiran on 5/9/2016.
 */
public class Person extends BaseBO implements Comparable<Person> {

    //region PROPERTIES

    // PersonId
    private int PersonId;
    // Title
    private String Title;
    // FirstName
    private String FirstName;
    // MiddleName
    private String MiddleName;
    // LastName
    private String LastName;
    // CreateDate
    private Date CreateDate;
    // DisplayFirstName
    private String DisplayFirstName;
    // IsDeleted
    private boolean IsDeleted;
    // Gender
    private String Gender;
    // List of Email Objects
    private List<Email> Emails;
    // Birthdate
    private Date BirthDate;
    // Social Security Number
    private String SSN;

    //endregion PROPERTIES

    //region CONSTRUCTOR

    public Person() {
        this.Emails = new ArrayList<>();
    }

    //endregion CONSTRUCTOR

    //region GETTERS / SETTERS


    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public String getDisplayFirstName() {
        return DisplayFirstName;
    }

    public void setDisplayFirstName(String displayFirstName) {
        DisplayFirstName = displayFirstName;
    }

    public boolean isDeleted() {
        return IsDeleted;
    }

    public void setDeleted(boolean deleted) {
        IsDeleted = deleted;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public List<Email> getEmails() {
        return Emails;
    }

    public void setEmails(List<Email> emails) {
        Emails = emails;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    //endregion GETTERS / SETTERS

    //region CUSTOM METHODDS

    public String GetFullName() {
        if(StringHelper.isNullOrEmpty(this.FirstName) && StringHelper.isNullOrEmpty(this.LastName)){
            return "No Name Set";}
        else{
            if (StringHelper.isNullOrEmpty(this.FirstName)){
                return this.LastName;
            }
            else if(StringHelper.isNullOrEmpty(this.LastName)){
                return this.FirstName;
            }
            else{
                return this.FirstName + " " + this.LastName;
            }

        }

    }

    @Override
    public int compareTo(Person P) {
        if (this.getFirstName().compareToIgnoreCase(P.getFirstName()) >= 1) {
            System.out.println(this.getFirstName() + " - is greater that - " + P.getFirstName());
            return this.getFirstName().compareToIgnoreCase(P.getFirstName());
        } else if (this.getFirstName().compareToIgnoreCase(P.getFirstName()) == 0) {
            System.out.println(this.getFirstName() + "Is equal to " + P.getFirstName());
            return this.getFirstName().compareToIgnoreCase(P.getFirstName());
        } else {
            System.out.println(this.getFirstName() + " is less than " + P.getFirstName());
            return this.getFirstName().compareToIgnoreCase(P.getFirstName());
        }


    }

    //endregion CUSTOM METHODS

}
