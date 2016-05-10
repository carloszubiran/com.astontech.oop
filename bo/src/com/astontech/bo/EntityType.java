package com.astontech.bo;

/**
 * Created by Carlos Zubiran on 5/9/2016.
 */
public class EntityType extends BaseBO{

    //region PROPERTIES

    private int EntityTypeId;
    private String EntityTypeName;

    //endregion PROPERTIES

    //region CONSTRUCTORS

    public EntityType() {

    }

    public EntityType(String entityTypeName) {
        this.EntityTypeName = entityTypeName;
    }

    //endregion CONSTRUCTORS

    //region GETTERS / SETTERS

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public String getEntityTypeName() {
        return EntityTypeName;
    }

    public void setEntityTypeName(String entityTypeName) {
        EntityTypeName = entityTypeName;
    }

    //endregion GETTERS / SETTERS

}
