package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    private String readFile(File file) {
        String response = null;
        String tmp;
        StringBuilder sb = new StringBuilder();
        try (java.io.FileReader fr = new java.io.FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            while ((tmp = br.readLine()) != null) {
                sb.append(tmp);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        response = sb.toString();
        return response;
    }

    public Profile getDataFromFile(File file) throws IOException {
        String st;
        String name = null;
        Integer age = null;
        String email = null;
        Long phone = null;
        String response = readFile(file);
        String tmp;

        while ((response = br.readLine()) != null) {
            if (tmp.startsWith("Name")) {
                name = tmp.substring(6);
            } else if (tmp.startsWith("Age")) {
                age = Integer.parseInt(tmp.substring(5));
            } else if (tmp.startsWith("Email")) {
                email = tmp.substring(7);
            } else if (tmp.startsWith("Phone")) {
                phone = Long.parseLong(tmp.substring(7));
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
