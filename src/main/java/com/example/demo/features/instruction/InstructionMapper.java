package com.example.demo.features.instruction;

import com.example.demo.features.instruction.dto.AddInstructionDto;
import com.example.demo.features.instruction.dto.UpdateInstructionDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface InstructionMapper {

    InstructionMapper INSTANCE = Mappers.getMapper(InstructionMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Instruction mapFromAddInstructionDto(AddInstructionDto addInstructionDto);

    InstructionResponse mapToInstructionResponse(Instruction instruction);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateFromUpdateInstructionDto(
            UpdateInstructionDto updateInstructionDto,
            @MappingTarget Instruction instruction
    );
}
