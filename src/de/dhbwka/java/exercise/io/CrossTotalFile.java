package de.dhbwka.java.exercise.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;
import java.util.Scanner;

public class CrossTotalFile {
    public static void main(String[] args) {
        Optional<Path> opPath = createFile();
        if (opPath.isEmpty()) return;
        Path filePath = opPath.get();
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND);
             Scanner scanner = new Scanner(System.in)) {
            while (true) {
                int input = scanner.nextInt();
                if (input < 0) break;
                int crossTotal = CrossTotal.crossTotal(input);
                writer.write(crossTotal + ", ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Optional<Path> createFile() {
        Path dirPath = Paths.get("crossTotals");
        try {
            if (!Files.exists(dirPath)) {
                Files.createDirectory(dirPath);
            }
            Path filePath = dirPath.resolve("crossTotals.txt");
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
            return Optional.of(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
