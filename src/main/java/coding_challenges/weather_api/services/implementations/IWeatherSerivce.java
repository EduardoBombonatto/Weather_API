package coding_challenges.weather_api.services.implementations;

import coding_challenges.weather_api.dtos.WeatherDTO;
import coding_challenges.weather_api.services.interfaces.WeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class IWeatherSerivce implements WeatherService {

    @Value("${api.weather.url}")
    private String weatherApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    @Cacheable(value = "WEATHER_CACHE", key = "#city")
    public WeatherDTO getWeather(String city) {
        Map<String, String> uriVariables = Map.of("city", city);
        String jsonResponse = restTemplate.getForObject(weatherApiUrl, String.class, uriVariables);
        try {
            return objectMapper.readValue(jsonResponse, WeatherDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar resposta da API do clima", e);
        }
    }
}
