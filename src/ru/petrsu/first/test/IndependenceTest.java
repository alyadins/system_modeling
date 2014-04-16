package ru.petrsu.first.test;

import ru.petrsu.Util;
import ru.petrsu.first.test.Test;

import java.util.List;

/**
 * Created by lexer on 15.04.14.
 */
public class IndependenceTest extends Test {

    private List<Float> randomNumbers;

    private float tau = 50.0f;

    private float r;

    public IndependenceTest(List<Float> randomNumbers) {
        this.randomNumbers = randomNumbers;

        start();
    }

    private void start() {
        float variance1 = Util.Variance(randomNumbers);
        float variance2 = Util.Variance(randomNumbers);

    }

    private void variance(int from, int to) {

    }
}
