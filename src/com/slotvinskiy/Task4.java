package com.slotvinskiy;
//4*. Задана строка с датой вида "22.01.2019 19:15:00".
// Написать метод который преобразовывает ее в формат "22 Jan, 7:15 PM".
// Предусмотреть обработку ситуации если входящая дата в недопустимом формате.

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Task4 {

    private static final Locale LOCAL = Locale.UK;
    private static final DateTimeFormatter FORMATTER_FOR_PARSE = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss", LOCAL);
    private static final DateTimeFormatter FORMATTER_FOR_OUTPUT = DateTimeFormatter.ofPattern("dd MMM, HH:mm a", LOCAL);

    public static void main(String[] args) {

        String string = "22.01.2019 19:15:00";
        string = modifyFormat(string);
        System.out.println(string);
    }

    private static String modifyFormat(String string) {
        try {
            LocalDateTime time = LocalDateTime.parse(string, FORMATTER_FOR_PARSE);
            return time.format(FORMATTER_FOR_OUTPUT);
        } catch (DateTimeException DTException) {
            DTException.printStackTrace();
        }
        return string;
    }
}
