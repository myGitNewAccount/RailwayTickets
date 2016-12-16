/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam.railway.dao.implementation;

import epam.railway.dao.interfaces.DaoUserInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import epam.railway.entities.Train;
import epam.railway.entities.User;
import epam.railway.manager.ConnectionPool;

/**
 *
 * @author denis
 */
public class DaoUser implements DaoUserInterface {

    @Override
    public User findByEmailAndPassword(String email, String password) {
        User user = null;       
        try {
            Connection connection = null;
            try {
                connection = ConnectionPool.createConnection();
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
                    preparedStatement.setString(1, email);
                    preparedStatement.setString(2, password);
                 
                    ResultSet resultSet = null;
                    try {
                        resultSet = preparedStatement.executeQuery();
                        if(resultSet.next()){
                            user = new User();
                            user.setId(resultSet.getInt("id"));
                            user.setAdminid(resultSet.getInt("adminid"));
                            user.setFirstname(resultSet.getString("firstname"));
                            user.setLastname(resultSet.getString("lastname"));
                            user.setEmail(resultSet.getString("email"));
                            user.setPassword(resultSet.getString("password"));
                            return user;
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
        return user;
    }
    
    @Override
    public User findById(Integer id) {
        User user = null;       
        try {
            Connection connection = null;
            try {
                connection = ConnectionPool.createConnection();
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE id = ?");
                    preparedStatement.setString(1, id.toString());
                 
                    ResultSet resultSet = null;
                    try {
                        resultSet = preparedStatement.executeQuery();
                        if(resultSet.next()){
                            user = new User();
                            user.setId(resultSet.getInt("id"));
                            user.setAdminid(resultSet.getInt("adminid"));
                            user.setFirstname(resultSet.getString("firstname"));
                            user.setLastname(resultSet.getString("lastname"));
                            user.setEmail(resultSet.getString("email"));
                            user.setPassword(resultSet.getString("password"));
                            return user;
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
        return user;
    }
    
    @Override
    public void addUser(String firstname, String lastname, String email, String password) {     
        try {
            Connection connection = null;
            try {
                connection = ConnectionPool.createConnection();
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection.prepareStatement("INSERT INTO user (firstname, lastname, email, password) VALUES (?,?,?,?)");
                    preparedStatement.setString(1, firstname);
                    preparedStatement.setString(2, lastname);
                    preparedStatement.setString(3, email);
                    preparedStatement.setString(4, password);
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
    public List<User> findAllNotAdmin() {
        List<User> list = new ArrayList();
        try {
            Connection connection = null;
            try {
                connection = ConnectionPool.createConnection();
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE adminid IS NULL");
                    
                    ResultSet resultSet = null; 
                    try {
                        resultSet = preparedStatement.executeQuery();
                        while(resultSet.next()){
                            User user = new User();
                            user.setId(resultSet.getInt("id"));
                            user.setAdminid(resultSet.getInt("adminid"));
                            user.setFirstname(resultSet.getString("firstname"));
                            user.setLastname(resultSet.getString("lastname"));
                            user.setEmail(resultSet.getString("email"));
                            user.setPassword(resultSet.getString("password"));
                            list.add(user);
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
                    preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id=?");
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

    @Override
    public void update(User user) {
        try {
            try (Connection connection = ConnectionPool.createConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user "
                    + "SET "
                    + "firstname = ?, "
                    + "lastname = ?, "
                    + "email = ?, "
                    + "password = ? "
                    + "WHERE "
                    + "id = ?")) {
                    
                preparedStatement.setString(1, user.getFirstname());
                preparedStatement.setString(2, user.getLastname());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getId().toString());
                
                preparedStatement.executeUpdate();
                
            } catch (NamingException ex) {
                Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
