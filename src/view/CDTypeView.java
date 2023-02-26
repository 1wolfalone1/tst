/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.CDTypeModel;

/**
 *
 * @author ASUS
 */
public class CDTypeView {
    public final static String TABLE_FORMAT = "|%-5s|%-20s|";
    public final static String HEADER_FORMAT = "|%-5s|%-20s|";
    private CDTypeView(){
        
    }
   
    public void printCDView(CDTypeModel output){
        System.out.printf(TABLE_FORMAT + "\n", 
                output.getId(),
                output.getType());
    }
    public void printHeader(){
        System.out.printf(HEADER_FORMAT + "\n",
                            "ID",
                            "Type");
    }
}
