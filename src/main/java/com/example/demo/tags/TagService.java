package com.example.demo.tags;

import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    List<String> getTagNames(){
        return tagRepository.getTagNames();
    }

    public void addNewTag(Tag tag) {
        Optional<Tag> tagOptional = tagRepository.findTagByTagName(tag.getName());
        if (tagOptional.isEmpty()) {
            tagRepository.save(tag);
        }
    }

    public void updateTag(Tag newTag){
        Tag currentTag = tagRepository.findTagByTagName(newTag.getName())
                .orElseThrow(()-> new IllegalStateException("Tag " + newTag.getName() + " does not exists"));
        currentTag.setName(newTag.getName());
        currentTag.setOccurrenceCount(newTag.getOccurrenceCount());
        currentTag.setUpdatedAt(ZonedDateTime.now());
    }

    public void incrementOccurrenceCount(String tagName){
        Tag currentTag = tagRepository.findTagByTagName(tagName)
                .orElseThrow(()-> new IllegalStateException("Tag " + tagName + " does not exists"));
        currentTag.setOccurrenceCount(currentTag.getOccurrenceCount() + 1);
        currentTag.setUpdatedAt(ZonedDateTime.now());
    }



    public boolean isTagExists(String tagName){
        return tagRepository.isTagExists(tagName);
    }
}
