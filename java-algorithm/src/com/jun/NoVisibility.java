package com.jun;

/**
 * @author Jun
 * @date 2020/6/18 下午4:07
 */
public class NoVisibility {
    private volatile static boolean ready;
    private volatile static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
