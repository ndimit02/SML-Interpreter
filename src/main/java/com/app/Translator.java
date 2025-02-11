package com.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Translator {
    public static Machine readProgram(String filePath) throws IOException {
        Machine machine = new Machine();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);

                if (!tokenizer.hasMoreTokens()) continue; // Skip empty lines

                String label = tokenizer.nextToken();  // Read label
                String opcode = tokenizer.nextToken(); // Read instruction type

                switch (opcode) {
                    case "lin" -> machine.addInstruction(label,
                            new LinInstruction(label,
                                    Integer.parseInt(tokenizer.nextToken()),
                                    Integer.parseInt(tokenizer.nextToken())
                            ));

                    case "add" -> machine.addInstruction(label,
                            new AddInstruction(label,
                                    Integer.parseInt(tokenizer.nextToken()),
                                    Integer.parseInt(tokenizer.nextToken()),
                                    Integer.parseInt(tokenizer.nextToken())
                            ));

                    case "sub" -> machine.addInstruction(label,
                            new SubInstruction(label,
                                    Integer.parseInt(tokenizer.nextToken()),
                                    Integer.parseInt(tokenizer.nextToken()),
                                    Integer.parseInt(tokenizer.nextToken())
                            ));

                    case "mul" -> machine.addInstruction(label,
                            new MulInstruction(label,
                                    Integer.parseInt(tokenizer.nextToken()),
                                    Integer.parseInt(tokenizer.nextToken()),
                                    Integer.parseInt(tokenizer.nextToken())
                            ));

                    case "bnz" -> machine.addInstruction(label,
                            new BnzInstruction(label,
                                    Integer.parseInt(tokenizer.nextToken()),
                                    tokenizer.nextToken()  // Read label as a String
                            ));

                    case "out" -> machine.addInstruction(label,
                            new OutInstruction(label,
                                    Integer.parseInt(tokenizer.nextToken())
                            ));

                    default -> throw new IllegalArgumentException("Unknown instruction: " + opcode);
                }
            }
        }
        return machine;
    }
}
