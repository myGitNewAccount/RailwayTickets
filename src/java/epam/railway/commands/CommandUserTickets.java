/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam.railway.commands;

import java.io.IOException;
import epam.railway.dao.daofactory.DaoFactory;
import epam.railway.entities.Ticket;
import epam.railway.locale.Lang;
import epam.railway.locale.LangService;
import epam.railway.manager.Config;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author denis
 */
public class CommandUserTickets implements ICommand{
    private static final String USER_ID = "userid";
    private static final String TICKETS = "tickets";
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        String page = null;
        HttpSession session = request.getSession(false);
        Integer userId = (Integer)session.getAttribute(USER_ID);
        
        LangService.setUserPanelAttributes(session, request);
        
        List<Ticket> tickets = DaoFactory.getDaoTicket().findByUserid(userId);
        request.setAttribute(TICKETS, tickets);
        page = Config.getInstance().getProperty(Config.USER_TICKETS);
        return page;
    }
    
}
