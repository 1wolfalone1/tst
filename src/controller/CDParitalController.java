/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import factory.CDHouseFactoryModel;
import mytools.Singleton;
import service.CDPartialService;
import view.CDPartialView;

/**
 *
 * @author ASUS
 */
public class CDParitalController {
    private CDPartialService cdPartialService = Singleton.getInstance(CDPartialService.class);
    private CDHouseFactoryModel factory= Singleton.getInstance(CDHouseFactoryModel.class);
    private CDPartialView parView = Singleton.getInstance(CDPartialView.class);
    private CDParitalController() {
        cdPartialService.load();
    }
    
    
}
