package com.astontech.bo;

import java.util.Date;

/**
 * Created by Carlos Zubiran on 5/10/2016.
 */
public class TrainingData extends BaseBO {

    private int TrainingDataId;
    private int TrainingId;
    private int EntityTypeId;
    private String TraingingDataValue;
    private Date CreateDate;


    public int getTrainingDataId() {
        return TrainingDataId;
    }

    public void setTrainingDataId(int trainingDataId) {
        TrainingDataId = trainingDataId;
    }

    public int getTrainingId() {
        return TrainingId;
    }

    public void setTrainingId(int trainingId) {
        TrainingId = trainingId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public String getTraingingDataValue() {
        return TraingingDataValue;
    }

    public void setTraingingDataValue(String traingingDataValue) {
        TraingingDataValue = traingingDataValue;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
