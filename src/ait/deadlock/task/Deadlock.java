package ait.deadlock.task;

public class Deadlock implements Runnable {
    private static final Object lock1 = new Object(); // Объект-монитор 1
    private static final Object lock2 = new Object(); // Объект-монитор 2

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread1")) { // Проверяем имя текущего потока
            synchronized (lock1) { // Блокируем первый монитор
                System.out.println("Thread 1: Holding lock 1..."); // Поток 1 захватил монитор 1
                try {
                    Thread.sleep(100); // Имитация задержки
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Waiting for lock 2..."); // Поток 1 ожидает второй монитор
                synchronized (lock2) { // Попытка захвата второго монитора (возникновение deadlock)
                    System.out.println("Thread 1: Holding lock 1 and lock 2..."); // Недостижимая строка кода, так как поток 1 заблокировался
                }
            }
        } else if (Thread.currentThread().getName().equals("Thread2")) { // Проверяем имя текущего потока
            synchronized (lock2) { // Блокируем второй монитор
                System.out.println("Thread 2: Holding lock 2..."); // Поток 2 захватил монитор 2
                try {
                    Thread.sleep(100); // Имитация задержки
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Waiting for lock 1..."); // Поток 2 ожидает первый монитор
                synchronized (lock1) { // Попытка захвата первого монитора (возникновение deadlock)
                    System.out.println("Thread 2: Holding lock 2 and lock 1..."); // Недостижимая строка кода, так как поток 2 заблокировался
                }
            }
        }
    }
}
