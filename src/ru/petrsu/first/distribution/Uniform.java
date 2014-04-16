package ru.petrsu.first.distribution;

import ru.petrsu.Distribution;

import java.util.List;

/**
 * Created by lexer on 14.04.14.
 */
public class Uniform extends Distribution {

    public int a;
    public int b;

    public Uniform(List<Float> numbers, int a, int b) {
        super(numbers);
        this.a = a;
        this.b = b;

        generate();
    }

    @Override
    protected void generate() {
        for (int i = 0; i < randomNumbers.size(); i++) {
            float random = randomNumbers.get(i);
            float number = (b - a) * random + a;
            numbers.add(number);
        }

        super.generate();
    }
}
