package com.app;

public class Main {
    public static void main(String[] args) {
        try {
            Machine machine = Translator.readProgram("src/program.sml");

            machine.execute();
            machine.printRegisters();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}