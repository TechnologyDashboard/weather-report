package com.hackerrank.weatherreport;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date date;

    private Float lat;
    private Float lon;
    private String city;
    private String state;
    private Double temperature;

    public Weather() {
    }

    public Weather(Integer id, Date date, Float lat, Float lon, String city, String state, Double temperature) {
        this.id = id;
        this.date = date;
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.state = state;
        this.temperature = temperature;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Float getLat() {
        return lat;
    }

    public Float getLon() {
        return lon;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Double getTemperature() {
        return temperature;
    }
}
