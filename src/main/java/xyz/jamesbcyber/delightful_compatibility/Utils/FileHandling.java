package xyz.jamesbcyber.delightful_compatibility.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {
    public static final File LOG_DIRECTORY = new File("logs/datadump");
    public static void setup(){
        if (!LOG_DIRECTORY.exists()) {
            LOG_DIRECTORY.mkdirs();
        }
    }

    public static File writeFile(String filename, String text){
        File file = new File(LOG_DIRECTORY, filename);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(text);
            return file;
        } catch (IOException e) {
            System.err.println("Failed to write to mod log file: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
