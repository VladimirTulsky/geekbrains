package lesson5;

public class Calculate {

    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

    public void calcOneThread () {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
        }
        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a);

    }

    public void calcTwoThreads () throws InterruptedException {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5.0) *
                        Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + (i + h) / 5.0) *
                        Math.cos(0.2f + (i + h) / 5.0) * Math.cos(0.4f + (i + h) / 2.0));
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a);
    }
}
