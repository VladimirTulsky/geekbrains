package lesson3;

public class MainClass {

    public static void main(String[] args) {
        String[] mass = {"Яблоко", "Груша", "Апельсин", "Яблоко", "Персик",
                "Яблоко", "Персик", "Лимон", "Грейпфрут", "Лимон"};
        SimilarSearch.searchQuantity(mass);
        SimilarSearch.searchUnique(mass);

        PhoneBook.add("Иванов", "+7(919)123-45-67");
        PhoneBook.add("Калашников", "+7(916)345-11-32");
        PhoneBook.add("Иванов", "+7(926)365-43-16");
        PhoneBook.add("Петров", "+7(919)333-34-21");
        PhoneBook.add("Путин", "+7(910)234-99-12");
        PhoneBook.add("Навальный", "+7(916)222-54-39");
        PhoneBook.get("Иванов");
        PhoneBook.get("Навальный");
    }
}