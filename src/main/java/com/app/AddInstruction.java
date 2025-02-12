package com.app;




public class AddInstruction extends Instruction {
    private final int resultRegister;
    private final int op1;
    private final int op2;

    public AddInstruction(String label, int resultRegister, int op1, int op2) {
        super(label, "add");
        this.resultRegister = resultRegister;
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public void execute(Machine machine) {
        machine.setRegister(resultRegister, machine.getRegister(op1) + machine.getRegister(op2));
    }

    @Override
    public String toString() {
        return super.toString() + " " + resultRegister + " " + op1 + " " + op2;
    }
}
