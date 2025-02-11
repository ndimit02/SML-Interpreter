package com.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Machine {
    private final List<String> labels = new ArrayList<>();
    final List<Instruction> program = new ArrayList<>();
    private final int[] registers = new int[32];
    int programCounter = 0;

    public void addInstruction(String label, Instruction instruction) {
        labels.add(label);
        program.add(instruction);
    }

    public void execute() {
        while (programCounter < program.size()) {
            Instruction instruction = program.get(programCounter);
            programCounter++;
            instruction.execute(this);
        }
    }

    public int getRegister(int index) {
        return registers[index];
    }

    public void setRegister(int index, int value) {
        registers[index] = value;
    }

    public void printRegisters() {
        System.out.println("Registers: ");
        for (int i = 0; i < registers.length; i++) {
            System.out.printf("R%d: %d%n", i, registers[i]);
        }
    }
}
