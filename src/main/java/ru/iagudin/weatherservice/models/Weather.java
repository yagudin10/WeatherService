package ru.iagudin.weatherservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "weather_history")
public class Weather {

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "weather_date", unique = true)
    private Date date;

    @Column(name = "weather_value")
    private String value;
}
