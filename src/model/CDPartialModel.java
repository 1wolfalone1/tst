/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import mytools.MyTool;

/**
 *
 * @author ASUS
 */
public class CDPartialModel extends AbstractCDHouseModel {
    
    public final static String FORMAT_ID = ".*";
    
    private String name;
    private String category;
    
    public CDPartialModel() {
    }
    
    public String getName() {
        
        return name;
    }
    
    public void setName(String name) {
        if (validName(name)) {
            this.name = name;
        }
        
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        if (validCategory(category)) {
            this.category = category;
        }
    }
    
    @Override
    public boolean validID(String id) {
        return true;
    }
    
    public boolean validName(String name) {
        return MyTool.valideString(name, ".*", null, true);
    }
    
    public boolean validCategory(String category) {
        return MyTool.valideString(name, ".*", null, true);
    }
    
    public void input() {
        setName(MyTool.inputStringWithRegex(FORMAT_NOT_BLANK, "Input name of partial: ", "Invalid!!! Try again: "));
        setCategory(MyTool.inputStringWithRegex(FORMAT_NOT_BLANK, "Input category of partial: ", "Invalid!!! Try again: "));
    }
}
