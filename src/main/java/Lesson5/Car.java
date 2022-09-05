package Lesson5;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            Thread t1 = new Thread(() -> {

                try {
                    Thread.sleep(500 + (int) (Math.random() * 800));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ); System.out.println(this.name + " готовится");

                try {
                    t1.join();
               } catch (InterruptedException e){
                   throw new RuntimeException(e);
               }
            Thread t2 = new Thread(() ->
            System.out.println(this.name + " готов"));
            t1.start();
            t2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            try {
                Thread.sleep(500 + (int) (Math.random() * 800));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            race.getStages().get(i).go(this);
        }
    }
}