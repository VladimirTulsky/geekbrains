package lesson3;

import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {
        System.out.println(stringReplace());
        guessNum();
        guessFood();

    }

    private static StringBuilder stringReplace () {
        String s = "Предложение    один   Теперь   предложение   два    Тут   предложение   три";
        String s1 = s.replaceAll(" +", " ");

        StringBuilder s2 = new StringBuilder(s1);

        for (int i = 1; i < s1.length(); i++) {
            if(s1.charAt(i) >= 'А' && s1.charAt(i) <= 'Я') {
                s2.setCharAt(i - 1, '.');
            }
        }
        for (int i = 1; i < s2.length(); i++) {

            if (s2.charAt(i) == '.') {
                s2.insert(i + 1, " ");
            }
        }
        s2.insert(s2.length(), ".");
        return s2;
    }

    private static void guessNum () {
        while (true) {
            Random random = new Random();
            int num = random.nextInt(10);
            Scanner sc = new Scanner(System.in);
            int counter = 0;
            while (counter < 3) {
                System.out.println("Угадайте число от 0 до 9: ");
                int userNum = sc.nextInt();
                if (userNum == num) {
                    System.out.printf("Вы выиграли, загаданное число: %d \n", num);
                    break;
                } else if (userNum > num) {
                    System.out.println("Загаданное число меньше!");
                    counter++;
                } else {
                    System.out.println("Загаданное число больше!");
                    counter++;
                }
            }
            if (counter > 2) System.out.println("Вы проиграли");
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            int repeat = sc.nextInt();
            if(repeat == 0) break;
        }
    }

    private static void guessFood() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        int num = random.nextInt(25);
        String s = words[num];
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Угадайте еду: ");
            String s1 = sc.nextLine();
            int counter = Math.min(s.length(), s1.length());
            if (s.equals(s1.toLowerCase())) {
                System.out.println("Вы выиграли, загаданная еда " + s);
                break;
            } else {
                System.out.println("Не верно, слово: ");
                for (int i = 0; i < counter; i++) {
                    if (s.charAt(i) == s1.charAt(i)) {
                        System.out.print(s.charAt(i));
                    } else {
                        System.out.print("#");
                    }
                }
                for (int i = 0; i < 15 - counter; i++) {
                    System.out.print("#");
                }
                System.out.println();
            }
        }
    }

}