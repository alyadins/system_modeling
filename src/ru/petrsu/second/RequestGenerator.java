package ru.petrsu.second;

import ru.petrsu.second.distribution.Distribution;

/**
 * Created by lexer on 28.04.14.
 */
public class RequestGenerator {


    private Request nextRequest;

    private double time;

    private Distribution arrival;
    private Distribution processing;

    public RequestGenerator(Distribution arrivalDistribution, Distribution processingDistribution) {
        this.arrival = arrivalDistribution;
        this.processing = processingDistribution;
    }

    public Request next() {

        Request request = nextRequest;

        nextRequest = new Request(time + arrival.next(), processing.next());

        return request;
    }

    public boolean hasNext() {
        return nextRequest == null ? false : nextRequest.arrivalTime < time;
    }

    public void update(double time) {
        if (nextRequest == null) {
            nextRequest = new Request(time + arrival.next(), processing.next());
        }
        this.time = time;
    }
}

