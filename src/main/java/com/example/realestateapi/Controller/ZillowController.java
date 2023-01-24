package com.example.realestateapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ZillowController {

    private static final String RAPID_API_KEY = "3fe421aa57mshdfd4147f4d4c319p1ba7f4jsnca7d59efce2d";
    private static final String RAPID_API_HOST = "zillow56.p.rapidapi.com";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/search")
    public ResponseEntity<String> getSearch(@RequestParam(value = "location", required = true) String location) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", RAPID_API_KEY);
        headers.set("X-RapidAPI-Host", RAPID_API_HOST);

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        return restTemplate.exchange("https://zillow56.p.rapidapi.com/search?location="+location, HttpMethod.GET, entity, String.class);
    }
}
