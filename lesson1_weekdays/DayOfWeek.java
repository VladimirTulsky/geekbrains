package lesson1_weekdays;

public enum DayOfWeek {
    MONDAY(40), TUESDAY(32), WEDNESDAY(24), THURSDAY(16),
    FRIDAY(8), SATURDAY(0), SUNDAY(0);

    private double hours;

    DayOfWeek(double hours) {
        this.hours = hours;
    }

    public double getHours() {
        return hours;
    }

}
