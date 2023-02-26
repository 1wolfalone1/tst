/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CDPartialEntity;
import dto.CDTypeEntity;
import java.util.StringTokenizer;

/**
 *
 * @author ASUS
 */
public class CDTypeDao extends AbstractCDHouseDao<CDTypeEntity> {

    private CDTypeDao() {
        this.filePath = config.getCDTypeFile();
    }

    @Override
    public CDTypeEntity toEntity(String attributes) {
        CDTypeEntity output;
        StringTokenizer stk = new StringTokenizer(attributes, ",");
        String ID = stk.nextToken();
        String type = stk.nextToken();
        output = new CDTypeEntity(ID, type);
        return output;
    }

    @Override
    public String toString(CDTypeEntity t) {
        return t.toString();
    }

}
