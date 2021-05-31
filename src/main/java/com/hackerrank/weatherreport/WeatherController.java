package com.hackerrank.weatherreport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController("/")
public class WeatherController {

    private ArrayList<Weather> weatherList=new ArrayList();

    @Autowired
    WeatherRepository weatherRepository;

    @PostMapping("/weather")
    public ResponseEntity<Weather> create(@RequestBody Weather weather){
        try{
            weatherRepository.save(weather);
            return new ResponseEntity<Weather>(weather,
                    HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/weather")
    public List<Weather> getAllWeather(){
        try{
            List<Weather> wList = weatherRepository.findAll();
            return wList;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @GetMapping("/weather/{id}")
    public Optional<Weather> getbyId(@PathVariable("id") int id){
        try{
            List<com.hackerrank.weatherreport.Weather> wList = weatherRepository.findAll();
            for (Weather weather : wList){
                if(weather.getId().equals(id)){
                    Optional<Weather> optWeather =weatherRepository.findById(id);
                    return optWeather;
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @DeleteMapping("/weather/{id}")
    public ResponseEntity deletebyId(@PathVariable("id") int id){

        try{
            List<com.hackerrank.weatherreport.Weather> wList = weatherRepository.findAll();
            for (Weather weather : wList){
                if(weather.getId().equals(id)){

                    weatherRepository.delete(weather);
                    return new ResponseEntity<>("",
                            HttpStatus.NO_CONTENT);

                }
            }
            return new ResponseEntity<>("",
                    HttpStatus.NOT_FOUND);

        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("",
                    HttpStatus.INTERNAL_SERVER_ERROR);


        }

    }


}
