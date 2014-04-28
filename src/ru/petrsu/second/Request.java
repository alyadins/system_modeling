package ru.petrsu.second;

/**
 * Created by lexer on 28.04.14.
 */
public class Request {

    public double arrivalTime;
    public double processingTime;
    public double currentProcessingTime;

    public Request(double arrivalTime, double processingTime) {
        this.arrivalTime = arrivalTime;
        this.processingTime = processingTime;
        this.currentProcessingTime = 0;
    }

    public boolean isProcessed() {
        return currentProcessingTime > processingTime;
    }

    public void process(double time) {
        currentProcessingTime += time;
    }

    public double proceedTime(double currentTime) {
        return currentTime - arrivalTime;
    }
}
