package ru.petrsu.second;

import ru.petrsu.Main;

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

        System.out.println("Выберете распределение\n" +
                "1)Экспотенциальное\n" +
                "2)Парето\n" +
                "3)Равномерное");
        switch (Integer.parseInt(Main.Reader.readLine())) {
            case 1:
                System.out.println("Введите лямда");
                System.out.print("лямда = ");
                double lambda = Double.parseDouble(Main.Reader.readLine());
                requestGenerator = new RequestGenerator(RequestGenerator.Distribution.EXPOTENTIAL, lambda);
                break;
            case 2:
                System.out.println("Введите альфа");
                System.out.print("альфа = ");
                double alpha = Double.parseDouble(Main.Reader.readLine());
                requestGenerator = new RequestGenerator(RequestGenerator.Distribution.PARETO, alpha);
                break;
            case 3:
                System.out.println("Введите а и b");
                System.out.print("а = ");
                double a = Double.parseDouble(Main.Reader.readLine());
                System.out.print("b = ");
                double b = Double.parseDouble(Main.Reader.readLine());
                requestGenerator = new RequestGenerator(RequestGenerator.Distribution.UNIFORM, a, b);
                break;
            default:
                System.out.println("Не найдено. Выполняется равномерное на 0 и 1");
                requestGenerator = new RequestGenerator(RequestGenerator.Distribution.UNIFORM, 0.0, 1.0);
        }

        server = new Server(quantumSize, lifeTime);

        start();
    }

    private void start() {
        while (server.requestCounter < requestCount) {
            time += TIME_ITERATION;

            requestGenerator.update(time);
            server.update(time);

            if (requestGenerator.hasNext() && requestGenerator.next() != null) {
                server.addRequest(requestGenerator.next());
            }
        }

    }
}
