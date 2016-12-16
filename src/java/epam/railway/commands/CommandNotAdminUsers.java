/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam.railway.commands;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import epam.railway.dao.daofactory.DaoFactory;
import epam.railway.entities.User;
import epam.railway.locale.LangService;
import epam.railway.manager.Config;
import epam.railway.service.UserService;

/**
 *
 * @author denis
 */
public class CommandNotAdminUsers implements ICommand{
    private static final String LANGUAGE = "language";
    private static final String ADMIN_RIGHTS = "adminrights";
    private static final String USERS = "users";
    private static final String ERROR = "error";
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        String page;
        HttpSession session = request.getSession(false);
        Boolean isAdmin = (Boolean)session.getAttribute(ADMIN_RIGHTS);
        try {
            List<User> users = UserService.findNotAdminUsers(isAdmin);
            request.setAttribute(USERS, users);
            
            LangService.setUserPanelAttributes(session, request);
            LangService.setUserSettingsFormAttributes(session, request);
            page = Config.getInstance().getProperty(Config.ADMINISTRATE);
            
        } catch (SecurityException ex) {
            request.setAttribute(ERROR, ex.getMessage());
            page = Config.getInstance().getProperty(Config.ERROR);
        }

        return page;
    }
  
}
