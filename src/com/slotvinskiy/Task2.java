package com.slotvinskiy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//2. Задан текстовый файл. Вывести сколько в нём: a) строк b) слов c) символов

public class Task2 {

    public static void main(String[] args) {

        String path = "./resources/1.txt";
        readFileAndCount(path);
    }

    private static void readFileAndCount(String path) {
        int linesNumber = 0;
        int wordsNumber = 0;
        int charNumber = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                charNumber += currentLine.length();
                wordsNumber += currentLine.split("\\s").length;
                linesNumber++;
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException ioE) {
            ioE.printStackTrace();
        }
        System.out.printf("Lines - %s, words - %s, characters - %s\n", linesNumber, wordsNumber, charNumber);
    }
}
