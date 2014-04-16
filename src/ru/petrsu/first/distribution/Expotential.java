package ru.petrsu.first.distribution;

import ru.petrsu.Distribution;

import java.util.List;

/**
 * Created by lexer on 14.04.14.
 */
public class Expotential extends Distribution {

    public float lamda;

    public Expotential(List<Float> randomNumbers, float lamda) {
        super(randomNumbers);
        this.lamda = lamda;

        generate();
    }

    @Override
    protected void generate() {
        for (int i = 0; i < randomNumbers.size(); i++) {
            float random = randomNumbers.get(i);

            float number = (float) ((-1.0 / lamda) * Math.log(1 - random));
            numbers.add(number);
        }

        super.generate();
    }
}
