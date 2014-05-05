package ru.petrsu.second;

import ru.petrsu.Main;
import ru.petrsu.second.distribution.Distribution;
import ru.petrsu.second.distribution.Expotential;
import ru.petrsu.second.distribution.Pareto;
import ru.petrsu.second.distribution.Uniform;

import java.io.IOException;

/**
 * Created by lexer on 28.04.14.
 */
public class Second {

    private static final double TIME_ITERATION = 0.01;

    private double time = 0.0;
    private Server server;
    private RequestGenerator requestGenerator;
    private int requestCount;
    private double quantumSize;
    private double lifeTime;

    public Second() throws IOException {
        System.out.println("Добро пожаловать в симулятор сервера");

        System.out.println("Введите количество запросов");
        requestCount = Integer.parseInt(Main.Reader.readLine());

        System.out.println("Введите квант времени");
        quantumSize = Double.parseDouble(Main.Reader.readLine());

        System.out.println("Введите время жизни запроса");
        lifeTime = Double.parseDouble(Main.Reader.readLine());

        Distribution arrival = askDistribution("времени запроса");
        Distribution process = askDistribution("времени обработки");

        requestGenerator = new RequestGenerator(arrival, process);

        server = new Server(quantumSize, lifeTime);

        start();
    }

    private void start() {
        while (server.requestCounter <= requestCount) {
            time += TIME_ITERATION;

            requestGenerator.update(time);
            server.update(time);

            if (requestGenerator.hasNext() && requestGenerator.next() != null) {
                server.addRequest(requestGenerator.next());
            }
        }

        System.out.println("Среднее время обслуживания = " + server.averageProcessTime());
        System.out.println("Средний интервал между запросами = " + server.averageArrivalInterval());
        System.out.println("Средняя загрузка сервера = " + server.averageLoad());
        System.out.println("Вероятность отказа = " + server.failureProbability());
    }


    private Distribution askDistribution(String forText) {
        System.out.println("Выюерете распределение для " + forText);

        System.out.print("1) Экспотенциальное\n" +
                "2) Парето\n" +
                "3) Равномерное\n");

        int choice = 0;
        try {
            choice = Integer.parseInt(Main.Reader.readLine());
        } catch (IOException e) {
            System.out.println("Введите 1 2 или 3");
        }

        Distribution distribution = new Uniform(0, 1);
        try {
            switch (choice) {
                case 1:
                    System.out.print("Введите лямда\nlambda = ");
                    double lamda = Double.parseDouble(Main.Reader.readLine());
                    distribution = new Expotential(lamda);
                    break;
                case 2:
                    System.out.print("Введите альфа\nalpha = ");
                    double alpha = Double.parseDouble(Main.Reader.readLine());
                    distribution = new Pareto(alpha);
                    break;
                case 3:
                    System.out.print("Введите а и b\na = ");
                    double a = Double.parseDouble(Main.Reader.readLine());
                    System.out.print("b = ");
                    double b = Double.parseDouble(Main.Reader.readLine());
                    distribution = new Uniform(a, b);
                    break;
                default:
                    throw new Exception();
            }
        } catch (Exception e)  {
            System.out.println("Введите нужное значение");
        }

        return distribution;
    }
}
