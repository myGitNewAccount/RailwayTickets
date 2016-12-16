/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam.railway.commands;

import java.io.IOException;
import epam.railway.dao.daofactory.DaoFactory;
import epam.railway.entities.Train;
import epam.railway.entities.User;
import epam.railway.locale.LangService;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import epam.railway.manager.Config;
import epam.railway.service.TicketService;
import epam.railway.service.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author denis
 */
public class CommandBuyTicket implements ICommand{
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(CommandBuyTicket.class.getName());
    private static final String TRAIN_ID = "trainid";
    private static final String DATE = "date";
    private static final String USER_ID = "userid";
    private static final String ERROR = "error";
    
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        String page = null;
        
        HttpSession session = request.getSession(false);
        String dateString = request.getParameter(DATE);
        Integer trainId = Integer.parseInt(request.getParameter(TRAIN_ID));
        Integer userId = (Integer) session.getAttribute(USER_ID);
        
        try {

            TicketService.addTicket(userId, trainId, dateString);
            LangService.setOrderFormAttributes(session, request);
            LangService.setUserPanelAttributes(session, request);
            page = Config.getInstance().getProperty(Config.ORDER);
            log.info("New ticket: userid=" + userId + ", trainid=" + trainId);
        
        } catch (ParseException ex) {
            Logger.getLogger(CommandBuyTicket.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (EntityNotFoundException ex) {
            request.setAttribute(ERROR, ex.getMessage());
            page = Config.getInstance().getProperty(Config.ERROR);
            
        }

        return page;
    }
    
}
