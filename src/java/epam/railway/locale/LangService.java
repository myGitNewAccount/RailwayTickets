/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam.railway.locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author denis
 */
public class LangService {
    
    private static final String LANGUAGE = "language";
    private static final String MY_TICKETS = "mytickets";
    private static final String EXIT = "exit";
    private static final String ADMINISTRATE = "administrate";
    private static final String SETTINGS = "settings";
    private static final String FIND_TICKETS = "findtickets";
    private static final String FROM = "from";
    private static final String TO = "to";
    public static final String INTERFACE_LANGUAGE = "interfacelanguage";
    public static final String SAVE = "save";
    public static final String TRAIN_DIRECTION = "traindirection";
    public static final String DEPARTURE_TIME = "departuretime";
    public static final String ARRIVAL_TIME = "arrivaltime";
    public static final String TRAVEL_TIME = "traveltime";
    public static final String TICKET_PRICE = "ticketprice";
    
    
    public static void setUserPanelAttributes(HttpSession session, HttpServletRequest request){
        String lang = (String)session.getAttribute(LANGUAGE);
        request.setAttribute(MY_TICKETS, Lang.getInstance(lang).getProperty(Lang.MY_TICKETS));
        request.setAttribute(EXIT, Lang.getInstance(lang).getProperty(Lang.EXIT));
        request.setAttribute(ADMINISTRATE, Lang.getInstance(lang).getProperty(Lang.ADMINISTRATE));
        request.setAttribute(SETTINGS, Lang.getInstance(lang).getProperty(Lang.SETTINGS));
    }
    
    public static void setOrderFormAttributes(HttpSession session, HttpServletRequest request){
        String lang = (String)session.getAttribute(LANGUAGE);
        request.setAttribute(FIND_TICKETS, Lang.getInstance(lang).getProperty(Lang.FIND_TICKETS));
        request.setAttribute(FROM, Lang.getInstance(lang).getProperty(Lang.FROM));
        request.setAttribute(TO, Lang.getInstance(lang).getProperty(Lang.TO));
        
    }
    
    public static void setUserSettingsFormAttributes(HttpSession session, HttpServletRequest request){
        String lang = (String)session.getAttribute(LANGUAGE);
        request.setAttribute(INTERFACE_LANGUAGE, Lang.getInstance(lang).getProperty(Lang.INTERFACE_LANGUAGE));
        request.setAttribute(SAVE, Lang.getInstance(lang).getProperty(Lang.SAVE));
    }
    
    public static void setTrainBlockAttributes(HttpSession session, HttpServletRequest request){
        String lang = (String)session.getAttribute(LANGUAGE);
        request.setAttribute(TRAIN_DIRECTION, Lang.getInstance(lang).getProperty(Lang.TRAIN_DIRECTION));
        request.setAttribute(DEPARTURE_TIME, Lang.getInstance(lang).getProperty(Lang.DEPARTURE_TIME));
        request.setAttribute(ARRIVAL_TIME, Lang.getInstance(lang).getProperty(Lang.ARRIVAL_TIME));
        request.setAttribute(TRAVEL_TIME, Lang.getInstance(lang).getProperty(Lang.TRAVEL_TIME));
        request.setAttribute(TICKET_PRICE, Lang.getInstance(lang).getProperty(Lang.TICKET_PRICE));
    }
    
}
