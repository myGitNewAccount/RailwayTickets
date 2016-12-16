/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam.railway.dao.daofactory;

import epam.railway.dao.implementation.DaoStation;
import epam.railway.dao.implementation.DaoTicket;
import epam.railway.dao.implementation.DaoTrain;
import epam.railway.dao.implementation.DaoUser;

/**
 *
 * @author denis
 */
public class DaoFactory {
    
    public static DaoStation getDaoStation(){
        return new DaoStation();
    }
    
    public static DaoUser getDaoUser(){
        return new DaoUser();
    }
    
    public static DaoTrain getDaoTrain(){
        return new DaoTrain();
    }
    
    public static DaoTicket getDaoTicket(){
        return new DaoTicket();
    }
}

