package lesson6;

class Cat extends Animal {

    public Cat(int runDistance, int swimDistance, double jumpHeight) {
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
        this.jumpHeight = jumpHeight;
    }

    public Cat() {
        this.runDistance = 200;
        this.swimDistance = 0;
        this.jumpHeight = 2;
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
