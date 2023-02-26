/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cd_house_program;

import controller.CDController;
import controller.CDParitalController;
import controller.CDTypeController;
import mytools.Singleton;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class CDHouseManagement {
    private CDTypeController cdTypeCon = Singleton.getInstance(CDTypeController.class);
    private CDController cdCon = Singleton.getInstance(CDController.class);
    private CDParitalController cdPartialCon = Singleton.getInstance(CDParitalController.class);

    private CDHouseManagement() {
    }

    public void addNewCD() {
       this.cdCon.addCD();
    }

    public void searchCDByTitle() {
        this.cdCon.searchByTitle();
    }

    public void displayTheCatalog() {
        this.cdCon.printCatalog();
    }

    public void updateCD() {
        this.cdCon.update();
    }

    public void PrintALL() {
        this.cdCon.printAllCD();
    }

    public static void main(String[] args) {
        
        CDHouseManagement cm = Singleton.getInstance(CDHouseManagement.class);
        String[] optionsList = {"ADD new CD", "Search CD by title",
            "Display the catalog", "Update CD", "Print all list CD from file"};
        Menu menu = new Menu(optionsList);
        int choice = 0;
        System.out.println("");
        do {
            choice = menu.getChoice("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Managing CD House~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            switch (choice) {
                case 1:
                    
                    cm.addNewCD();
                    break;
                case 2:
                    cm.searchCDByTitle();
                    break;
                case 3:
                    cm.displayTheCatalog();
                    break;
                case 4:
                    cm.updateCD();
                    break;
                case 5:
                    cm.PrintALL();
                    break;
                default:
                    System.out.println("=================================================================================");
                    System.out.println("Exit...");
                    break;
            }
        } while (choice > 0 && choice <= menu.size());
    }
}
