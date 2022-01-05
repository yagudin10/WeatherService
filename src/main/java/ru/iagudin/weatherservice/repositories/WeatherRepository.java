package ru.iagudin.weatherservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iagudin.weatherservice.models.Weather;

import java.util.Date;

public interface WeatherRepository extends JpaRepository<Weather, Date> {
    Weather findByDate(Date date);
}
