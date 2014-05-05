package ru.petrsu.second.distribution;

import ru.petrsu.Main;

import java.util.Random;

/**
 * Created by lexer on 05.05.14.
 */
public class Uniform implements Distribution {

    private static Random random = new Random();
    private double a;
    private double b;

    public Uniform(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double next() {
        return (b - a) * Main.random.nextDouble() + a;
    }
}
