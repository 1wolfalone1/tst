/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class CDEntity implements ICDHouseEntity{
    private String ID;
    private String title;
    private String typeID;
           
           
    private String unitPrice;
    private String publishYear;

    public CDEntity() {
        
    }

    public CDEntity(String ID, String title, String typeID, String unitPrice, String publishYear) {
        this.ID = ID;
        this.title = title;
        this.typeID = typeID;
        this.unitPrice = unitPrice;
        this.publishYear = publishYear;
    }
    
    
    @Override
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return ID + "," + title + "," + typeID + "," + unitPrice + "," + publishYear;
    }


}
