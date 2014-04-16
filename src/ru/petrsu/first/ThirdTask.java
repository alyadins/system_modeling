package ru.petrsu.first;

import ru.petrsu.Main;
import ru.petrsu.first.test.IndependenceTest;
import ru.petrsu.first.test.StochasticTest;
import ru.petrsu.first.test.UniformTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by lexer on 14.04.14.
 */
public class ThirdTask {
    private List<Float> randomNumbers;
    private BufferedReader reader = Main.Reader;

    public ThirdTask(List<Float> randomNumbers) throws IOException {
        this.randomNumbers = randomNumbers;

        start();
    }

    private void start() throws IOException {

        String choice = "";

        while (!choice.equals("back")) {
            printMenu();
            choice = reader.readLine();

            if (choice.equals("1")) {

                UniformTest uniformTest = new UniformTest(randomNumbers);

                System.out.println("Тест на равномерность " + uniformTest.result());
                uniformTest.printCriterion();
            } else if (choice.equals("2")) {
                StochasticTest stochasticTest = new StochasticTest(randomNumbers);

                System.out.println("Тест на стохастичность " + stochasticTest.result());
                stochasticTest.printCriterion();
            } else if (choice.equals("3")) {

                IndependenceTest independenceTest = new IndependenceTest(randomNumbers);

                System.out.println("Тест на независимость " + independenceTest.result());
            }
        }
    }

    private void printMenu() {
        System.out.print("Проверка случайной величины\n" +
                "1)Равномерность\n" +
                "2)Стохастичность\n" +
                "3)Независимость\n" +
                "back - назад\n");
    }
}
