package com.astontech.bo;

import java.util.Date;

/**
 * Created by Carlos Zubiran on 5/10/2016.
 */
public class Training extends BaseBO{

    private int TrainingId;
    private int EmployeeId;
    private String TrainingName;
    private Date CreateDate;

    public int getTrainingId() {
        return TrainingId;
    }

    public void setTrainingId(int trainingId) {
        TrainingId = trainingId;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public String getTrainingName() {
        return TrainingName;
    }

    public void setTrainingName(String trainingName) {
        TrainingName = trainingName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
