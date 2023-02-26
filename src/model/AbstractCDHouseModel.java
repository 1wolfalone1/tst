/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public abstract class AbstractCDHouseModel implements ICDHouseModel {

    public final static String BLANK_FORMAT = "[\\s]*";

    public final static String FORMAT_NOT_BLANK = "(?=.*[\\S]).*";
    private String id;

    public AbstractCDHouseModel() {

    }

    public AbstractCDHouseModel(String id) {
        setId(id);
    }

    
    @Override
    public void setId(String id) {
        if (validID(id)) {
            this.id = id;
        }
    }

    @Override
    public String getId() {
        return this.id;
    }

    public abstract boolean validID(String id);

    @Override
    public String toString() {
        return "AbstractCDHouseModel{" + "id=" + id + '}';
    }

}
