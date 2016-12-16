/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam.railway.dao.implementation;

import epam.railway.dao.interfaces.DaoTrainInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import epam.railway.entities.Train;
import epam.railway.manager.ConnectionPool;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author denis
 */
public class DaoTrain implements DaoTrainInterface{

    @Override
    public List findByDeparturecityAndDestinationcity(String departureCity, String destinationCity) {
        List<Train> list = new ArrayList();
        try {
            Connection connection = null;
            try {
                connection = ConnectionPool.createConnection();
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection.prepareStatement("SELECT * FROM train WHERE departurecity = ? AND destinationcity = ?");
                    preparedStatement.setString(1, departureCity);
                    preparedStatement.setString(2, destinationCity);
                    
                    ResultSet resultSet = null; 
                    try {
                        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                        resultSet = preparedStatement.executeQuery();
                        while(resultSet.next()){
                            Train train = new Train();
                            train.setId(resultSet.getInt("id"));
                            train.setDeparturecity(resultSet.getString("departurecity"));
                            train.setDestinationcity(resultSet.getString("destinationcity"));
                            System.out.println("========" + resultSet.getString("departuretime"));
                            train.setDeparturetime(formatter.parse(resultSet.getString("departuretime")));
                            train.setArrivaltime(formatter.parse(resultSet.getString("arrivaltime")));
                            train.setTraveltime(new Date(train.getArrivaltime().getTime() - train.getDeparturetime().getTime() - 10800000));
                            train.setPrice(resultSet.getDouble("price"));
                            System.out.println("Train  +  " + train.getId());
                            list.add(train);
                        }
                    } catch (ParseException ex) {
                        System.out.println("Блин");
                        Logger.getLogger(DaoTrain.class.getName()).log(Level.SEVERE, null, ex);
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
    public Train findById(Integer id) {
        Train train = null;       
        try {
            Connection connection = null;
            try {
                connection = ConnectionPool.createConnection();
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection.prepareStatement("SELECT * FROM train WHERE id = ?");
                    preparedStatement.setString(1, id.toString());
                    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                    ResultSet resultSet = null; 
                    try {
                        resultSet = preparedStatement.executeQuery();
                        train =  new Train();
                        if(resultSet.next()){
                            train.setId(resultSet.getInt("id"));
                            train.setDeparturecity(resultSet.getString("departurecity"));
                            train.setDestinationcity(resultSet.getString("destinationcity"));
                            train.setDeparturetime(formatter.parse(resultSet.getString("departuretime")));
                            train.setArrivaltime(formatter.parse(resultSet.getString("arrivaltime")));
                            train.setTraveltime(new Date(train.getArrivaltime().getTime() - train.getDeparturetime().getTime() - 10800000));
                            train.setPrice(resultSet.getDouble("price"));
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(DaoTrain.class.getName()).log(Level.SEVERE, null, ex);
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
        return train;
    }
    
}
