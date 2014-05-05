package ru.petrsu.second.distribution;

import java.util.Random;

/**
 * Created by lexer on 05.05.14.
 */
public class Pareto implements Distribution {
    private static Random random = new Random();
    private double alpha;

    public Pareto(double alpha) {
        this.alpha = alpha;
    }

    @Override
    public double next() {
        return Math.pow(1 - random.nextDouble(), -1 / alpha);
    }
}
