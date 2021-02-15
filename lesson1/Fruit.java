package lesson1;

abstract class Fruit {
    protected float weight;
    protected String name;

    public Fruit(float weight, String name) {
        this.name = name;
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + " = " + getWeight();
    }
}
