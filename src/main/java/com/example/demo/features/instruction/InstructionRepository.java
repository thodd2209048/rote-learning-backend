package com.example.demo.features.instruction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionRepository extends JpaRepository<Instruction, Long> {

    Page<Instruction> findInstructionsByNameContaining(Pageable pageable, String search);
}
