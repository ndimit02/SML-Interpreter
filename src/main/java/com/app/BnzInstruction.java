package com.app;

public class BnzInstruction extends Instruction {
    private final int register;
    private final String jumpLabel;

    public BnzInstruction(String label, int register, String jumpLabel) {
        super(label, "bnz");
        this.register = register;
        this.jumpLabel = jumpLabel;
    }

    @Override
    public void execute(Machine machine) {
        if (machine.getRegister(register) != 0) {
            for (int i = 0; i < machine.program.size(); i++) {
                if (machine.program.get(i).getLabel().equals(jumpLabel)) {
                    machine.programCounter = i;
                    break;
                }
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " + register + " " + jumpLabel;
    }
}