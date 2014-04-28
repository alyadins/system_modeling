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


    //counters
    public int requestCounter = 0;
    public int completeRequests = 0;
    public int notCompleteRequests = 0;

    public double time;

    public double workTime = 0;
    public double downTime = 0;
    public double quantumTime = 0;

    private Request currentRequest;

    //
    private double mWorkTime;
    private double mLoseTime;
    private double mLoseRequests;
    private List<Double> mProcessTimes;

    private List<Request> requestQueue;

    private int mProcessedRequests;


    private double mArrivalTimes;
    private double mPreviousArrivalTime = 0;

    public Server(double quantumSize, double lifeTime) {
        this.quantumSize = quantumSize;
        this.lifeTime = lifeTime;
        requestQueue = new LinkedList<Request>();
    }

    public void addRequest(Request request) {

        requestQueue.add(request);

        mArrivalTimes = request.arrivalTime - mPreviousArrivalTime;

        requestCounter++;
    }

    public void update(double time) {
        double delta = time - this.time;
        this.time = time;

        process(delta);
    }

    private void process(double delta) {
        quantumTime += delta;


        if (currentRequest == null) {
            if (!requestQueue.isEmpty()) {
                currentRequest = requestQueue.get(0);

                requestQueue.remove(currentRequest);
            } else {
                downTime += delta;
                return;
            }
        }

        workTime += delta;

        if (currentRequest.currentProcessingTime > lifeTime) {
            notCompleteRequests++;
            currentRequest = null;
            return;
        } else {
            currentRequest.process(delta);
            if (currentRequest.isProcessed()) {
                completeRequests++;
                currentRequest = null;
                return;
            }
        }

        if (quantumTime > quantumSize) {
            requestQueue.add(currentRequest);
            currentRequest = null;
        }
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
