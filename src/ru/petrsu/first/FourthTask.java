package ru.petrsu.first;

import ru.petrsu.Util;

/**
 * Created by lexer on 16.04.14.
 */
public class FourthTask {
    private static final int N = 1000;

    double[] our = new double[N];
    double[] norm = new double[N];

    public FourthTask() {
        for (int i = 0; i < 100; i++) {
            our[i] = Util.nextGaussian();
            System.out.println(our[i]);
        }

    }
}
