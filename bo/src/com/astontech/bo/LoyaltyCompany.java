package com.astontech.bo;

/**
 * Created by Carlos Zubiran on 5/10/2016.
 */
public class LoyaltyCompany {

    private String CompanyName;
    private int LoyaltyCompanyId;
    private int EntityTypeId;

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public int getLoyaltyCompanyId() {
        return LoyaltyCompanyId;
    }

    public void setLoyaltyCompanyId(int loyaltyCompanyId) {
        LoyaltyCompanyId = loyaltyCompanyId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }
}
