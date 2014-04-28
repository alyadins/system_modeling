package ru.petrsu;

import ru.petrsu.first.First;
import ru.petrsu.second.Second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by lexer on 14.04.14.
 */
public class Main {

    public static BufferedReader Reader = new BufferedReader(new InputStreamReader(System.in));
    public static Random random = new Random();

    public static void main(String[] args) throws IOException {


        String choice = "";
        while (!choice.equals("q")) {

            System.out.println("Выберете номер задания, q для выхода");
            choice = Reader.readLine();

            if (choice.equals("1")) {
                First first = new First();
            } else if (choice.equals("2")) {
                Second second = new Second();
            } else if (!choice.equals("q")) {
                    System.out.println("Неверный номер задания");
            }
        }

        System.out.println("Удачи!");
    }
}
