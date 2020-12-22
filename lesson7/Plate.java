package lesson7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
        if(isAnyFood(n)) {
            food -= n;
        } else System.out.println("В тарелке недостаточно еды");
    }
    public void addFood(int n) {
        food += n;
        System.out.println("В тарелку добавили " + n + " еды. " + "Сейчас в ней " + food + " еды");
    }

    public boolean isAnyFood(int n) {
        return food - n >= 0;
    }

    public void info() {
        System.out.println("В тарелке " + food + " еды");
    }
}

