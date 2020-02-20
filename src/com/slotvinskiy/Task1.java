package com.slotvinskiy;

//1. Создать 2-мерный массив (матрица) M*N и заполнить его случайными числами.
// Отсортировать числа по возрастанию, чтобы с левом верхнем углу было самое маленькое число,
// справа от него следующее по значению, итд, в правом нижнем углу самое большое.

import java.util.Arrays;
import java.util.Random;

public class Task1 {

    public static final Random RANDOM = new Random();
    public static final int BOUND = 100;

    public static void main(String[] args) {

        int rows = 8;
        int columns = 5;
        int[][] array = initArray(rows, columns);
        printArray(array);
        sortArray(array);
        printArray(array);
    }

    private static int[][] initArray(int rows, int columns) {
        int[][] temp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                temp[i][j] = RANDOM.nextInt(BOUND);
            }
        }
        return temp;
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == array[i].length - 1) {
                    System.out.println(array[i][j]);
                } else {
                    System.out.print(array[i][j] + ", ");
                }
            }
        }
        System.out.println();
    }

    private static void sortArray(int[][] origin) {
        int[] temp = new int[origin[0].length * origin.length];
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin[i].length; j++) {
                int index = (origin[i].length * i) + j;
                temp[index] = origin[i][j];
            }
        }
        Arrays.sort(temp);
        for (int i = 0, k = 0; i < origin.length; i++) {
            for (int j = 0; j < origin[i].length; j++, k++) {
                origin[i][j] = temp[k];
            }
        }
    }
}
