/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author ASUS
 */
public class CDCollectionPartialEntity implements ICDHouseEntity{
    String cdID;
    String partialID;

    public CDCollectionPartialEntity(String cdID, String partialID) {
        this.cdID = cdID;
        this.partialID = partialID;
    }

    public CDCollectionPartialEntity() {
    }
    
    
    @Override
    public String getID() {
        return cdID;
    }

    public void setCdID(String cdID) {
        this.cdID = cdID;
    }

    public String getPartialID() {
        return partialID;
    }

    public void setPartialID(String partialID) {
        this.partialID = partialID;
    }

    @Override
    public String toString() {
        return cdID + "," + partialID;
    }
    
}
