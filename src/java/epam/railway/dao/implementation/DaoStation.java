/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam.railway.dao.implementation;

import epam.railway.dao.interfaces.DaoStationInterface;
import epam.railway.entities.Station;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

/**
 *
 * @author denis
 */
public class DaoStation implements DaoStationInterface{
    @Override
    public List<Station> getTrainStations(Integer trainNumber){
        Driver driver = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic( "neo4j", "ycthssw5sn" ) );
        Session session = driver.session();

        StatementResult result = session.run( "match (n)-[rel: GOES {trainnumber: "+ trainNumber +"}]->(m)\n" +
"return distinct ID(n) as id, n.name as name, m.name as arname, rel.order, rel.departure as departure, rel.arrival as arrival\n" +
"order by rel.order" );
        List<Station> list = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Record record = null;
        while ( result.hasNext() )
        {
            Station station = new Station();
            record = result.next();
            station.setId(record.get("id").asInt());
            station.setName(record.get("name").asString());
            try {
                station.setDepartureTime(formatter.parse(record.get("departure").asString()));
            } catch (ParseException ex) {
                Logger.getLogger(DaoStation.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println( record.get("name").asString() );
            list.add(station);
        }
        Station station = new Station();
            station.setId(record.get("id").asInt());
            station.setName(record.get("arname").asString());
            try {
                station.setDepartureTime(formatter.parse(record.get("arrival").asString()));
            } catch (ParseException ex) {
                Logger.getLogger(DaoStation.class.getName()).log(Level.SEVERE, null, ex);
            }
            list.add(station);
        System.out.println(list);
        session.close();
        driver.close();
        return list;
    } 
}
