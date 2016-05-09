package com.astontech.bo;

/**
 * Created by Carlos Zubiran on 5/9/2016.
 */
public class Person extends BaseBO {

    // PersonId
    private int PersonId;
    // Title
    private String Title;
    // FirstName
    private String FirstName;
    // LastName
    private String LastName;
    // DisplayFirstName
    private String DisplayFirstName;
    // Gender
    private String Gender;

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

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDisplayFirstName() {
        return DisplayFirstName;
    }

    public void setDisplayFirstName(String displayFirstName) {
        DisplayFirstName = displayFirstName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    // CUSTOM METHODDS
    //notes:    this will become an extension method
    public static boolean isNullOrEmpty(String s){
        return s == null || s.length() == 0;
    }

    public String GetFullName() {
        if(isNullOrEmpty(this.FirstName) && isNullOrEmpty(this.LastName)){
            return "No Name Set";}
        else{
            if (isNullOrEmpty(this.FirstName)){
                return this.LastName;
            }
            else if(isNullOrEmpty(this.LastName)){
                return this.FirstName;
            }
            else{
                return this.FirstName + " " + this.LastName;
            }

        }

    }


}
