package ru.petrsu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lexer on 14.04.14.
 */
public abstract class Distribution {

    public List<Float> randomNumbers;

    public List<Float> numbers;
    public float mean;
    public float variance;
    public float standardDeviation;

    protected Distribution(List<Float> randomNumbers) {
        this.randomNumbers = randomNumbers;
        numbers = new ArrayList<Float>();
    }

    protected void generate() {
        mean = Util.Mean(numbers);
        variance = Util.Variance(numbers);
        standardDeviation = Util.StandardDeviation(numbers);
    }

    public void print() {
        System.out.println("Мат. ожидание = " + mean);
        System.out.println("Дисперсия = " + variance);
        System.out.println("Ср. кв. отклонение = " + standardDeviation);
    }

    public void printAll() {
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        print();
    }

    public List<Float> get() {
        return numbers;
    }
}


