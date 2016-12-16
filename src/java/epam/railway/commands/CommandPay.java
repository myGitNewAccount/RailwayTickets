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
import epam.railway.manager.Config;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author denis
 */
public class CommandPay implements ICommand{
    private static final String TRAIN_ID = "trainid";
    private static final String USER_ID = "userid";
    private static final String TRAIN = "train";
    private static final String USER = "user";
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        String page = null;
        
        String trainId = request.getParameter(TRAIN_ID);
        Train train = DaoFactory.getDaoTrain().findById(Integer.parseInt(trainId));
        HttpSession session = request.getSession(false);
        Integer userId = (Integer) session.getAttribute(USER_ID);
        User user = DaoFactory.getDaoUser().findById(userId);
        
        request.setAttribute(USER, user);
        request.setAttribute(TRAIN, train);
       
        page = Config.getInstance().getProperty(Config.PAY_TICKET);
        return page;
    }
}
