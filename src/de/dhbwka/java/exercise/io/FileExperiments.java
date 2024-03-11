package de.dhbwka.java.exercise.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExperiments {
    public static void main(String[] args) {
        Path dirPath = Paths.get("myDir");
        try {
            Files.createDirectory(dirPath);
            Path foo1 = dirPath.resolve("foo1.txt");
            Files.createFile(foo1);
            Path foo2 = dirPath.resolve("foo2.txt");
            Files.createFile(foo2);
            Path foo3 = dirPath.resolve("foo3.txt");
            Files.createFile(foo3);

            System.out.println(dirPath.toAbsolutePath());

            Files.newDirectoryStream(dirPath).forEach(path -> {
                try {
                    Files.delete(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Files.delete(dirPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
