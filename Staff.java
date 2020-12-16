package lesson5;

public class Staff {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Staff(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void staffInfo() {
        System.out.printf("Сотрудник: %s\nДолжность: %s\nemail: %s\nНомер телефона: %s\nЗарплата: %d\nВозраст: %d\n",
                name, position, email, phoneNumber, salary, age);
        System.out.println();
    }


}
