/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam.railway.dao.implementation;

import epam.railway.dao.interfaces.DaoTicketInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import epam.railway.entities.Ticket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

import epam.railway.manager.ConnectionPool;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author denis
 */
public class DaoTicket implements DaoTicketInterface{

    @Override
    public void addTicket(Integer userId, Integer trainId, Date date, Date timeTrain) {
        try {
            Connection connection = null;
            try {
                connection = ConnectionPool.createConnection();
                PreparedStatement preparedStatement = null;
                try {
                    Date ticketDate = new Date(date.getTime() + timeTrain.getTime() + 10800000);
                    System.out.println(timeTrain.getTime() + "============");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String currentTime = simpleDateFormat.format(ticketDate);
                    preparedStatement = connection.prepareStatement("INSERT INTO ticket (userid, trainid, date) VALUES (?,?,?)");
                    preparedStatement.setString(1, userId.toString());
                    preparedStatement.setString(2, trainId.toString());
                    System.out.println(currentTime + "============");
                    preparedStatement.setString(3, currentTime);
                    preparedStatement.executeUpdate();
                } finally {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                }
            } catch (NamingException ex) {
                Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public Ticket findById(Integer id) {
        Ticket ticket = null;       
        try {
            Connection connection = null;
            try {
                connection = ConnectionPool.createConnection();
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection.prepareStatement("SELECT * FROM ticket WHERE id = ?");
                    preparedStatement.setString(1, id.toString());
                    
                    ResultSet resultSet = null; 
                    try {
                        resultSet = preparedStatement.executeQuery();
                        ticket = new Ticket();
                        if(resultSet.next()){
                            ticket.setId(resultSet.getInt("id"));
                            ticket.setUserid(resultSet.getInt("userid"));
                            ticket.setTrainid(resultSet.getInt("trainid"));
                            ticket.setDate(new java.util.Date(resultSet.getTimestamp("date").getTime()));
                           
                        }
                    } finally {
                        if (resultSet != null) {
                            resultSet.close();
                        }
                    }
                } finally {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                }
            } catch (NamingException ex) {
                Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticket;
    }

    @Override
    public List<Ticket> findByUserid(Integer userId) {
        List<Ticket> list = new ArrayList();       
        try {
            Connection connection = null;
            try {
                connection = ConnectionPool.createConnection();
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection.prepareStatement("SELECT * FROM ticket JOIN train ON ticket.trainid = train.id WHERE userid = ?");
                    preparedStatement.setString(1, userId.toString());
                    
                    ResultSet resultSet = null; 
                    try {
                        resultSet = preparedStatement.executeQuery();
                        while(resultSet.next()){
                            Ticket ticket = new Ticket();
                            ticket.setId(resultSet.getInt("id"));
                            ticket.setUserid(resultSet.getInt("userid"));
                            ticket.setTrainid(resultSet.getInt("trainid"));
                            ticket.setDate(new java.util.Date(resultSet.getTimestamp("date").getTime()));
                            ticket.setDeparturecity(resultSet.getString("departurecity"));
                            ticket.setDestinationcity(resultSet.getString("destinationcity"));
                            list.add(ticket);
                        }
                    } finally {
                        if (resultSet != null) {
                            resultSet.close();
                        }
                    }
                } finally {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                }
            } catch (NamingException ex) {
                Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    @Override
    public void deleteById(Integer id) {
        try {
            Connection connection = null;
            try {
                connection = ConnectionPool.createConnection();
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection.prepareStatement("DELETE FROM ticket WHERE id=?");
                    preparedStatement.setString(1, id.toString());
                    preparedStatement.execute();
                } finally {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                }
            } catch (NamingException ex) {
                Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
