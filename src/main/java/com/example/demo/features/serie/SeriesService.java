package com.example.demo.features.serie;

import com.example.demo.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesService {
    private final SeriesRepository repository;
    private final SeriesMapper mapper;

    @Autowired
    public SeriesService(SeriesRepository repository,
                         SeriesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<SeriesResponse> listSeries() {
        return repository.findAll().stream()
                .map(mapper::mapToSeriesResponse)
                .toList();
    }

    public Series increaseSeriesCount(String name) {
        if(name == null) return null;
        Optional<Series> tagOptional = repository.findByName(name);
        Series series;
        if (tagOptional.isPresent()) {
            series = tagOptional.get();
            Long newCount = series.getCount() + 1L;
            series.setCount(newCount);

        } else {
            series = new Series(name, 1L);
        }
        return repository.save(series);
    }

    public Series decreaseSeriesCount(String name) {
        Series series = this.getSeries(name);
        Long newCount = series.getCount() == 0 ? 0 : series.getCount() - 1;
        series.setCount(newCount);

        return repository.save(series);
    }

    private Series getSeries(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new ObjectNotFoundException("Tag with name: " + name + " does not exist."));
    }

    public void saveAll(List<Series> subjects) {
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
