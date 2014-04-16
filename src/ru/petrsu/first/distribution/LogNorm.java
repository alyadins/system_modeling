package ru.petrsu.first.distribution;

import ru.petrsu.Distribution;
import ru.petrsu.Util;

import java.util.List;

/**
 * Created by lexer on 14.04.14.
 */
public class LogNorm extends Distribution {

    float a;

    public LogNorm(List<Float> randomNumbers, float a) {
        super(randomNumbers);
        this.a = a;

        generate();
    }

    @Override
    protected void generate() {
        Normal normal = new Normal(randomNumbers, a, Util.StandardDeviation(randomNumbers));
        List<Float> normalNumbers = normal.numbers;

        for (int i = 0; i < normalNumbers.size(); i++) {
            float normalNumber = normalNumbers.get(i);
            float number = (float) Math.exp(normalNumber);
            numbers.add(number) ;
        }
        super.generate();
    }
}
