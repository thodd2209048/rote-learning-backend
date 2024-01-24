package com.example.demo.features.quote;

import com.example.demo.config.MapStructConfig;
import com.example.demo.features.quote.dto.AddQuoteDto;
import com.example.demo.features.quote.dto.UpdateQuoteDto;
import com.example.demo.features.quote.reponse.QuoteResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapStructConfig.class)
public interface QuoteMapper {
    QuoteMapper INSTANCE = Mappers.getMapper(QuoteMapper.class);

    Quote fromAddQuoteDto(AddQuoteDto addQuoteDto);

    Quote fromUpdateQuoteDto(UpdateQuoteDto updateQuoteDto, @MappingTarget Quote quote);

    QuoteResponse toQuoteResponse(Quote quote);
}
