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
                sb.append(tmp + ";");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        tmp = sb.toString();
        String[] response = tmp.split(";");
        for (int i = 0; i < response.length; i++){
            System.out.println(response[i]);
            if (response[i].startsWith("Name")) {
                name = response[i].substring(6);
            } else if (response[i].startsWith("Age")) {
                age = Integer.parseInt(response[i].substring(5));
            } else if (response[i].startsWith("Email")) {
                email = response[i].substring(7);
            } else if (response[i].startsWith("Phone")) {
                phone = Long.parseLong(response[i].substring(7));
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
