package ru.petrsu.first.test;

import java.util.List;

/**
 * Created by lexer on 14.04.14.
 */
public class StochasticTest extends Test {
    private static final float CRITERION_TABLE_95 = 1.644853627f;

    private List<Float> randomNumbers;

    private float p;
    private float n;

    private int[] intervalsValues;

    private int count1;
    private int count2;

    private float criterion;

    public StochasticTest(List<Float> randomNumbers) {
        this.randomNumbers = randomNumbers;
        p = (getMaxValue(randomNumbers) - getMinValue(randomNumbers)) / 2;


        intervalsValues = new int[randomNumbers.size()];

        start();
    }

    private void start() {
        for (int i = 0; i < randomNumbers.size(); i++) {
            float randomNumber = randomNumbers.get(i);
            if (randomNumber > p) {
                intervalsValues[i] = 1;
                count1++;
            } else {
                intervalsValues[i] = 0;
                count2++;
            }
        }

        n = 1;

        for (int i = 1; i < randomNumbers.size(); i++) {
            if (!(intervalsValues[i - 1] == intervalsValues[i])) {
                n++;
            }
        }

        float n1 = (float) count1;
        float n2 = (float) count2;

        float top = n - (2 * n1 * n2) / (n1 + n2) - 1;
        float underTop = 2 * n1 * n2 *(2 * n1 * n2 - (n1 + n2));
        float underBottom = (float) (Math.pow(n1 + n2, 2) * (n1 + n2 - 1));
        float bottom = (float) Math.sqrt(underTop / underBottom);

        criterion = Math.abs(top / bottom);

        if (criterion < CRITERION_TABLE_95)
            pass = true;
    }

    public void printCriterion() {
        System.out.print("Табличный = " + CRITERION_TABLE_95 + "\n" +
                "Получившийся = " + criterion + "\n");
    }
}
