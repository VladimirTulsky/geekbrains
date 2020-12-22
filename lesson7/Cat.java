package lesson7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }
    public void eat(Plate p) {
        if(satiety) return;
        if(p.isAnyFood(appetite) && !satiety) {
            p.decreaseFood(appetite);
            satiety = true;
        } else {
            satiety = false;
        }
        info();
    }
    public void info() {
        String s;
        if(satiety) {
            s = " поел, и он сыт";
        } else s = " не смог поесть, и он голоден";
        System.out.println(name + s);
    }
}

