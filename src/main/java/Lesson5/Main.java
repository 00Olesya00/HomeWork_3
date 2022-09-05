package Lesson5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        try {
            Thread t = new Thread(() -> {

                try {
                    Thread.sleep(500 + (int) (Math.random() * 800));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
            Race race = new Race(new Road(60), new Tunnel(), new Road(40));
            Car[] cars = new Car[CARS_COUNT];
            for (int i = 0; i < cars.length; i++) {
                cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
            }
            for (int i = 0; i < cars.length; i++) {
                new Thread(cars[i]).start();
            }

            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
    }
    }

