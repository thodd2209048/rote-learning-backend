package com.example.demo.features.quote;

import com.example.demo.features.quote.dto.AddQuoteDto;
import com.example.demo.features.quote.dto.UpdateQuoteDto;
import com.example.demo.features.quote.reponse.QuoteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface QuoteMapper {
    QuoteMapper INSTANCE = Mappers.getMapper(QuoteMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Quote fromAddQuoteDto(AddQuoteDto addQuoteDto);

    Quote fromUpdateQuoteDto(UpdateQuoteDto updateQuoteDto, @MappingTarget Quote quote);

    QuoteResponse toQuoteResponse(Quote quote);
}
