/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ICDHouseEntity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mytools.Singleton;

/**
 *
 * @author ASUS
 */
public abstract class AbstractCDHouseDao<T extends ICDHouseEntity> implements ICDDao<T> {

    protected Config config;
    protected String filePath;
    protected List<T> list;
    protected AbstractCDHouseDao(){
        list = new ArrayList();
        config = Singleton.getInstance(Config.class);
       
    }
    @Override
    public List<T> getAll(){
        return list;
    }

    @Override
    public boolean loadData(){
        try (Scanner sc = new Scanner(new File(this.filePath))) {
            T obj;
            String data;
            while (sc.hasNextLine()) {
                data = sc.nextLine();
                if (!data.isEmpty()) {
                    obj = toEntity(data);
                    if (obj != null) {
                        list.add(obj);
                    }
                }
            }
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return false;
    }

    @Override
    public boolean save(List<T> list){
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return false;
            }
            FileWriter fw = new FileWriter(file);//catch IOException here
            PrintWriter pw = new PrintWriter(fw);
            for (T t : list) {
                pw.println(toString(t));
            }
            pw.close();
            fw.close();
            return true;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public abstract T toEntity(String entity);
    
    public abstract String toString(T t);
}
