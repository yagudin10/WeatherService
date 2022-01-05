package ru.iagudin.weatherservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iagudin.weatherservice.models.Weather;
import ru.iagudin.weatherservice.services.WeatherService;

import java.util.Calendar;
import java.util.Date;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public ResponseEntity<String> getWeatherValue() {
        Date today = new Date();
        return new ResponseEntity<>(weatherService.getInfo(today).getValue(), HttpStatus.OK);
    }

}
