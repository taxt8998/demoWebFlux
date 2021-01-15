package Webflux.demo.controller;

import Webflux.demo.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {

    @Autowired
    RestService restService;

    @GetMapping("{type}/getAPI")
    public ResponseEntity<Object> getAPI(@PathVariable("type") String requestType) {
        return restService.getObjectResponse(requestType);
    }

    @GetMapping("{type}/getAPIString")
    public ResponseEntity<Object> getAPIString(@PathVariable("type") String requestType) {
        return restService.getStringResponse(requestType);
    }
}
