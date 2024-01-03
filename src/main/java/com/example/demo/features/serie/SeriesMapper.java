package com.example.demo.features.serie;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SeriesMapper {
    SeriesMapper INSTANCE = Mappers.getMapper(SeriesMapper.class);

    SeriesResponse mapToSeriesResponse(Series series);
}
