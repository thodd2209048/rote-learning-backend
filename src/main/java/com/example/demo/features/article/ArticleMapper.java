package com.example.demo.features.article;

import com.example.demo.features.article.constant.Repetition;
import com.example.demo.features.article.dto.AddArticleDto;
import com.example.demo.features.article.dto.UpdateArticleDto;
import com.example.demo.features.article.response.AddArticleResponse;
import com.example.demo.features.article.response.GetArticleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ArticleMapper {
    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "nextTimeRead", ignore = true)
    @Mapping(target = "nextPeriod", source = "repetition")
    Article fromAddArticleDto(AddArticleDto addArticleDto);

    @Mapping(target = "repetition", source = "nextPeriod")
    AddArticleResponse toAddArticleResponse(Article article);

    @Mapping(target = "repetition", source = "nextPeriod")
    GetArticleResponse toGetArticleResponse(Article article);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "nextTimeRead", ignore = true)
    @Mapping(target = "nextPeriod", source = "repetition")
    void updateFromUpdateArticleDto(UpdateArticleDto updateArticleDto, @MappingTarget Article article);

    default Integer repetitionToNextPeriod(Repetition repetition){
        return repetition.getNextPeriod();
    }

    default Repetition nextPeriodToRepetition(Integer nextPeriod){
        return Repetition.fromInteger(nextPeriod);
    }
}
