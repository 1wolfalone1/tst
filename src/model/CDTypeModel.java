/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.CDTypeController;
import mytools.Singleton;

/**
 *
 * @author ASUS
 */
public class CDTypeModel extends AbstractCDHouseModel {

    public final static String FORMAT_ID = ".*";

    private String type;

    public CDTypeModel() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean validID(String id) {
        return true;
    }

    @Override
    public String toString() {
        return "CDTypeModel{" + "type=" + type + '}';
    }

    public void input() {
        CDTypeModel tmp = new CDTypeModel();
        tmp = Singleton.getInstance(CDTypeController.class).lookupType();
        setId(tmp.getId());
        setType(tmp.type);
    }

    public void update() {
        CDTypeModel tmp = new CDTypeModel();
        tmp = Singleton.getInstance(CDTypeController.class).lookupTypeUpdate();
        if (tmp != null) {
            setId(tmp.getId());
            setType(tmp.type);
        }

    }
}
