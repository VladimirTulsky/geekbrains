package lesson1;

public class Wall extends Let {
    private final double wallHeight;

    public Wall(double wallHeight) {
        this.wallHeight = wallHeight;
    }

    @Override
    public int getSIGN() {
        return 2;
    }

    @Override
    public double getWallHeight() {
        return wallHeight;
    }
}
