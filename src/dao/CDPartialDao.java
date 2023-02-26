/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CDEntity;
import dto.CDPartialEntity;
import java.util.StringTokenizer;
import static javax.swing.text.html.HTML.Attribute.ID;

/**
 *
 * @author ASUS
 */
public class CDPartialDao extends AbstractCDHouseDao<CDPartialEntity> {

    private CDPartialDao() {
        this.filePath = config.getCDPartialFile();
    }

    @Override
    public CDPartialEntity toEntity(String attributes) {
        CDPartialEntity output;
        StringTokenizer stk = new StringTokenizer(attributes, ",");
        String partialID = stk.nextToken();
        String name = stk.nextToken();
        String category = stk.nextToken();
        output = new CDPartialEntity(partialID, name, category);
        return output;
      
    }

    @Override
    public String toString(CDPartialEntity t) {
        return t.toString();
    }

}
