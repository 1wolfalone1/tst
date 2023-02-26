/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytools;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Singleton {
    private static final Map<Class, Object> mapInstance = new HashMap();

    synchronized public static <T> T getInstance(Class<T> clazz) {
        if (!Singleton.mapInstance.containsKey(clazz)) {
            try {
                Constructor<T> constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true);
                Singleton.mapInstance.put(clazz, constructor.newInstance());
            } catch (NoSuchMethodException
                    | SecurityException
                    | InstantiationException
                    | IllegalAccessException
                    | IllegalArgumentException
                    | InvocationTargetException ex) {
                Logger.getLogger(Singleton.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (T) Singleton.mapInstance.get(clazz);
    }

    private Singleton() {
    }
    

}
