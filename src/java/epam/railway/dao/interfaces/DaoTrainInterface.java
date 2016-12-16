/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam.railway.dao.interfaces;

import epam.railway.entities.Train;
import java.util.List;

/**
 *
 * @author denis
 */
public interface DaoTrainInterface {
    List findByDeparturecityAndDestinationcity(String departureCity, String destinationCity);
    Train findById(Integer id);
}
