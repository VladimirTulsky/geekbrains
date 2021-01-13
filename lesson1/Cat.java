package lesson1;

public class Cat implements Compatible {
    private final String name;
    private final int runDistance;
    private final double jumpHeight;

    public Cat(String name, int runDistance, double jumpHeight) {
        this.name = name;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRunDistance() {
        return runDistance;
    }

    @Override
    public double getJumpHeight() {
        return jumpHeight;
    }

    @Override
    public void jump() {
        System.out.print(name + " перепрыгнул препятствие, длина дистанции: ");
    }

    @Override
    public void run() {
        System.out.print(name + " пробежал дорожку, длина дистанции: ");
    }
}
