package com.pro.chuck;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class EverythingController {

    private final RestTemplate restTemplate;

    EverythingController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/")
    public String chuckNorris(Model model, @RequestParam(value="name", required=false, defaultValue="") String name) {
        model.addAttribute("name", chuck());
        return "index";
    }

    public String chuck(){
        String url = "https://api.chucknorris.io/jokes/random";
        return this.restTemplate.getForObject(url, String.class);
    }
}
