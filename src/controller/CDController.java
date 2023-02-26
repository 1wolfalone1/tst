/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import factory.CDHouseFactoryModel;
import java.util.List;
import model.CDModel;
import model.CDPartialModel;
import model.ICDHouseModel;
import mytools.MyTool;
import mytools.Singleton;
import service.CDPartialService;
import service.CDService;
import view.CDPartialView;
import view.CDView;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class CDController {

    private CDService cdService;
    private CDHouseFactoryModel factory = Singleton.getInstance(CDHouseFactoryModel.class);
    private CDView cdView = Singleton.getInstance(CDView.class);
    private CDPartialView parView = Singleton.getInstance(CDPartialView.class);
    private CDPartialService parService = Singleton.getInstance(CDPartialService.class);

    private CDController() {
        cdService = Singleton.getInstance(CDService.class);
        cdService.load();
    }

    public CDService getListCD() {
        return cdService;
    }

    public void setListCD(CDService listCD) {
        this.cdService = listCD;
    }

    public void addCD() {
        System.out.println("----------------------------------------------------------------------");
        CDModel cd = factory.createCD(CDModel.class);
        cd.input("Enter new CD");
        cdService.add(cd);
        System.out.println("Add successfully");
        System.out.println("----------------------------------------------------------------------");
    }

    public void printAllCD() {
        System.out.println("----------------------------------------------------------------------");
        int count = 0;
        for (int i = 0; i < cdService.size(); i++) {
            if (count++ == 0) {
                cdView.printHeader();
            }
            cdView.printCDView(cdService.get(i));
        }
        if (count == 0) {
            System.out.println("Not exist in list!!!");
        }
        System.out.println("----------------------------------------------------------------------");

    }

    public void printOptions(List<CDModel> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (count++ == 0) {
                cdView.printHeader();
            }
            cdView.printCDView(list.get(i));
        }
        if (count == 0) {
            System.out.println("Not exist in list!!!");
        }
    }

    public void searchByTitle() {
        String tmp = MyTool.inputStringWithRegex(".*", "Input title to search", null);
        List<CDModel> list = cdService.filter(tmp);
        if (list == null) {
            System.out.println("Not exist!!!");

        }
        printOptions(list);
    }

    public CDModel getCdByID(String mes) {
        String tmp = MyTool.inputStringWithRegex(".*", mes, null);
        return cdService.filterById(tmp);
    }

    public void printCatalog() {
        CDModel tmp = getCdByID("Input ID to search: ");
        if (tmp != null) {
            int count = 0;
            for (int i = 0; i < tmp.getChapter().size(); i++) {
                if (count++ == 0) {
                    parView.printHeader();
                }
                parView.printCDView(tmp.getChapter().get(i));
            }
            if (count == 0) {
                System.out.println("Not exist in list!!!");
            }
        } else {
            System.out.println("Not exist!!!");
        }
    }

    public void update() {
        String[] optionLIst = {"Update information", "Delete CD", "Update Chapter"};
        Menu menu = new Menu(optionLIst);
        int choice = 0;
        do {
            choice = menu.getChoice("Update CD");

            switch (choice) {
                case 1:
                    updateInfor();
                    break;
                case 2:
                    deleteInfor();
                    break;
                case 3:
                    updateChapter();
                    break;
                default:
                    System.out.println("Exist...");
            }
        } while (choice > 0 && choice <= menu.size());
    }

    public void updateInfor() {
        String tmp = MyTool.inputStringWithRegex(".*", "Input ID CD to update: ", null);
        CDModel update = cdService.filterById(tmp);
        if (update == null) {
            System.out.println("Not exist!!! Update fail");
        } else {
            update.update();
            cdService.update(update);
        }
    }

    public void deleteInfor() {
        String tmp = MyTool.inputStringWithRegex(".*", "Input ID CD to delete: ", null);
        CDModel update = cdService.filterById(tmp);
        if (update == null) {
            System.out.println("Not exist!!! Delete fail");
        } else {
            cdService.delete(update);
            System.out.println("Delete successful");
        }
    }

    public void updateChapter() {
        String[] optionLIst = {"Add new chapter", "Delete chapter"};
        Menu menu = new Menu(optionLIst);
        int choice = 0;
        do {
            choice = menu.getChoice("Update chapter");

            switch (choice) {
                case 1:
                    addNewChapter();
                    break;
                case 2:
                    deleteChapter();
                    break;
                default:
                    System.out.println("Exist...");
            }
        } while (choice > 0 && choice <= menu.size());
    }

    public void addNewChapter() {
        String tmp = MyTool.inputStringWithRegex(".*", "Input ID CD to update: ", null);
        CDModel update = cdService.filterById(tmp);
        if (update == null) {
            System.out.println("Not exist!!! Update fail");
        } else {
            CDPartialModel output = factory.createCD(CDPartialModel.class);
            output.input();
            parService.addPartialModel(output, update);
        }
    }

    public void deleteChapter() {
        String tmp = MyTool.inputStringWithRegex(".*", "Input ID CD to delete: ", null);
        CDModel update = cdService.filterById(tmp);
        if (update == null) {
            System.out.println("Not exist!!! Delete fail");
        } else {
            CDPartialModel output = factory.createCD(CDPartialModel.class);
            System.out.println("\nThere List of chapter: ");

            System.out.printf("|*Options");
            parView.printHeader();
            for (int i = 0; i < update.getChapter().size(); i++) {
                System.out.printf("|%-8s", String.valueOf(i + 1));
                parView.printCDView(update.getChapter().get(i));
            }

            int options = MyTool.inputInteger(1, parService.size(),
                    "Input option to delete: ", "Option doesn't exist!!! Try again: ");
            
                output = update.getChapter().get(options - 1);
                if(parService.deletePartialModel(output, update) == null){
                    System.out.println("Delete fail!!!");
                } else {
                    System.out.println("Delete successful!!!");
                }
        }
    }
}
