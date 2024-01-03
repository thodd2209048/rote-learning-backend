package com.example.demo.features.instruction;

import com.example.demo.features.instruction.dto.AddInstructionDto;
import com.example.demo.features.instruction.dto.UpdateInstructionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/instructions")
public class InstructionController {
    private final InstructionService service;

    @Autowired
    public InstructionController(InstructionService service) {
        this.service = service;
    }

    @GetMapping({"/",""})
    public Page<InstructionResponse> listInstructions(@PageableDefault(page = 0, size = 10, sort = "name")Pageable pageable,
                                                      @RequestParam(required = false) String search){
        return service.listInstructions(pageable, search);
    }

    @PostMapping({"/", ""})
    public InstructionResponse addInstruction(
            @RequestBody AddInstructionDto addInstructionDto){
        return service.addInstruction(addInstructionDto);
    }

    @PutMapping("{id}")
    public InstructionResponse updateInstruction(
            @PathVariable Long id,
            @RequestBody UpdateInstructionDto updateInstructionDto
            ){
        return service.updateInstruction(id, updateInstructionDto);
    }
}
