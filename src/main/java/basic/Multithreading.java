package basic;

/**
 * Multithreading - класс для проверки работы с потоками и синхронизацией / блокировками
 */
public class Multithreading {
    public static void main(String[] args) {
        Calculator calc = new Calculator("calc1");
        Thread calcThread = new Thread(calc);
        calcThread.start();

        Calculator calc2 = new Calculator("calc2");
        Thread calcThread2 = new Thread(calc2);
        calcThread2.start();
    }
}

class Calculator implements Runnable {
    private static Integer number = 1;
    private String name;

    public Calculator(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (number) {
                System.out.println(name + " : " + number++);
            }
        }

    }
}