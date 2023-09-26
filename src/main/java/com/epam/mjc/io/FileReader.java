package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) throws IOException {
        String name = null;
        Integer age = null;
        Long phone = null;
        String email = null;
        String tmp;
        StringBuilder sb = new StringBuilder();
        BufferedReader br;
        try (java.io.FileReader fr = new java.io.FileReader(file)) {
            br = new BufferedReader(fr);
            while ((tmp = br.readLine()) != null) {
                sb.append(tmp).append(";");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        tmp = sb.toString();
        String[] response = tmp.split(";");
        for (String s : response) {
            if (s.startsWith("Name")) {
                name = s.substring(6);
            } else if (s.startsWith("Age")) {
                age = Integer.parseInt(s.substring(5));
            } else if (s.startsWith("Email")) {
                email = s.substring(7);
            } else if (s.startsWith("Phone")) {
                phone = Long.parseLong(s.substring(7));
            }
        }
        return new Profile(name, age, email, phone);
    }

    public static void main (String[] args) {
        FileReader fileReader = new FileReader();
        try {
            fileReader.getDataFromFile(new File("src/main/resources/Profile.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
