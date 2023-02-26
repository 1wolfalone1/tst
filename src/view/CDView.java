/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.CDModel;
import mytools.MyTool;

/**
 *
 * @author ASUS
 */
public class CDView {
    public final static String TABLE_FORMAT = "|%-5s|%-20s|%-7.1f|%-12s|%-13s|";
    public final static String HEADER_FORMAT = "|%-5s|%-20s|%-7s|%-12s|%-13s|";
    private CDView(){
        
    }
   
    public void printCDView(CDModel output){
        System.out.printf(TABLE_FORMAT + "\n", 
                output.getId(),
                output.getTitle(),
                output.getUnitPrice(),
                MyTool.convertDateToString(output.getPublishYear(), CDModel.FORMAT_DATE),
                output.getTypeModel().getType());
    }
    public void printHeader(){
        System.out.printf(HEADER_FORMAT + "\n",
                            "ID",
                            "Title",
                            "Price",
                            "Publish Year",
                            "Type");
    }
}
