package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {

        String[] strings = {"First", "Second", "Third", "Fourth", "Five"};
        //task1
        swapElements(1, 3, strings);
        System.out.println(Arrays.toString(strings));

        //task2
        convertArrayToArrayList(strings);
        System.out.println(Arrays.toString(strings));

        //task3
        Box<Apple> appleBox1 = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();
        for (int i = 0; i < 10; i++) {
            appleBox1.add(new Apple());
            orangeBox1.add(new Orange());
        }
        System.out.println(appleBox1.getFruits() + " " + appleBox1.getWeight());
        System.out.println(orangeBox1.getFruits() + " " + orangeBox1.getWeight());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.add(new Apple());
        appleBox1.moveAllToNextBox(appleBox2);
        System.out.println(appleBox1.getFruits());
        System.out.println(appleBox2.getFruits());
        System.out.println(appleBox1.compare(orangeBox1));

                
    }

    private static <T> ArrayList<T> convertArrayToArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    private static <T> void swapElements(int index1, int index2, T[] array) {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
