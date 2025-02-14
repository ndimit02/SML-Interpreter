package com.app;



public class LinInstruction extends Instruction {
    private final int register;
    private final int value;

    public LinInstruction(String label, int register, int value) {
        super(label, "lin");
        this.register = register;
        this.value = value;
    }

    @Override
    public void execute(Machine machine) {
        machine.setRegister(register, value);
    }

    @Override
    public String toString() {
        return super.toString() + " " + register + " " + value;
    }
}
