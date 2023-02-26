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
public class CDPartialEntity implements ICDHouseEntity{
    private String partialID;
    private String name;
    private String category;

    /**
     *
     * @return
     */
    @Override
    public String getID() {
        return partialID;
    }

    public CDPartialEntity() {
    }
    
    public CDPartialEntity(String partialID, String name, String category) {
        this.partialID = partialID;
        this.name = name;
        this.category = category;
    }
    
    public void setPartialID(String partialID) {
        this.partialID = partialID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return partialID + "," + name + "," + category;
    }


    
    
}
