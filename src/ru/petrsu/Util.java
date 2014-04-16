package ru.petrsu;

import com.sun.org.apache.regexp.internal.recompile;

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
    }

    public static float Mean(List<Float> numbers, int from, int to) {
       List<Float> temp = numbers.subList(from, to);
       return Mean(temp);
    }

    public static float Variance(List<Float> numbers) {
        float mean = Mean(numbers);

        float sum = .0f;

        for (int i = 0; i < numbers.size(); i++) {
            sum += Math.pow(numbers.get(i) - mean, 2);
        }

        return sum / numbers.size();
    }

    public static float Variance(List<Float> numbers, int from, int to) {
        List<Float> temp = numbers.subList(from, to);
        return Util.Variance(temp);
    }

    public static float StandardDeviation(List<Float> numbers) {
        return (float) Math.sqrt(Variance(numbers));
    }

    public static float sumMult(List<Float> mas1, List<Float> mas2) {
        if (mas1.size() != mas2.size()) {
            throw new IllegalArgumentException("mas1.size must be equal mas2.size");
        }

        float sum = 0.0f;


        for (int i = 0; i < mas1.size(); i++) {
            sum += mas1.get(i) * mas2.get(i);
        }

        return sum;
    }
}
