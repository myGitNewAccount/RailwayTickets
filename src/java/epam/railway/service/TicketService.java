/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam.railway.service;

import epam.railway.commands.CommandLogin;
import epam.railway.dao.daofactory.DaoFactory;
import epam.railway.entities.Train;
import epam.railway.manager.Message;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityNotFoundException;
import org.apache.log4j.Logger;

/**
 *
 * @author denis
 */
public class TicketService {
    
    private static final Logger log = Logger.getLogger(TicketService.class.getName());
    private static final String FORMAT = "dd-MM-yyyy";
    
    public static void addTicket(Integer userId, Integer trainId, String dateString) throws ParseException{
        
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT);
        Date date = formatter.parse(dateString);
        Train train = DaoFactory.getDaoTrain().findById(trainId);
        
        if(train != null){
            DaoFactory.getDaoTicket().addTicket(userId, train.getId(), date, train.getDeparturetime());
        } else {
            throw new EntityNotFoundException(Message.getInstance().getProperty(Message.TRAIN_NOT_EXIST));
        }
        
    }
    
    public static void deleteTicket(Integer ticketId) {
        DaoFactory.getDaoTicket().deleteById(ticketId);
        log.info("Remove ticket: ticketId = " + ticketId);
    }
    
}
