/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ICDHouseEntity;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ICDDao<T  extends ICDHouseEntity> {

    public List<T> getAll();

    public boolean loadData();

    public boolean save(List<T> list);

}
