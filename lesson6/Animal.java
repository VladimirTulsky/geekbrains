package lesson6;

abstract class Animal {
    protected int runDistance;
    protected int swimDistance;
    protected double jumpHeight;

    protected void run(int distance) {
        System.out.println("Run: " + (distance >= 0 && distance <= runDistance));
    }
    protected void swim(int distance) {
        System.out.println("Swim: " + (distance >= 0 && distance <= swimDistance));
    }
    protected void jump(double height) {
        System.out.println("Jump: " +  (height >= 0 && height <= jumpHeight));
    }
}
