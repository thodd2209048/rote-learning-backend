package com.example.demo.features.subject;

import com.example.demo.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository repository;
    private final SubjectMapper mapper;

    @Autowired
    public SubjectService(SubjectRepository repository,
                          SubjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<SubjectResponse> listSubjects() {
        return repository.findAll().stream()
                .map(mapper::mapToSubjectResponse)
                .toList();
    }

    public Subject increaseSubjectCount(String name) {
        Optional<Subject> tagOptional = repository.findByName(name);
        Subject subject;
        if (tagOptional.isPresent()) {
            subject = tagOptional.get();
            Long newCount = subject.getCount() + 1L;
            subject.setCount(newCount);

        } else {
            subject = new Subject(name, 1L);
        }
        return repository.save(subject);

    }

    public Subject decreaseSubjectCount(String name) {
        Subject subject = this.getSubject(name);
        Long newCount = subject.getCount() == 0 ? 0 : subject.getCount() - 1;
        subject.setCount(newCount);

        return repository.save(subject);
    }

    private Subject getSubject(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new ObjectNotFoundException("Tag with name: " + name + " does not exist."));
    }

    public void saveAll(List<Subject> subjects) {
        repository.saveAll(subjects);
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
