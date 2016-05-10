package com.astontech.bo;

/**
 * Created by Carlos Zubiran on 5/9/2016.
 */
public class Entity extends BaseBO{

    private int EntityId;
    private String EntityName;

    public int getEntityId() {
        return EntityId;
    }

    public void setEntityId(int entityId) {
        EntityId = entityId;
    }

    public String getEntityName() {
        return EntityName;
    }

    public void setEntityName(String entityName) {
        EntityName = entityName;
    }

}
