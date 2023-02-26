/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.CDTypeDao;
import dto.CDTypeEntity;
import model.CDPartialModel;
import model.CDTypeModel;
import mytools.Singleton;

/**
 *
 * @author ASUS
 */
public class CDTypeService extends AbstractCDHouseService<CDTypeModel, CDTypeEntity>{

    private CDTypeService() {
        this.typeM = CDTypeModel.class;
        this.typeE = CDTypeEntity.class;
        this.dao = Singleton.getInstance(CDTypeDao.class);
    }

    @Override
    protected CDTypeEntity toEntity(CDTypeModel model) {
        CDTypeEntity output = factoryE.createCD(typeE);
        output.setID(model.getId().toString());
        output.setType(model.getType().toString());
        return output;
    }

    @Override
    protected CDTypeModel toModel(CDTypeEntity entity) {
        CDTypeModel output = factoryM.createCD(typeM);
        output.setId(entity.getID());
        output.setType(entity.getType());
        return output;
    }
    
 
   
}
