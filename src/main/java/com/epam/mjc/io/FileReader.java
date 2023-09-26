package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    String line = null;
    Map<String, String> result = new HashMap<>();
    String[] array = {};
    public Profile getDataFromFile(File file) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file))))
        {
            while ((line = reader.readLine()) != null) {
                array = line.split(":");
                result.put(array[0], array[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Profile(result.get("Name").trim(), Integer.parseInt(result.get("Age").trim()), result.get("Email").trim(), Long.parseLong(result.get("Phone").trim()));
    }
}
