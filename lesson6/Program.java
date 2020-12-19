package lesson6;

public class Program {
    public static void main(String[] args) {
        Animal cat1 = new Cat();
        Animal dog1 = new Dog();
        Animal dog2 = new Dog(800, 30,1.5);

        cat1.run(190);
        cat1.swim(5);
        cat1.jump(1.5);
        dog1.run(290);
        dog1.jump(1);
        dog1.swim(12);
        dog2.run(600);
        dog2.swim(27);
        dog2.jump(1.5);

    }
}
