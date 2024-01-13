package com.janco;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;

public class Main {
    // Read the file,
    // sort the lines into a pyramid structure,
    // extract only the word from each line on only the right side of the pyramid
    // return a single string with no preceding or trailing whitespace

        public static String decode() {
            Path filePath = Paths.get("src/main/resources/coding_qual_input.txt");
            List<String> fileData = new ArrayList<>();

            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(filePath.toFile()));
                String line = reader.readLine();

                while (line != null) {
                    fileData.add(line);
                    line = reader.readLine();
                }
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Collections.sort(fileData);
            String word;
            String message = "";
            int count = 0;
            int rowNum = 1;
            for(int i = 1; i < fileData.size(); i++){
                String thisLine = fileData.get(i);
                count++;
                if(count == rowNum){
                    word = fileData.get(i).replaceAll("\\P{L}", "");
                    message = message + word + " ";
                    count = 0;
                    rowNum++;
                }
            }
        return message.trim();
    }
}


