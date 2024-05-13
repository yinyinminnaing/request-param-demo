package com.example.requestparamdemo.controller;

import jakarta.annotation.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class PersonInfoController {
    //curl 'http://localhost:8080/person-info-v1?name=John&city=Yangon&country=Myanmar'
    @GetMapping("/person-info-v1")
    public String personInfoV1(@RequestParam("name") String name,@RequestParam("city") String city,@RequestParam("country")String country){
        return "Name : %s ,City : %s ,Country : %s".formatted(name,city,country);
    }

    //curl 'http://localhost:8080/person-info-v2?name=John&city=Yangon'
    @GetMapping("/person-info-v2")
    public String personInfoV2(@RequestParam("name") String name,
                               @RequestParam("city") String city,
                               @RequestParam(value = "country",required = false,defaultValue = "Myanmar")String country){
        return "Name : %s ,City : %s ,Country : %s".formatted(name,city,country);
    }

    //curl 'http://localhost:8080/person-info-v3?name=John'
    @GetMapping("/person-info-v3")
    public String personInfoV3(@RequestParam("name") String name,
                               @RequestParam("city")@Nullable String city,
                               @RequestParam(value = "country",required = false,defaultValue = "Myanmar")String country){
        return "Name : %s ,City : %s ,Country : %s".formatted(name,city,country);
    }


    //curl 'http://localhost:8080/person-info-v4'
    @GetMapping("/person-info-v4")
    public String personInfoV4(@RequestParam("name") Optional<String> name,
                               @RequestParam("city")@Nullable String city,
                               @RequestParam(value = "country",required = false,defaultValue = "Myanmar")String country){
        return "Name : %s ,City : %s ,Country : %s".formatted(name,city,country);
    }
}
