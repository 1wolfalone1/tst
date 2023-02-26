/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.CDCollectionPartialDao;
import dao.CDPartialDao;
import dto.CDCollectionPartialEntity;
import dto.CDPartialEntity;
import java.util.ArrayList;
import java.util.List;
import model.CDModel;
import model.CDPartialModel;
import mytools.Singleton;

/**
 *
 * @author ASUS
 */
public class CDPartialService extends AbstractCDHouseService<CDPartialModel, CDPartialEntity> {

    public final static int MAX_COUNT = 700;
    private CDCollectionPartialDao collectionPartial = Singleton.getInstance(CDCollectionPartialDao.class);
    private CDService cdService;
    private int count;

    private CDPartialService() {
        collectionPartial.loadData();
        this.typeE = CDPartialEntity.class;
        this.typeM = CDPartialModel.class;
        this.dao = Singleton.getInstance(CDPartialDao.class);
        cdService = Singleton.getInstance(CDService.class);
    }

    @Override
    protected CDPartialEntity toEntity(CDPartialModel model) {
        CDPartialEntity output = factoryE.createCD(typeE);
        output.setPartialID(model.getId().toString());
        output.setName(model.getName().toString());
        output.setCategory(model.getCategory());
        return output;
    }

    @Override
    protected CDPartialModel toModel(CDPartialEntity entity) {
        CDPartialModel output = factoryM.createCD(typeM);
        output.setId(entity.getID().toString());
        output.setName(entity.getName());
        output.setCategory(entity.getCategory());
        return output;
    }

    @Override
    public int load() {
        int count = super.load();
        for (int i = 0; i < cdService.size(); i++) {
            cdService.get(i).setChapter(this.getPartialList(cdService.get(i).getId()));

        }
        return count;
    }

    private List<CDPartialModel> getPartialList(String cdId) {
        List<CDPartialModel> output = new ArrayList<>();
        List<String> partialList = getListPartialID(cdId);
        for (int i = 0; i < partialList.size(); i++) {
            output.add(this.filterById(partialList.get(i)));
        }
        return output;
    }

    private List<String> getListPartialID(String id) {
        List<String> output = new ArrayList<>();
        for (int i = 0; i < collectionPartial.getAll().size(); i++) {
            if (collectionPartial.getAll().get(i).getID().equalsIgnoreCase(id)) {
                output.add(collectionPartial.getAll().get(i).getPartialID());
            }
        }
        return output;
    }

    public CDPartialModel addPartialModel(CDPartialModel paModel, CDModel cdModel) {
        int idx = cdService.indexOf(cdModel);
        if (idx == -1) {
            return null;
        }
        int newIdx = getMaxCountPartial() + 1;
        paModel.setId("" + newIdx);
        cdService.get(idx).setChapter(paModel);
        super.add(paModel);
        CDCollectionPartialEntity listPartial = factoryE.createCD(CDCollectionPartialEntity.class);
        listPartial.setCdID(cdModel.getId());
        listPartial.setPartialID(paModel.getId());
        collectionPartial.getAll().add(listPartial);
        collectionPartial.save(collectionPartial.getAll());
        return paModel;
    }

    public CDPartialModel deletePartialModel(CDPartialModel paModel, CDModel cdModel) {
        int idx = cdService.indexOf(cdModel);
        int idxColPa = idxColPartial(paModel, cdModel);
        if (idx == -1 || idxColPa == -1) {
            return null;
        }
        cdService.get(idx).getChapter().remove(paModel);
        super.delete(paModel);
        collectionPartial.getAll().remove(idxColPa);
        collectionPartial.save(collectionPartial.getAll());
        return paModel;
    }

    public int idxColPartial(CDPartialModel paModel, CDModel cdModel) {
        int idx = -1;
        for (int i = 0; i < collectionPartial.getAll().size(); i++) {
            if (collectionPartial.getAll().get(i).getID().equalsIgnoreCase(cdModel.getId())
                    && collectionPartial.getAll().get(i).getPartialID().equalsIgnoreCase(paModel.getId())) {
                return i;
            }
        }
        return idx;
    }

    @Override
    public boolean add(CDPartialModel object) {
        throw new UnsupportedOperationException("Cannot add without have CDModel!!! Use addPartialModel(CDPartialModel paModel, CDModel cdModel) function to add");
    }

    @Override
    public CDPartialModel update(CDPartialModel object) {
        throw new UnsupportedOperationException("Not supported Yet.");

    }

    @Override
    public CDPartialModel delete(CDPartialModel object) {
        throw new UnsupportedOperationException("Cannot delete without have CDModel!!! Use deletePartialModel(CDPartialModel paModel, CDModel cdModel) function to delete");

    }

    public int getMaxCountPartial() {
        int max = 0;
        for (int i = 0; i < this.size(); i++) {
            int idx = Integer.parseInt(this.get(i).getId());
            if (idx > max) {
                max = idx;
            }
        }
        return max;
    }
}
