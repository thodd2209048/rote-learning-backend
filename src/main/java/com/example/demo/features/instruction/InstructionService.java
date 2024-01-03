package com.example.demo.features.instruction;

import com.example.demo.exception.ObjectNotFoundException;
import com.example.demo.features.instruction.dto.AddInstructionDto;
import com.example.demo.features.instruction.dto.UpdateInstructionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InstructionService {
    private final InstructionRepository repository;
    private final InstructionMapper mapper;

    @Autowired
    public InstructionService(InstructionRepository repository,
                              InstructionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    private Instruction getInstruction(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Instruction with id: "+ id+ " does not exist."));
    }

    public Page<InstructionResponse> listInstructions(Pageable pageable, String search) {
        Page<Instruction> instructions = search == null?
                repository.findAll(pageable) : repository.findInstructionsByNameContaining(pageable, search);
        return instructions.map(mapper::mapToInstructionResponse);
    }

    public InstructionResponse addInstruction(AddInstructionDto addInstructionDto) {
        Instruction instruction = mapper.mapFromAddInstructionDto(addInstructionDto);

        repository.save(instruction);

        return mapper.mapToInstructionResponse(instruction);
    }


    public InstructionResponse updateInstruction(Long id, UpdateInstructionDto updateInstructionDto) {
        Instruction instruction = this.getInstruction(id);

        mapper.updateFromUpdateInstructionDto(updateInstructionDto, instruction);

        repository.save(instruction);

        return mapper.mapToInstructionResponse(instruction);
    }


}
