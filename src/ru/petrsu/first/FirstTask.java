package ru.petrsu.first;


import ru.petrsu.Distribution;
import ru.petrsu.Main;
import ru.petrsu.Util;
import ru.petrsu.first.distribution.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by lexer on 14.04.14.
 */
public class FirstTask {

    public BufferedReader reader = Main.Reader;

    private boolean fullPrint = false;

    public FirstTask(List<Float> randomNumbers) throws IOException {

        String choice = "";
        while (!choice.equals("back")) {
            printMenu();
            randomNumbers.clear();
            choice = reader.readLine();

            if (choice.equals("1")) {
                System.out.print("Равномерное распределение\n" +
                        "Введите a и b\n" +
                        "a = ");
                int a = Integer.parseInt(reader.readLine());
                System.out.print("b = ");
                int b = Integer.parseInt(reader.readLine());

                Uniform uniform = new Uniform(randomNumbers, a, b);

                printDistr(uniform);
            } else

            if (choice.equals("2")) {
                System.out.print("Экспотенциальное распределение с параметром λ\n" +
                        "Введите λ\n" +
                        "λ = ");
                float lamda = Float.parseFloat(reader.readLine());

                Expotential expotential = new Expotential(randomNumbers, lamda);

                printDistr(expotential);
            } else if (choice.equals("3")) {
                System.out.print("Нормальное распределение с параметрами а и σ^2\n" +
                        "Введите a\n" +
                        "a = ");

                float a = Float.parseFloat(reader.readLine());
                Normal normal = new Normal(randomNumbers, a, Util.StandardDeviation(randomNumbers));

                printDistr(normal);
            } else if (choice.equals("4")) {
                System.out.print("Логнормальное распределение\n" +
                        "Введите a\n" +
                        "a = ");
                float a = Float.parseFloat(reader.readLine());

                LogNorm logNorm = new LogNorm(randomNumbers, a);

                printDistr(logNorm);
            } else if (choice.equals("5")) {
                System.out.print("Распределение вейбудла\n" +
                        "Введите а\n" +
                        "a = ");
                float a = Float.parseFloat(reader.readLine());

                Weibull weibull = new Weibull(randomNumbers, a, Util.StandardDeviation(randomNumbers));

                printDistr(weibull);
            } else if (choice.equals("a")) {
                fullPrint = !fullPrint;

                if (fullPrint) {
                    System.out.println("Полный вывод включен");
                } else {
                    System.out.println("Полный вывод выключен");
                }
            }
        }
    }

    private void printMenu() {
        System.out.print("Выберите распределение\n" +
                "1)Равномерное на a, b \n" +
                "2)Экспоненциальное с параметром  λ\n" +
                "3)Нормальное с параметрами a  и σ^2\n" +
                "4)Логарифмически нормальное распределение\n" +
                "5)Вейбулла параметрами  η и σ^2\n" +
                "Введите \"back\" для возврата в предыдущее меню\n" +
                "Введите a для вкл/выкл полного вывода\n");
    }

    private void printDistr(Distribution distribution) {
        if (fullPrint)
            distribution.printAll();
        else
            distribution.print();
    }
}
