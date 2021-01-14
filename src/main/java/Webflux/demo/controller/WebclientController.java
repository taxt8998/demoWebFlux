package Webflux.demo.controller;

import Webflux.demo.DTO.CountryDTO;
import Webflux.demo.model.WeatherEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient")
public class WebclientController {
    @GetMapping("getAPI")
    public Mono<CountryDTO> getAPI(){
        WebClient webClient = WebClient.create("https://covid-193.p.rapidapi.com");
        Mono<CountryDTO> response = webClient.get().uri("/countries").headers(headers ->{
            headers.set("x-rapidapi-key","e9018fe14fmsh36996e498eda8cap19e8adjsn54b2787c5dfc");
            headers.set("x-rapidapi-host","covid-193.p.rapidapi.com");
        }).retrieve().bodyToMono(CountryDTO.class);
        return response;
    }
    @GetMapping("getAPIString")
    public Mono<String> getAPIString(){
        WebClient webClient = WebClient.create("https://covid-193.p.rapidapi.com");
        Mono<String> response = webClient.get().uri("/countries").headers(headers ->{
            headers.set("x-rapidapi-key","e9018fe14fmsh36996e498eda8cap19e8adjsn54b2787c5dfc");
            headers.set("x-rapidapi-host","covid-193.p.rapidapi.com");
        }).retrieve().bodyToMono(String.class);
        return response;
    }
}
