package ru.petrsu.first;

import ru.petrsu.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lexer on 14.04.14.
 */
public class First {

    public static final int N = 100;

    public BufferedReader reader = Main.Reader;
    public Random random = Main.random;

    public List<Float> randomNumbers;

    public First() throws IOException {
        start();
    }

    private void start() throws IOException {

        generateRandomNumbers(N);

        String choice = "";
        while (!choice.equals("stop")) {
            System.out.print("Задание 1. \n" +
                    "Выберите номер задачи\n" +
                    "Введите \"stop\" для выхода\n");

            choice = reader.readLine();

            if (choice.equals("1")) {
                FirstTask firstTask = new FirstTask(randomNumbers);
            } else if (choice.equals("3")) {
                ThirdTask thirdTask = new ThirdTask(randomNumbers);
            } else if (choice.equals("4")) {
                FourthTask fourthTask = new FourthTask();
                random.nextGaussian();
            }
        }
    }

    private void generateRandomNumbers(int i) {

        if (randomNumbers == null) {
            randomNumbers = new ArrayList<Float>();
        } else {
            randomNumbers.clear();
        }

        for (int j = 0; j < i; j++) {
            float item = random.nextFloat();
            randomNumbers.add(item);
        }
    }
}
