/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.ICDHouseModel;

/**
 *
 * @author ASUS
 * @param <M>
 */
public interface ICDHouseService<M extends ICDHouseModel> {
    
    public int load();

    public boolean save();

    public boolean add(M object);

    public M update(M object);

    public M delete(M object);

    public List<M> getModelList();

    public M filterById(String id);

}
