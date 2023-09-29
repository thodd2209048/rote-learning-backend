package com.example.demo.tags;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tags")
public class TagController {
    private final TagService tagService;
    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    public List<Tag> getTags(){
        return tagService.getTags();
    }

    @GetMapping(path = "/tagNames")
    public List<String> getTagNames(){
        return tagService.getTagNames();
    }

    @PostMapping
    public void addNewTag(@RequestBody Tag tag){
        tagService.addNewTag(tag);
    }

    public void updateTag(Tag newTag){
        tagService.updateTag(newTag);
    }

    public void incrementOccurrenceCount(String tagName){
        tagService.incrementOccurrenceCount(tagName);
    }

    public boolean isTagExists(String tagName){
        return tagService.isTagExists(tagName);
    }
}
