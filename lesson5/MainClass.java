package lesson5;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        Calculate c1 = new Calculate();
        c1.calcOneThread();
        c1.calcTwoThreads();
    }
}
