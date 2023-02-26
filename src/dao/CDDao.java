/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CDCollectionPartialEntity;
import dto.CDEntity;
import java.util.StringTokenizer;

/**
 *
 * @author ASUS
 */
public class CDDao extends AbstractCDHouseDao<CDEntity> {

    private CDDao() {
        this.filePath = config.getCDFile();
    }

    @Override
    public CDEntity toEntity(String attributes) {
        CDEntity output;
        StringTokenizer stk = new StringTokenizer(attributes, ",");
        String ID = stk.nextToken();
        String title = stk.nextToken();
        String typeID = stk.nextToken();
        String unitPrice = stk.nextToken();
        String publishYear = stk.nextToken();
        output = new CDEntity(ID, title, typeID, unitPrice, publishYear);
        return output;
    }

    @Override
    public String toString(CDEntity t) {
       return t.toString();
    }

}
