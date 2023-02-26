/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dto.CDCollectionPartialEntity;
import dto.CDEntity;
import dto.CDPartialEntity;
import dto.CDTypeEntity;
import dto.ICDHouseEntity;

/**
 *
 * @author ASUS
 */
public class CDHouseFactoryEntity {
    private CDHouseFactoryEntity() {

    }
    
    public <T> T createCD(Class<? extends ICDHouseEntity> type) {
        if(type.equals(CDEntity.class)){
            return (T) new CDEntity();
        } else if(type.equals(CDPartialEntity.class)){
            return (T) new CDPartialEntity();
        } else if(type.equals(CDTypeEntity.class)){
            return (T) new CDTypeEntity();
        } else if(type.equals(CDCollectionPartialEntity.class)){
            return (T)  new CDCollectionPartialEntity();
        }
        return null;
    }
}
