package com.example.demo.features.instruction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInstructionDto {
    private String name;
    private String description;
}
