package com.astontech.bo;

import java.util.Date;

/**
 * Created by Carlos Zubiran on 5/10/2016.
 */
public class Client extends BaseBO {

    private int ClientId;
    private String ClientName;
    private Date CreateDate;

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
