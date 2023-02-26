/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CDCollectionPartialEntity;
import java.util.StringTokenizer;

/**
 *
 * @author ASUS
 */
public class CDCollectionPartialDao extends AbstractCDHouseDao<CDCollectionPartialEntity> {

    private CDCollectionPartialDao() {
        this.filePath = config.getCollectionPartialFile();
    }

    @Override
    public CDCollectionPartialEntity toEntity(String attributes) {
        CDCollectionPartialEntity output;
        StringTokenizer stk = new StringTokenizer(attributes, ",");
        String cdID = stk.nextToken();
        String partialID = stk.nextToken();
        output = new CDCollectionPartialEntity(cdID, partialID);
        return output;
    }

    @Override
    public String toString(CDCollectionPartialEntity t) {
        return t.toString();
    }

}
