package Webflux.demo.service;

import Webflux.demo.model.dto.CountryDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@Service
public class RestService {

    @Value("${rapidapi.host}")
    public String host;

    @Value("${rapidapi.url}")
    public String url;

    @Value("${rapidapi.key}")
    public String key;

    public ResponseEntity<Object> getStringResponse(String type) {
        Object responseString = null;
        switch (type) {
            case "rest":
                RestTemplate restTemplate = new RestTemplate();
                HttpEntity<String> entity = this.initRestTemplateEntity();
                responseString = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
                break;
            case "webclient":
                WebClient webClient = this.initWebClient();
                responseString = webClient.get().retrieve().bodyToMono(String.class).subscribe(data ->{
                    System.out.println(data);
                    JsonMapper mapper = new JsonMapper();
                    try {
                        CountryDTO dto = mapper.readValue(data,CountryDTO.class);
                        System.out.println(Arrays.toString(dto.getResponse()));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                });
                break;
        }
        return ResponseEntity.ok(responseString);
    }

    public ResponseEntity<Object> getObjectResponse(String type) {
        Object responseObject = null;
        switch (type) {
            case "rest":
                RestTemplate restTemplate = new RestTemplate();
                HttpEntity<String> entity = this.initRestTemplateEntity();
                responseObject = restTemplate.exchange(url, HttpMethod.GET, entity, CountryDTO.class).getBody();
                break;
            case "webclient":
                WebClient webClient = this.initWebClient();
                responseObject = webClient.get().retrieve().bodyToMono(CountryDTO.class).subscribe(data -> {

                    // lấy danh sách các quốc gia từ data
                    String[] countries = data.getResponse();
                    System.out.println(Arrays.toString(countries));

                    // lấy số lượng quốc gia từ data
                    int results = data.getResults();
                    System.out.println(results + 100);
                });
                break;
        }
        return ResponseEntity.ok(responseObject);
    }

    HttpEntity<String> initRestTemplateEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", key);
        headers.set("x-rapidapi-host", host);
        return new HttpEntity<>(headers);
    }

    WebClient initWebClient() {
        return WebClient.builder().baseUrl(url).defaultHeaders(httpHeaders -> {
            httpHeaders.set("x-rapidapi-key", key);
            httpHeaders.set("x-rapidapi-host", host);
        }).build();
    }
}
