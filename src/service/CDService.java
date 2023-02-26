/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.CDCollectionPartialDao;
import dao.CDDao;
import dto.CDEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.CDModel;
import mytools.MyTool;
import mytools.Singleton;

/**
 *
 * @author ASUS
 */
public class CDService extends AbstractCDHouseService<CDModel, CDEntity> {

    private CDTypeService cdType = Singleton.getInstance(CDTypeService.class);
    private CDCollectionPartialDao collectionPartial = Singleton.getInstance(CDCollectionPartialDao.class);

    private CDService() {
        this.typeE = CDEntity.class;
        this.typeM = CDModel.class;
        this.dao = Singleton.getInstance(CDDao.class);
    }

    @Override
    protected CDEntity toEntity(CDModel model) {
        CDEntity output = factoryE.createCD(typeE);
        output.setID(model.getId());
        output.setTitle(model.getTitle());
        output.setTypeID(model.getTypeModel().getId());
        output.setUnitPrice(String.valueOf(model.getUnitPrice()));
        output.setPublishYear(MyTool.convertDateToString(model.getPublishYear(), CDModel.FORMAT_DATE));
        return output;
    }

    @Override
    protected CDModel toModel(CDEntity entity) {
        if (entity == null) {
            return null;
        }
        CDModel output = factoryM.createCD(typeM);
        output.setId(entity.getID());
        output.setTitle(entity.getTitle());
        output.setType(cdType.filterById(entity.getTypeID()));
        output.setChapter(new ArrayList());
        output.setUnitPrice(Double.parseDouble(entity.getUnitPrice()));
        output.setPublishYear(MyTool.convertToDate(entity.getPublishYear(), CDModel.FORMAT_DATE));
        return output;
    }

    public List<CDModel> filter(String title) {
        String nameTmp = title.toUpperCase();
        return stream().filter((prd -> prd.getTitle()!= null && prd.getTitle().toUpperCase().contains(nameTmp))).collect(Collectors.toList());
    }

}
