/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Scanner;
import mytools.MyTool;

/**
 *
 * @author ASUS
 */
public class Menu extends ArrayList<String> {

    public Menu() {
        super();
    }

    /**
     *
     * @param options
     */
    public Menu(String[] options) {
        super();
        for (String option : options) {
            this.add(option);
        }
    }

    /**
     * Print out option for users and return number that user's chosen
     *
     * @param title
     * @return
     */
    public int getChoice(String title) {
        System.out.println(title);
        for (int i = 1; i <= this.size(); i++) {
            System.out.println(i + ". " + this.get(i - 1));
        }
        System.out.println("Other- Quit.");
        Scanner sc = new Scanner(System.in);
        //temporary variable to store output of function
        int temp = MyTool.inputInteger(Integer.MIN_VALUE, Integer.MAX_VALUE,
                "Type your option: ", null);
        return temp;
    }
}
