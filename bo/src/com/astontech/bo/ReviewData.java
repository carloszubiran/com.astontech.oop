package com.astontech.bo;

import java.util.Date;

/**
 * Created by Carlos Zubiran on 5/10/2016.
 */
public class ReviewData extends BaseBO {

    private int ReviewDataId;
    private int ReviewData;
    private int EntityType;
    private String ReviewDataValue;
    private Date CreateDate;

    public int getReviewDataId() {
        return ReviewDataId;
    }

    public void setReviewDataId(int reviewDataId) {
        ReviewDataId = reviewDataId;
    }

    public int getReviewData() {
        return ReviewData;
    }

    public void setReviewData(int reviewData) {
        ReviewData = reviewData;
    }

    public int getEntityType() {
        return EntityType;
    }

    public void setEntityType(int entityType) {
        EntityType = entityType;
    }

    public String getReviewDataValue() {
        return ReviewDataValue;
    }

    public void setReviewDataValue(String reviewDataValue) {
        ReviewDataValue = reviewDataValue;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
