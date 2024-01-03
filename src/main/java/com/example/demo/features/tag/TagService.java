package com.example.demo.features.tag;

import com.example.demo.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private final TagRepository repository;
    private final TagMapper mapper;

    @Autowired
    public TagService(TagRepository repository,
                      TagMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<TagResponse> listSubjects() {
        return repository.findAll().stream()
                .map(mapper::mapToTagResponse)
                .toList();
    }

    public Tag tagIncrease(String name) {
        Optional<Tag> tagOptional = repository.findByName(name);
        Tag tag;
        if (tagOptional.isPresent()) {
            tag = tagOptional.get();
            Long newCount = tag.getCount() + 1L;
            tag.setCount(newCount);

        } else {
            tag = new Tag(name, 1L);
        }
        return repository.save(tag);

    }

    public Tag tagDecrease(String name) {
        Tag tag = this.getTag(name);
        Long newCount = tag.getCount() == 0 ? 0 : tag.getCount() - 1;
        tag.setCount(newCount);

        return repository.save(tag);
    }

    private Tag getTag(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new ObjectNotFoundException("Tag with name: " + name + " does not exist."));
    }


//    public void extractTags() {
//        List<Article> articles = articleService.listArticles();
//        Map<String, Long> tagMap = new HashMap<>();
//        for (Article article: articles
//             ) {
//            List<String> stringTags = article.getTags();
//            for (String tag: stringTags
//                 ) {
//                String normalizedTag = tag.toLowerCase(Locale.ROOT).replaceAll("\\p{M}", "");
//                tagMap.merge(normalizedTag, 1L, Long::sum);
//            }
//        }
//
//        List<Tag> tagList = new ArrayList<>();
//        for(Map.Entry<String, Long> entry :tagMap.entrySet()){
//            tagList.add(new Tag(entry.getKey(), entry.getValue()));
//        }
//
//        repository.saveAll(tagList);
//    }
}
