package lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }
    public void add(T fruit) {
        fruits.add(fruit);
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void addFruits(ArrayList<T> fruits) {
        this.fruits.addAll(fruits);
    }
    public float getWeight() {
        float totalWeight = 0.0f;
        for (T fruit : fruits)
            totalWeight += fruit.getWeight();
        return totalWeight;
    }
    public boolean compare(Box<?> box) {
        return Float.compare(getWeight(), box.getWeight()) == 0;
    }
    public void moveAllToNextBox(Box<T> box) {
        box.addFruits(getFruits());
        fruits.clear();
    }
}
