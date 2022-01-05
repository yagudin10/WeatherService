package ru.iagudin.weatherservice.services;

import ru.iagudin.weatherservice.models.Weather;

import java.util.Date;

public interface WeatherService {
    void addInfo(Date date);
    Weather getInfo(Date date);
}
