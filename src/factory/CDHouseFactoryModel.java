/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import model.CDModel;
import model.CDPartialModel;
import model.CDTypeModel;
import model.ICDHouseModel;

/**
 *
 * @author ASUS
 */
public class CDHouseFactoryModel {


    private CDHouseFactoryModel() {

    }
    
    public <T> T createCD(Class<? extends ICDHouseModel> type) {
        if(type.equals(CDModel.class)){
            return (T) new CDModel();
        } else if(type.equals(CDPartialModel.class)){
            return (T) new CDPartialModel();
        } else if(type.equals(CDTypeModel.class)){
            return (T) new CDTypeModel();
        } 
        return null;
    }
}
