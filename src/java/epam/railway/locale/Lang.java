/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam.railway.locale;

import java.util.ResourceBundle;

/**
 *
 * @author denis
 */
public class Lang {
    
    private static Lang instance;
    private ResourceBundle resource;
    
    private static final String LANG_EN = "epam.railway.locale.langEn";
    private static final String LANG_RU = "epam.railway.locale.langRu";
    public static final String EN = "en";
    public static final String RU = "ru";

    public static final String MY_TICKETS = "MY_TICKETS";
    public static final String ADMINISTRATE = "ADMINISTRATE";
    public static final String FROM = "FROM";
    public static final String TO = "TO";
    public static final String EXIT = "EXIT";
    public static final String FIND_TICKETS = "FIND_TICKETS";
    public static final String SETTINGS = "SETTINGS";
    public static final String INTERFACE_LANGUAGE = "INTERFACE_LANGUAGE";
    public static final String SAVE = "SAVE";
    public static final String TRAIN_DIRECTION = "TRAIN_DIRECTION";
    public static final String DEPARTURE_TIME = "DEPARTURE_TIME";
    public static final String ARRIVAL_TIME = "ARRIVAL_TIME";
    public static final String TRAVEL_TIME = "TRAVEL_TIME";
    public static final String TICKET_PRICE = "TICKET_PRICE";


    public static Lang getInstance(String lang) {
        instance = new Lang();
        if(RU.equals(lang)){
            instance.resource = ResourceBundle.getBundle(LANG_RU);
        } else instance.resource = ResourceBundle.getBundle(LANG_EN);
            
        return instance;
    }

    public String getProperty(String key) {
        return (String) resource.getObject(key);
    }
}
