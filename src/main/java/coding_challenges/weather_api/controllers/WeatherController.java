package coding_challenges.weather_api.controllers;

import coding_challenges.weather_api.dtos.WeatherDTO;
import coding_challenges.weather_api.services.interfaces.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public WeatherDTO getWeatherByCity(@PathVariable String city) {
        return weatherService.getWeather(city);
    }
}
