package lesson4hw;



public class Task1 {
    static String a = "A";

    public static void main(String[] args) {
        MyThread.thread("A", "B");
        MyThread.thread("B", "C");
        MyThread.thread("C", "A");
    }

     static class MyThread {
        static Object sync = new Object();

        private static void thread(String current, String next) {
            new Thread(()-> {
                for (int i = 0; i < 5; i++) {
                    synchronized (sync) {
                        try {
                            while (!a.equals(current)) sync.wait();
                            System.out.print(a);
                            a = next;
                            sync.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
