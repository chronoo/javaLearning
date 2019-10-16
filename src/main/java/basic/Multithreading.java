package basic;

import java.util.Arrays;

/**
 * Multithreading - класс для проверки работы с потоками и синхронизацией /
 * блокировками
 */
public class Multithreading {
    public static void main(String[] args) {
        
    }

    private static void runParallelAction() {
        int[] values = new int[10];
        Arrays.parallelSetAll(values, i -> i + 1);
        Arrays.parallelPrefix(values, (x, y) -> x + y);
        for (int i : values) {
            System.out.println(i);
        }
    }

    private static void runPrinter() {
        boolean wait = true;

        try {
            Thread printThread = new Printer();
            printThread.start();

            if (wait) {
                try {
                    printThread.join();
                    throw new InterruptedException();
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                    throw new Exception();
                } finally {
                    System.out.println("waiting is over");
                }
            }

            System.out.println("main thread is successfully finished");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    private static void runTwoCalculator() {
        Calculator calc = new Calculator("calc1");
        Thread calcThread = new Thread(calc);
        calcThread.start();

        Calculator calc2 = new Calculator("calc2");
        Thread calcThread2 = new Thread(calc2);
        calcThread2.start();
    }
}

class Printer extends Thread {
    private static Integer number = 1;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(number++);
        }
    }
}

class Calculator implements Runnable {
    private static Integer number = 1;
    private String name;

    public Calculator(String name) {
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