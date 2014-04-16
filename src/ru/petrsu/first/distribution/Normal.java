package ru.petrsu.first.distribution;

import ru.petrsu.Distribution;
import ru.petrsu.Main;

import java.util.List;
import java.util.Random;

/**
 * Created by lexer on 14.04.14.
 */
public class Normal extends Distribution {

    private float a;
    private float b;

    public Random random = Main.random;

    protected Normal(List<Float> randomNumbers, float a, float b) {
        super(randomNumbers);
        this.a = a;
        this.b = b;

        generate();
    }

    @Override
    protected void generate() {
        for (int i = 0; i < randomNumbers.size(); i++) {
            float randomNumber = randomNumbers.get(i);
            float number = (float) (a + b * random.nextGaussian());

            numbers.add(number);
        }


        super.generate();
    }
}
