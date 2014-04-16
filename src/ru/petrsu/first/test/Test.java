package ru.petrsu.first.test;

import java.util.List;

/**
 * Created by lexer on 14.04.14.
 */
public class Test {

    public boolean pass = false;


    public String result() {
        if (pass) {
            return "пройден";
        } else {
            return "не пройден";
        }
    }

    protected float getMinValue(List<Float> numbers) {
        float minValue = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            minValue = Math.min(minValue, numbers.get(i));
        }
        return minValue;
    }

    protected float getMaxValue(List<Float> numbers) {
        float maxValue = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            maxValue = Math.max(maxValue, numbers.get(i));
        }

        return maxValue;
    }
}
