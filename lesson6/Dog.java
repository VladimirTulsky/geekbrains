package lesson6;

class Dog extends Animal {

    public Dog(int runDistance, int swimDistance, double jumpHeight) {
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
        this.jumpHeight = jumpHeight;
    }

    public Dog() {
        this.runDistance = 500;
        this.swimDistance = 10;
        this.jumpHeight = 0.5;
    }

    @Override
    protected void run(int distance) {
        super.run(distance);
    }

    @Override
    protected void swim(int distance) {
        super.swim(distance);
    }

    @Override
    protected void jump(double height) {
        super.jump(height);
    }
}
