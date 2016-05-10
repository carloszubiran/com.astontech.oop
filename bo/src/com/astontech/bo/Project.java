package com.astontech.bo;

import java.util.Date;

/**
 * Created by Carlos Zubiran on 5/10/2016.
 */
public class Project extends BaseBO {

    private int ProjectId;
    private int ClientId;
    private int EntityType;
    private int Rate;
    private Date StartDate;
    private Date EndDate;
    private String ProjectName;

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public int getEntityType() {
        return EntityType;
    }

    public void setEntityType(int entityType) {
        EntityType = entityType;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int rate) {
        Rate = rate;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }
}
