/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import mytools.MyTool;

/**
 *
 * @author ASUS
 */
public class Config {

//File of CD: CD.txt
//File of CDType: CDType.txt
//File of CollectionPartial:  CollectionPartial.txt
//File of CDPartial:  CDPartial.txt
    private static final String CONFIG_PATH_FILE = "CDManagement\\config.txt";
    private String CDFile;
    private String CDTypeFile;
    private String CollectionPartialFile;
    private String CDPartialFile;

    private Config() {

        readData();
    }

    private void readData() {
        List<String> lines = MyTool.readFileInLine(CONFIG_PATH_FILE);
        for (String line : lines) {
            line = line.toLowerCase();
            String[] parts = line.split(":");
            if (line.indexOf("CDFile".toLowerCase()) >= 0) {
                CDFile = "CDManagement\\" + parts[1].trim();// part[1] is name of file
            } else if (line.indexOf("CDTypeFile".toLowerCase()) >= 0) {
                CDTypeFile = "CDManagement\\" + parts[1].trim();
            } else if (line.indexOf("CollectionPartialFile".toLowerCase()) >= 0) {
                CollectionPartialFile = "CDManagement\\" + parts[1].trim();
            } else if (line.indexOf("CDPartialFile".toLowerCase()) >= 0) {
                CDPartialFile = "CDManagement\\" + parts[1].trim();
            }
        }
    }

    public static String getCONFIG_PATH_FILE() {
        return CONFIG_PATH_FILE;
    }

    public String getCDFile() {
        return CDFile;
    }

    public String getCDTypeFile() {
        return CDTypeFile;
    }

    public String getCollectionPartialFile() {
        return CollectionPartialFile;
    }

    public String getCDPartialFile() {
        return CDPartialFile;
    }

}
