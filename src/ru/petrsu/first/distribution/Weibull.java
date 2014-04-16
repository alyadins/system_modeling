package ru.petrsu.first.distribution;

import ru.petrsu.Distribution;

import java.util.List;

/**
 * Created by lexer on 14.04.14.
 */
public class Weibull extends Distribution {

    private float a;
    private float b;

    public Weibull(List<Float> randomNumbers, float a, float b) {
        super(randomNumbers);

        this.a = a;
        this.b = b;

        generate();
    }

    @Override
    protected void generate() {
        for (int i = 0; i < randomNumbers.size(); i++) {
            float random = randomNumbers.get(i);
            float number = (float) (b * Math.pow(((-1) * Math.log(random)), 1 / a));
            numbers.add(number);
        }
        super.generate();
    }
}
