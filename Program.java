package lesson5;

public class Program {
    public static void main(String[] args) {
        Staff[] staffArray = new Staff[5];
        staffArray[0] = new Staff("Владимир", "Java-разработчик", "vladimir@mail.ru",
                "9197239855", 199900, 30);
        staffArray[1] = new Staff("Александр", "Бухгалтер", "aleksandr@mail.ru",
                "9197335412", 145000, 41);
        staffArray[2] = new Staff("Татьяна", "Юрист", "tata@mail.ru",
                "9162540022", 185000, 25);
        staffArray[3] = new Staff("Елена", "Маркетолог", "elena@mail.ru",
                "9152587474", 160000, 49);
        staffArray[4] = new Staff("Петр", "Водитель погрузчика", "petr@mail.ru",
                "9261238851", 145000, 28);

        for (Staff staff : staffArray) {
            if (staff.getAge() > 40) staff.staffInfo();
        }
    }
}
