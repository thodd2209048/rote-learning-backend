package com.example.demo.features.serie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/series")
public class SeriesController {

    private final SeriesService service;

    @Autowired
    public SeriesController(SeriesService service) {
        this.service = service;
    }

    @GetMapping({"/",""})
    public List<SeriesResponse> listSeries(){
        return service.listSeries();
    }

//    @PostMapping({"/",""})
//    public void extractTags(){
//        service.extractTags();
//    }
}
