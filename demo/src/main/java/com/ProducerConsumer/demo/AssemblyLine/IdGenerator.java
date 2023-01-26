package com.ProducerConsumer.demo.AssemblyLine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class IdGenerator {
    public String creatId(String type) {
        String path = "";
        String newId = "";
        if (type.equals("machine")) {
            path = "./mid.tex";
            newId = "M";
        } else if (type.equals("queue")) {
            path = "./qid.txt";
            newId = "Q";
        } else {
            path = "./tid.txt";
            newId = "task ";
        }
        int id = readFromFile(path) + 1;
        newId += id;
        writeToAfile(path, id);
        return newId;
    }

    private int readFromFile(String path) {
        File file = new File(path);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            return Integer.parseInt(br.readLine());
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error in readFromFile");
            e.printStackTrace();
        }
        return -1;
    }

    private void writeToAfile(String path, int id) {
        File file = new File(path);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
            writer.print(id);
        } catch (FileNotFoundException e) {
            System.out.println("Error in writeToFile");
            e.printStackTrace();
        }
    }

}
