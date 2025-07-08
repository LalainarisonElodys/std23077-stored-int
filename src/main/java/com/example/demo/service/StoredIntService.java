package com.example.demo.service;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public class StoredIntService {
    public int getStoredInt() {
        File filePath = new File(System.getProperty("java.io.tmpdir"), "stored-int.txt");


        try {
            if (filePath.exists()) {
                try (Scanner scanner = new Scanner(filePath) ) {
                    if (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        return Integer.parseInt(line);
                    }
                }
            } else {
                int randomNumber = new Random().nextInt(101);
                try (FileWriter fileWriter = new FileWriter(filePath)) {
                    fileWriter.write(String.valueOf(randomNumber));
                }

                return randomNumber;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }
}