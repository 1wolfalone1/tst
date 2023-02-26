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
public class CDTypeEntity implements ICDHouseEntity{
    private String ID;
    private String type;

    public CDTypeEntity(String ID, String type) {
        this.ID = ID;
        this.type = type;
    }

    public CDTypeEntity() {
    }
    
    @Override
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ID + "," + type;
    }
    
    
}
