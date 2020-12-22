package lesson7;

public class MainClass {
    public static void main(String[] args) {
        Plate plate = new Plate(100);
        Cat[] cats = new Cat[]{
                new Cat ("Barsik", 11), new Cat("Johny", 15),
                new Cat ("Finch", 20), new Cat("Dirk", 12),
                new Cat ("Alfa", 23), new Cat("Toma", 13),
                new Cat ("Gena", 14), new Cat("Khlebushek", 5)
        };
        plate.info();
        for (Cat cat : cats) {
            cat.eat(plate);
        }
        plate.info();
        plate.addFood(20);
        for (Cat cat : cats) {
            cat.eat(plate);
        }
    }
}

