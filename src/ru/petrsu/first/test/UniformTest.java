package ru.petrsu.first.test;

import ru.petrsu.first.test.Test;

import java.util.List;

/**
 * Created by lexer on 14.04.14.
 */
public class UniformTest extends Test {
    private static final int N = 10;
    private static final float CHI_SQUARE_TABLE_10 = 16.9189776046f;

    private List<Float> randomNumbers;
    private float maxValue;
    private float minValue;
    private float intervalStep;

    private float[] intervals = new float[N];
    private int[] intervalValues = new int[N];

    private float chiSquare;

    public UniformTest(List<Float> randomNumbers) {
        this.randomNumbers = randomNumbers;

        clearIntervals();

        minValue = getMinValue(randomNumbers);
        maxValue = getMaxValue(randomNumbers);

        intervalStep = (maxValue - minValue) / N;

        initIntervals();

        processIntervals();
    }

    private void processIntervals() {
        for (int i = 0; i < randomNumbers.size(); i++) {
            float randomNumber = randomNumbers.get(i);
            for (int j = 0; j < N; j++) {
                if (randomNumber < intervals[j]) {
                    intervalValues[j]++;
                    break;
                }
            }
        }

        chiSquare = 0;
        for (int i = 0; i < N; i++) {
            chiSquare += Math.pow((intervalValues[i] - N), 2) / N;
        }

        if (chiSquare < CHI_SQUARE_TABLE_10) {
            pass = true;
        }
    }

    private void initIntervals() {
        intervals[0] = minValue + intervalStep;

        for (int i = 1; i < N; i++) {
            intervals[i] = intervals[i - 1] + intervalStep;
        }
    }

    private void clearIntervals() {
        for (int i = 0; i < N; i++) {
            intervals[i] = 0.0f;
            intervalValues[i] = 0;
        }
    }

    public void printCriterion() {
        System.out.print("Табличный = " + CHI_SQUARE_TABLE_10 + "\n" +
                "Получившийся = " + chiSquare + "\n");
    }
}
