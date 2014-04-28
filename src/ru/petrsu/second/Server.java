package ru.petrsu.second;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lexer on 28.04.14.
 */
public class Server {

    private double quantumSize;
    private double lifeTime;

    public int requestCounter;

    private double time;

    private Request currentRequest;
    //
    private double mWorkTime;
    private double mLoseTime;
    private double mLoseRequests;
    private List<Double> mProcessTimes;

    private List<Request> mRequestQueue;

    private int mProcessedRequests;


    private double mArrivalTimes;
    private double mPreviousArrivalTime = 0;

    public Server(double quantumSize, double lifeTime) {
        this.quantumSize = quantumSize;
        this.lifeTime = lifeTime;
    }

    public void addRequest(Request request) {

        mRequestQueue = new LinkedList<Request>();

        mRequestQueue.add(request);

        mArrivalTimes = request.arrivalTime - mPreviousArrivalTime;

        requestCounter++;
    }

    public void update(double time) {
        this.time = time;


    }

    public double averageTime() {
        double sum = 0;

        for (Iterator<Double> iterator = mProcessTimes.iterator(); iterator.hasNext(); ) {
            Double next = iterator.next();
            sum += next.doubleValue();
        }

        return sum;
    }

    public double averageArrivalTime() {

        return mArrivalTimes / requestCounter;
    }

    public int processedRequest() {
        return mProcessedRequests;
    }

}
