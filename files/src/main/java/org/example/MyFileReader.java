package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MyFileReader {

    public static String readUsingFileInputStream(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(path);
            int code = fis.read();
            while (code >= 0) {
                builder.append((char) code);
                code = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static String readUsingBufferReader(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while (line != null) {
                builder.append(line).append("\n");
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static String readUsingFiles(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
