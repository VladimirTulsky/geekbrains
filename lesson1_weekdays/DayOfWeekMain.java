package lesson1_weekdays;

public class DayOfWeekMain {

    public static void getWorkingHours(DayOfWeek day) {
        String s;
        switch (day) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                s = "Осталось рабочих часов: " + day.getHours();
            break;
            default: s = "Сегодня выходной";
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        getWorkingHours(DayOfWeek.WEDNESDAY);


    }
}
