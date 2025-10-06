package coding_challenges.weather_api.services.interfaces;

import coding_challenges.weather_api.dtos.WeatherDTO;

public interface WeatherService {
    WeatherDTO getWeather(String city);
}
