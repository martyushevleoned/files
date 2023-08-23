package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        MyFileWriter.writeUsingFiles("data\\file1.txt", "file 1");
        MyFileWriter.writeUsingPrintWriter("data\\file2.txt", "file 2");
        MyFileWriter.writeUsingFileOutputStream("data\\file3.txt", "file 3");

        System.out.println(MyFileReader.readUsingFiles("data\\file1.txt"));
        System.out.println(MyFileReader.readUsingBufferReader("data\\file2.txt"));
        System.out.println(MyFileReader.readUsingFileInputStream("data\\file3.txt"));
        System.out.println();

        getAllFiles("data");
    }

    public static void getAllFiles(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            assert files != null;
            for(File f: files)
                getAllFiles(f.getPath());
        } else {
            System.out.println(file.getName() + "\t" + file.length() + " bytes");
        }
    }
}