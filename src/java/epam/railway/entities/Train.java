/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epam.railway.entities;

import java.sql.Time;
import java.util.Date;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author denis
 */
@Entity
@Table(name = "User")
public class Train {
    @Column(name = "id")
    @Id
    private Integer id;
    @Column(name = "departurecity")
    private String departurecity;
    @Column(name = "destinationcity")
    private String destinationcity;
    @Column(name = "departuretime")
    private Date departuretime;
    @Column(name = "arrivaltime")
    private Date arrivaltime;
    @Column(name = "price")
    private Double price;
    
    private Date traveltime;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeparturecity() {
        return departurecity;
    }

    public void setDeparturecity(String departurecity) {
        this.departurecity = departurecity;
    }

    public String getDestinationcity() {
        return destinationcity;
    }

    public void setDestinationcity(String destinationcity) {
        this.destinationcity = destinationcity;
    }

    public Date getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(Date departuretime) {
        this.departuretime = departuretime;
    }

    public Date getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(Date arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public Date getTraveltime() {
        return traveltime;
    }

    public void setTraveltime(Date traveltime) {
        this.traveltime = traveltime;
    }
}
