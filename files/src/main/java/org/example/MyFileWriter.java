package org.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyFileWriter {
    public static void writeUsingFileOutputStream(String path, String text) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(text.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeUsingPrintWriter(String path, String text) {
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.write(text);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeUsingFiles(String path, String text) {
        try {
            Files.write(Paths.get(path), text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
