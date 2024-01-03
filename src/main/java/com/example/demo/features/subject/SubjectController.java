package com.example.demo.features.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/subjects")
public class SubjectController {

    private final SubjectService service;

    @Autowired
    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @GetMapping({"/",""})
    public List<SubjectResponse> listSubjects(){
        return service.listSubjects();
    }

//    @PostMapping({"/",""})
//    public void extractTags(){
//        service.extractTags();
//    }
}
