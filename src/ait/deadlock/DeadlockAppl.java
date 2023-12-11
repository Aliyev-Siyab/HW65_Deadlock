package ait.deadlock;

import ait.deadlock.task.Deadlock;

public class DeadlockAppl {
    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock(); // Создаем объект класса Deadlock

        // Создаем два потока, использующих один и тот же объект deadlock
        Thread thread1 = new Thread(deadlock, "Thread1");
        Thread thread2 = new Thread(deadlock, "Thread2");

        thread1.start(); // Запускаем поток 1
        thread2.start(); // Запускаем поток 2
    }
}