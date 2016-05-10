package com.astontech.bo;

/**
 * Created by Carlos Zubiran on 5/10/2016.
 */
public class ClientContract extends BaseBO {

    private int ClientContractId;
    private int ClientId;
    private int EntityTypeId;
    private int PersonId;

    public int getClientContractId() {
        return ClientContractId;
    }

    public void setClientContractId(int clientContractId) {
        ClientContractId = clientContractId;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }
}
