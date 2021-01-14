package Webflux.demo.controller;

import Webflux.demo.model.WeatherEvent;
import Webflux.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController()
@RequestMapping("/webflux")
public class RouterController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping(path = "/weatherService", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<WeatherEvent> getWeather(){
        Flux<WeatherEvent> streamWeather = weatherService.streamWeather();
        return streamWeather;
    }
}
