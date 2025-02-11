package com.app;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class Instruction {
    protected final String label;
    protected final String opcode;

    public abstract void execute(Machine machine);

    @Override
    public String toString() {
        return label + ": " + opcode;
    }
}
