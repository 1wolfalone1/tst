/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.CDPartialModel;

/**
 *
 * @author ASUS
 */
public class CDPartialView {
    public final static String TABLE_FORMAT = "|%-5s|%-20s|%-8s|";
    public final static String HEADER_FORMAT = "|%-5s|%-20s|%-8s|";
    private CDPartialView(){
        
    }
   
    public void printCDView(CDPartialModel output){
        System.out.printf(TABLE_FORMAT + "\n", 
                output.getId(),
                output.getName(),
                output.getCategory());
    }
    public void printHeader(){
        System.out.printf(HEADER_FORMAT + "\n",
                            "ID",
                            "Name",
                            "Category");
    }
}
