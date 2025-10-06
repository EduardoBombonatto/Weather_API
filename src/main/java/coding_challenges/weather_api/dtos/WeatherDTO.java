package coding_challenges.weather_api.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record WeatherDTO(double latitude, double longitude, String resolvedAddress, String timezone,double tzoffset,String description) {
}
