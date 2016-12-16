/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam.railway.commands;

import java.io.IOException;
import epam.railway.dao.daofactory.DaoFactory;
import epam.railway.locale.Lang;
import epam.railway.locale.LangService;
import epam.railway.manager.Config;
import epam.railway.manager.Message;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author denis
 */
public class CommandOrder implements ICommand{
    
    private static final String USER_ID = "userid";
    private static final String ERROR = "error";
    private static final String DEPARTURE_CITY = "departurecity";
    private static final String DESTINATION_CITY = "destinationcity";
    private static final String TRAINS = "trains";
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        String page = null;
        HttpSession session = request.getSession(false);
        Integer userId = (Integer)session.getAttribute(USER_ID);
        if(userId != null){
            
            LangService.setOrderFormAttributes(session, request);
            
            String departureCity = request.getParameter(DEPARTURE_CITY);
            String destinationCity = request.getParameter(DESTINATION_CITY);
            
            List list = DaoFactory.getDaoTrain().findByDeparturecityAndDestinationcity(departureCity, destinationCity);
           
            if (list.size() != 0 ) { //??????????????????????????
               
                request.setAttribute(TRAINS, list);
                request.setAttribute(DEPARTURE_CITY, departureCity);
                request.setAttribute(DESTINATION_CITY, destinationCity);
                LangService.setTrainBlockAttributes(session, request);
                page = Config.getInstance().getProperty(Config.ORDER);
                
            } else {
                request.setAttribute(ERROR, Message.getInstance().getProperty(Message.NO_TRAINS));
                page = Config.getInstance().getProperty(Config.ORDER);
            }
        }else{
            page = Config.getInstance().getProperty(Config.LOGIN);
        }
        return page;
    }
}
