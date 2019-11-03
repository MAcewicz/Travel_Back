package com.kodilla.travel.amadeus;

import com.kodilla.travel.domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class AmadeusClient {

    @Autowired
    private RestTemplate restTemplate;
}
