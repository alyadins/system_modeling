package ru.petrsu.second.distribution;

import java.util.Random;

/**
 * Created by lexer on 05.05.14.
 */
public class Expotential implements Distribution{
    private static Random random = new Random();
    private double lambda;

    public Expotential(double lamda) {
        this.lambda = lamda;
    }

    @Override
    public double next() {
        return (-1 / lambda) * Math.log10(1 - random.nextDouble());
    }
}
