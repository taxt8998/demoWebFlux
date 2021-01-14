package Webflux.demo.controller;

import Webflux.demo.DTO.CountryDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    @GetMapping("/getAPI")
    public ResponseEntity<CountryDTO> getAPI(){
        RestTemplate res = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String uri = "https://covid-193.p.rapidapi.com/countries";
        headers.set("x-rapidapi-key","e9018fe14fmsh36996e498eda8cap19e8adjsn54b2787c5dfc");
        headers.set("x-rapidapi-host","covid-193.p.rapidapi.com");
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<CountryDTO> response = res.exchange(uri, HttpMethod.GET,entity,CountryDTO.class);
        return response;
    }
    @GetMapping("/getAPIString")
    public ResponseEntity<String> getAPIString(){
        RestTemplate res = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String uri = "https://covid-193.p.rapidapi.com/countries";
        headers.set("x-rapidapi-key","e9018fe14fmsh36996e498eda8cap19e8adjsn54b2787c5dfc");
        headers.set("x-rapidapi-host","covid-193.p.rapidapi.com");
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = res.exchange(uri, HttpMethod.GET,entity,String.class);
        return response;
    }
}
