package ru.petrsu.second;

import ru.petrsu.Main;

/**
 * Created by lexer on 28.04.14.
 */
public class RequestGenerator {

    public enum  Distribution {
        EXPOTENTIAL,
        PARETO,
        UNIFORM
    };

    private double lambda;
    private double alpha;
    private double a;
    private double b;

    private Distribution mDistribution;

    private Request nextRequest;

    private double time;

    public RequestGenerator(Distribution distribution, Double... args) {
        mDistribution = distribution;
        switch (distribution) {
            case EXPOTENTIAL:
                lambda = args[0];
                break;
            case PARETO:
                alpha = args[0];
                break;
            case UNIFORM:
                a = args[0];
                b = args[1];
                break;
        }
    }

    public Request next() {

        Request request = nextRequest;

        nextRequest = new Request(time += nextRandom(), nextRandom());

        return hasNext() ? null : request;
    }

    public boolean hasNext() {
        return nextRequest == null ? false : nextRequest.arrivalTime < time;
    }

    public void update(double time) {
        if (nextRequest == null) {
            nextRequest = new Request(time += nextRandom(), nextRandom());
        }

        this.time = time;
    }

    private double nextRandom() {
        switch (mDistribution) {
            case EXPOTENTIAL:
                return nextExponential(lambda);
            case PARETO:
                return nextPareto(alpha);
            case UNIFORM:
                return nextUniform(a, b);
        }
        return nextUniform(0, 1);
    }

    private static double nextExponential(double lambda) {
        return (-1 / lambda) * Math.log10(1 - Main.random.nextDouble());
    }

    private static double nextPareto(double alpha) {
        return Math.pow(1 - Main.random.nextDouble(), -1 / alpha);
    }

    private static double nextUniform(double a, double b) {
        return (b - a) * Main.random.nextDouble() + a;
    }
}

