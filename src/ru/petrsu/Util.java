package ru.petrsu;

import java.util.List;

/**
 * Created by lexer on 14.04.14.
 */
public class Util {
    public static void print(String text) {
        System.out.println(text);
    }

    public static float Mean(List<Float> numbers) {
        float sum = .0f;

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }

        return sum / numbers.size();
    };

    public static float Variance(List<Float> numbers) {
        float mean = Mean(numbers);

        float sum = .0f;

        for (int i = 0; i < numbers.size(); i++) {
            sum += Math.pow(numbers.get(i) - mean, 2);
        }

        return sum / numbers.size();
    }

    public static float StandardDeviation(List<Float> numbers) {
        return (float) Math.sqrt(Variance(numbers));
    }
}
