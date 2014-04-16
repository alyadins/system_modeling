package ru.petrsu.first.test;

import ru.petrsu.Util;
import ru.petrsu.first.test.Test;

import java.util.List;

/**
 * Created by lexer on 15.04.14.
 */
public class IndependenceTest extends Test {

    private List<Float> randomNumbers;

    private int tau = 50;

    private float r;
    private float zn;
    private float d;

    public IndependenceTest(List<Float> randomNumbers) {
        this.randomNumbers = randomNumbers;

        tau = this.randomNumbers.size() / 2;
        start();
    }

    private void start() {
        float variance1 = Util.Variance(randomNumbers, 0, tau);
        float variance2 = Util.Variance(randomNumbers, tau, randomNumbers.size());

        float mean1 = Util.Mean(randomNumbers, 0, tau);
        float mean2 = Util.Mean(randomNumbers, tau, randomNumbers.size());

        float sumMult = Util.sumMult(randomNumbers.subList(0, tau), randomNumbers.subList(tau, randomNumbers.size()));

        r = (float) Math.abs((((1.0f / (randomNumbers.size() - tau)) * sumMult - mean1 * mean2)) / Math.sqrt(variance1 * variance2));


        zn = (float) (0.5f * Math.log((1.0f + r) / (1.0f - r)));
        d = 1.0f / (randomNumbers.size() - tau - 3);

        if (zn > d)
            pass = true;
    }
}
