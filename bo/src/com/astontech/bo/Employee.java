package com.astontech.bo;

import java.util.Date;
import java.util.EnumMap;

/**
 * Created by Carlos Zubiran on 5/9/2016.
 */
public class Employee extends Person {


    // PARAMETERS
    private int EmployeeId;
    private Date HireDate;
    private Date TermDate;

    // CONSTRUCTORS

    public Employee() {

    }

    public Employee(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public Employee(int employeeId, String firstName) {
        this.setFirstName(firstName);
    }

    public Employee(String lastName) {
        this.setLastName(lastName);
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public Date getHireDate() {
        return HireDate;
    }

    public void setHireDate(Date hireDate) {
        HireDate = hireDate;
    }

    public Date getTermDate() {
        return TermDate;
    }

    public void setTermDate(Date termDate) {
        TermDate = termDate;
    }



}
