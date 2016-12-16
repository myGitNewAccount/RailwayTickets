/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam.railway.commands;

import epam.railway.dao.daofactory.DaoFactory;
import epam.railway.entities.User;
import epam.railway.locale.LangService;
import epam.railway.manager.Config;
import epam.railway.manager.Message;
import epam.railway.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;

import javax.security.auth.login.LoginException;
import org.apache.log4j.Logger;



/**
 *
 * @author denis
 */
public class CommandLogin implements ICommand{
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String LANGUAGE = "language";
    private static final String ENGLISH = "en";
    private static final String RUSSIAN = "ru";
    private static final String USER_ID = "userid";
    private static final String TRAINS = "trains";
    private static final String ERROR = "error";
    private static final String ADMIN_RIGHTS = "adminrights";
     
    private static Logger log = Logger.getLogger(CommandLogin.class.getName());
    
    
   // static final Logger userLogger = LogManager.getLogger(User.class);
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
        
        String page = null;
        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);
        
        User user;
        try {
            
            
            user = UserService.findUser(email, password);
            log.info("User login: id = " + user.getId() + ", email = " + user.getEmail());
            
            HttpSession session = request.getSession(true);
            session.setAttribute(USER_ID, user.getId());
            session.setAttribute(LANGUAGE, ENGLISH);
            
            if(user.getAdminid() == 1){
                session.setAttribute(ADMIN_RIGHTS, true);
            }
            
            String lang = (String) session.getAttribute(LANGUAGE);
            LangService.setOrderFormAttributes(session, request);
            //LangService.setUserPanelAttributes(session, request);
            request.setAttribute(TRAINS, null);
            page = Config.getInstance().getProperty(Config.ORDER);
            
        } catch (LoginException ex) {
            request.setAttribute(ERROR, ex.getMessage());
            page = Config.getInstance().getProperty(Config.ERROR);
            //Logger.getLogger(CommandLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return page;
    }
}
