/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.CDController;
import controller.CDTypeController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mytools.MyTool;
import mytools.Singleton;

/**
 *
 * @author ASUS
 */
public class CDModel extends AbstractCDHouseModel {

    public final static String FORMAT_ID = "CD\\d{3}";
    public final static String FORMAT_DATE = "dd/MM/yyyy";
    private String title;
    private List<CDPartialModel> chapter = new ArrayList();
    private CDTypeModel type;
    private double unitPrice;
    private Date publishYear;

    public CDModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (validTitle(title)) {
            this.title = title;
        }
    }

    public List<CDPartialModel> getChapter() {
        return chapter;
    }

    public void setChapter(List<CDPartialModel> chapter) {
        if (chapter != null) {
            this.chapter = chapter;
        }
    }

    public void setChapter(CDPartialModel unitChapter) {
        if (unitChapter != null) {
            this.chapter.add(unitChapter);
        } 
    }

    public CDTypeModel getTypeModel() {
        return type;
    }

    public void setType(CDTypeModel type) {
        if (type != null) {
            this.type = type;
        } 
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        if (validUnitPrice(unitPrice)) {
            this.unitPrice = unitPrice;
        }
    }

    public Date getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Date publishYear) {
        if (validPubYear(publishYear)) {
            this.publishYear = publishYear;
        }
    }

    @Override
    public boolean validID(String id) {
        return MyTool.valideString(id, FORMAT_ID, null, true);
    }

    public boolean validPubYear(Date input) {
        return MyTool.checkDate(input, null, new Date());
    }

    public boolean validUnitPrice(Double input) {
        return MyTool.valideDouble(input, 0, Double.MAX_VALUE, null);
    }

    public boolean validTitle(String title) {
        return MyTool.valideString(title, FORMAT_NOT_BLANK, null, true);
    }

    public String inputID(boolean checkList) {
        System.out.print("Input CD ID: ");
        String ID;
        while (true) {
            ID = MyTool.inputStringWithRegex(FORMAT_ID, null,
                    "Invalid!!! ID's format is 'CDxxx' with 'x' is digit\nTry again: ");
            if (checkList) {
                if (!Singleton.getInstance(CDController.class).getListCD().isExistID(ID)) {
                    break;
                }
                System.out.print("Duplicated ID!!!\nTry again: ");
            } else {
                break;
            }
        }
        return ID;
    }

    public String inputTitle() {
        return MyTool.inputStringWithRegex(FORMAT_NOT_BLANK, "Input name: ",
                "Invalid!!! CD title must be not blank .\nTry again: ");
    }

    public double inputUnitPrice() {
        return MyTool.inputDouble(0, Double.MAX_VALUE,
                "Input price: ",
                "Invalid!!! Price can't be negative.\nTry again: ");
    }

    public Date inputPublishYear() {
        return MyTool.inputDate(new Date(), null, FORMAT_DATE,
                "Input publish date: ", "Invalid date or wrong format(dd/MM/yyyy)!!! Try again: ");
    }

    public CDTypeModel inputType() {
        CDTypeModel tmp = new CDTypeModel();
        tmp.input();
        return tmp;
    }

    public void addChapter() {
        System.out.println("Add new chapter to CD: ");
        CDPartialModel tmp = new CDPartialModel();
        tmp.input();
        chapter.add(tmp);
        System.out.println("Add new Chapter successful.");
    }

    public void input(String message) {
        System.out.println(message);
        setId(this.inputID(true));
        setTitle(this.inputTitle());
        CDTypeModel a = this.inputType();
        setType(a);
        setPublishYear(this.inputPublishYear());
        setUnitPrice(this.inputUnitPrice());
    }

    

    public void update(){
        String newTitile = updateTitle();
        CDTypeModel newType = updateType();
        Double newPrice = updateUnitprice();
        Date newDate = updatePubishYear();
        if(newTitile != null){
            setTitle(newTitile);
        }
        if(newType != null){
            setType(newType);
        }
        if(newPrice != null){
            setUnitPrice(newPrice);
        }
        if(newDate != null){
            setPublishYear(newDate);
        }
    }
    public String updateTitle() {
        while (true) {
            String tmp = MyTool.inputStringWithRegex(FORMAT_NOT_BLANK + "|" + BLANK_FORMAT,
                    "Input new title or blank to skip: ", null);
            if (tmp.matches(BLANK_FORMAT)) {
                break;
            } else {
                return tmp;
            }
        }
        return null;
    }

    public Double updateUnitprice() {
        System.out.print("Input new price or blank to skip: ");
        while (true) {
            String tmp = MyTool.inputStringWithRegex(".*", null, null);

            if (tmp.matches(BLANK_FORMAT)) {
                break;
            } else if (MyTool.isDouble(tmp)) {
                if (MyTool.valideDouble(Integer.valueOf(tmp), 0, Double.MAX_VALUE, "Invalid!!! Price can't negative:   ")) {
                    return Double.valueOf(tmp);
                }
            } else {
                System.out.print("Invalid!!! Not a double\nTry again: ");
            }
        }
        return null;
    }

    public Date updatePubishYear() {
        System.out.print("Input new PubishYear or blank to skip: ");
        while (true) {
            String tmp = MyTool.inputStringWithRegex(".*", null, null);
            try {
                Date date = MyTool.convertToDate(tmp, FORMAT_DATE);
                if (tmp.matches(BLANK_FORMAT)) {
                    break;
                } else if (validPubYear(date)) {
                    return date;
                } else {
                    System.out.print("Invalid!!! Try again: ");
                }
            } catch (Exception e) {
                System.out.print("Invalid date!!! Try again: ");
            }

        }
        return null;
    }
    
    public CDTypeModel updateType(){
       CDTypeModel tmp = new CDTypeModel();
        tmp.update();
        return tmp;
    }

}
