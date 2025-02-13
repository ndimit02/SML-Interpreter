package com.app;


public class OutInstruction extends Instruction {
    private final int register;

    public OutInstruction(String label, int register) {
        super(label, "out");
        this.register = register;
    }

    @Override
    public void execute(Machine machine) {
        System.out.println(machine.getRegister(register));
    }

    @Override
    public String toString() {
        return super.toString() + " " + register;
    }
}

