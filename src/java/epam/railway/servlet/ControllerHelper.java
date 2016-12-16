/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam.railway.servlet;

import epam.railway.commands.CommandLogout;
import epam.railway.commands.ICommand;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

import epam.railway.commands.CommandBuyTicket;
import epam.railway.commands.CommandDeleteTicket;
import epam.railway.commands.CommandDeleteUser;
import epam.railway.commands.CommandFindTickets;
import epam.railway.commands.CommandLogin;
import epam.railway.commands.CommandMissing;
import epam.railway.commands.CommandNotAdminUsers;
import epam.railway.commands.CommandOrder;
import epam.railway.commands.CommandPay;
import epam.railway.commands.CommandSettings;
import epam.railway.commands.CommandSettingsSave;
import epam.railway.commands.CommandSignUp;
import epam.railway.commands.CommandUserTickets;

/**
 *
 * @author denis
 */
public class ControllerHelper {
    private static ControllerHelper instance = null;
    HashMap<String, ICommand> commands = new HashMap<>();

    public ControllerHelper() {
        commands.put("order", new CommandOrder());
        commands.put("findtickets", new CommandFindTickets());
        commands.put("login", new CommandLogin());
        commands.put("signup", new CommandSignUp());
        commands.put("pay", new CommandPay());
        commands.put("buyticket", new CommandBuyTicket());
        commands.put("usertickets", new CommandUserTickets());
        commands.put("logout", new CommandLogout());
        commands.put("administration", new CommandNotAdminUsers());
        commands.put("deleteticket", new CommandDeleteTicket());
        commands.put("deleteuser", new CommandDeleteUser());
        commands.put("settings", new CommandSettings());
        commands.put("settingssave", new CommandSettingsSave());
    }

    public ICommand getCommand(HttpServletRequest request) {
        ICommand command = commands.get(request.getParameter("command"));
        if (command == null) {
            command = new CommandMissing();
        }
        return command;
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {
            instance = new ControllerHelper();
        }
        return instance;
    }
}
 