package com.example.demo.features.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/tags")
public class TagController {

    private final TagService service;

    @Autowired
    public TagController(TagService service) {
        this.service = service;
    }

    @GetMapping({"/",""})
    public List<TagResponse> listTags(){
        return service.listSubjects();
    }

//    @PostMapping({"/",""})
//    public void extractTags(){
//        service.extractTags();
//    }
}
