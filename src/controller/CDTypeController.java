/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import factory.CDHouseFactoryModel;
import model.CDTypeModel;
import mytools.MyTool;
import mytools.Singleton;
import service.CDTypeService;
import view.CDTypeView;

/**
 *
 * @author ASUS
 */
public class CDTypeController {

    private CDTypeService cdTypeService = Singleton.getInstance(CDTypeService.class);
    private CDHouseFactoryModel factory = Singleton.getInstance(CDHouseFactoryModel.class);
    private CDTypeView typeView = Singleton.getInstance(CDTypeView.class);

    private CDTypeController() {
        cdTypeService.load();
    }

    public CDTypeModel lookupType() {
        CDTypeModel output = factory.createCD(CDTypeModel.class);
        System.out.println("\nThere List of title: ");

        System.out.printf("|*Options");
        typeView.printHeader();
        for (int i = 0; i < cdTypeService.size(); i++) {
            System.out.printf("|%-8s", String.valueOf(i + 1));
            typeView.printCDView(cdTypeService.get(i));
        }

        int options = MyTool.inputInteger(1, cdTypeService.size(),
                "Input option: ", "Option doesn't exist!!! Try again: ");
        try {
            output = cdTypeService.get(options - 1);
            return output;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public CDTypeModel lookupTypeUpdate() {
        CDTypeModel output = factory.createCD(CDTypeModel.class);
        System.out.println("\nThere List of title: ");

        System.out.printf("|*Options");
        typeView.printHeader();
        for (int i = 0; i < cdTypeService.size(); i++) {
            System.out.printf("|%-8s", String.valueOf(i + 1));
            typeView.printCDView(cdTypeService.get(i));
        }

        String options = MyTool.inputStringWithRegex(".*", "Choose your option: ", null);
        if (options.matches(CDTypeModel.BLANK_FORMAT)) {
            return null;
        }
        try {
            output = cdTypeService.get(Integer.parseInt(options) - 1);
            return output;
        } catch (Exception e) {
            return null;
        }
    }

}
