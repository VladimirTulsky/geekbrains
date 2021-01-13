package lesson1;

public class Treadmill extends Let {
    private final int distanceLength;

    public Treadmill(int distanceLength) {
        this.distanceLength = distanceLength;
    }

    @Override
    public int getSIGN() {
        return 1;
    }

    @Override
    public int getDistanceLength() {
        return distanceLength;
    }

}
