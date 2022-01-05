package ru.iagudin.weatherservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.iagudin.weatherservice.models.Weather;
import ru.iagudin.weatherservice.repositories.WeatherRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    @Override
    public void addInfo(Date date) {
        try {
            URL url = new URL("https://yandex.ru");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            int x = content.indexOf("<div class='weather__temp'>");
            int y = content.indexOf("</div></a><div class='weather__forecast'>");

            Weather weather = Weather.builder()
                    .date(date)
                    .value(content.substring(x + 27, y))
                    .build();
            weatherRepository.save(weather);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Weather getInfo(Date date) {
        if (weatherRepository.findByDate(date) == null) {
            addInfo(date);
        }
        return weatherRepository.findByDate(date);
    }
}
