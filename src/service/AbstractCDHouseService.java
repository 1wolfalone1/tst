/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AbstractCDHouseDao;
import dto.CDEntity;
import dto.ICDHouseEntity;
import factory.CDHouseFactoryEntity;
import factory.CDHouseFactoryModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.CDModel;
import model.ICDHouseModel;
import mytools.MyTool;
import mytools.Singleton;

/**
 *
 * @author ASUS
 * @param <M>
 * @param <E>
 */
public abstract class AbstractCDHouseService<M extends ICDHouseModel, E extends ICDHouseEntity> extends ArrayList<M>
        implements ICDHouseService<M> {

    protected AbstractCDHouseDao dao;
    protected CDHouseFactoryModel factoryM;
    protected CDHouseFactoryEntity factoryE;
    protected Class<M> typeM;
    protected Class<E> typeE;

    protected AbstractCDHouseService() {
        factoryM = Singleton.getInstance(CDHouseFactoryModel.class);
        factoryE = Singleton.getInstance(CDHouseFactoryEntity.class);
    }

    @Override
    public int load() {
        if (!dao.loadData()) {
            return 0;
        }
        List<E> tmp = dao.getAll();
        for (int i = 0; i < tmp.size(); i++) {
            super.add(toModel(tmp.get(i)));
        }
        dao.getAll().clear();
        return tmp.size();
    }

    @Override
    public boolean save() {
        dao.getAll().clear();
        List<E> tmp = new ArrayList();
        for (int i = 0; i < this.size(); i++) {
            tmp.add(toEntity(this.get(i)));
        }
        return dao.save(tmp);
    }

    @Override
    public int indexOf(Object o) {
        int idx = -1;
        if (((M) o).getId() == null) {
            return idx;
        }
        for (int i = 0; i < size(); i++) {
            if (((M) o).getId().equalsIgnoreCase(get(i).getId())) {
                return i;
            }
        }
        return idx;
    }

    @Override
    public boolean add(M object) {
        if (this.indexOf(object) != -1) {

            return false;
        }
        if (object == null) {
            return false;
        }
        super.add(object);
        this.save();
        return true;

    }

    @Override
    public M update(M object) {
        int idx = indexOf(object);
        if (idx == -1) {
            return null;
        }
        this.set(idx, object);
        this.save();
        return object;
    }

    @Override
    public M delete(M object) {
        int idx = indexOf(object);
        if (idx == -1) {
            return null;
        }
        this.remove(idx);
        this.save();
        return object;
    }

    @Override
    public List<M> getModelList() {
        return this;
    }

    @Override
    public M filterById(String id) {
        M tmp = factoryM.createCD(typeM);
        tmp.setId(id);
        int idx = indexOf(tmp);
        if (idx == -1) {
            return null;
        } else {
            return this.get(idx);
        }

    }

    public boolean isExistID(String id) {
        return filterById(id) != null;
    }

    protected abstract E toEntity(M model);

    protected abstract M toModel(E entity);

}
