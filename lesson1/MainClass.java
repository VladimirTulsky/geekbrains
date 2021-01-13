package lesson1;

public class MainClass {
    public static void main(String[] args) {
        Let[] lets = {
                new Treadmill(100), new Wall(0.5),
                new Treadmill(150), new Wall(1.5),
                new Treadmill(250), new Wall(3)
        };
        Compatible[] participants = {
                new Human("Сергей", 170, 0.6),
                new Cat("Барсик", 260, 2),
                new Robot("Прототип154", 400, 4)
        };

        for (Compatible participant : participants) {
            for (Let let : lets) {
                //Если участник не может пробежать дистанцию, то снимаем его с джистанции
                if (participant.getRunDistance() < let.getDistanceLength() && let.getSIGN() == 1) {
                    System.out.println(participant.getName() + " сошел с дистанции");
                    break;
                }
                //если препятствие беговая дорожка, то выводим сообщение о беге
                if (let.getSIGN() == 1) {
                    participant.run();
                    System.out.println(let.getDistanceLength());
                }
                //Если участник не может перепрыгнуть стену, то снимаем его с джистанции
                if (participant.getJumpHeight() < let.getWallHeight() && let.getSIGN() == 2) {
                    System.out.println(participant.getName() + " сошел с дистанции");
                    break;
                }
                //если препятствие стена, то выводим сообщение о прыжке
                if (let.getSIGN() == 2) {
                    participant.jump();
                    System.out.println(let.getWallHeight());
                }

            }
        }

    }
}
