package org.heroesAndMonsters;

import org.heroesAndMonsters.models.Monster;
import org.heroesAndMonsters.models.Player;
import org.heroesAndMonsters.services.InputService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        InputService inputService = new InputService();
        System.out.println("Создаем героя!");
        Player player = new Player();
        System.out.println("Герой создан! \n");
        player.getInfo();

        System.out.println("Создаем монстра!");
        Monster monster = new Monster();
        System.out.println("Монстр создан! \n");
        monster.getInfo();

        System.out.printf("Начинается битва %s и %s \n", player.getName(), monster.getName());
        while (player.isAlive() && monster.isAlive()) {
            System.out.printf("%s бьет %s \n", player.getName(), monster.getName());
            player.hit(monster);
            Thread.sleep(1000);
            System.out.printf("у %s осталось %d здоровья \n", monster.getName(), monster.getHealth());

            if (monster.isAlive()) {
                System.out.printf("%s бьет %s \n", monster.getName(), player.getName());
                monster.hit(player);
            }
            Thread.sleep(1000);
            System.out.printf("у %s осталось %d здоровья \n", player.getName(), player.getHealth());
            if (player.getHealth()< player.getMaxHealth()/2 && player.isAlive() && player.getCountOfHills()>0){
                System.out.println("Ваш уровень здоровья слишком низкий, желаете исцелиться?");
                if (inputService.yesOrNot()){
                    player.hillUp();
                    System.out.println("Вы исцелились! Ваше здоровье равно " + player.getHealth() + " У вас осталось "
                            + player.getCountOfHills() + " зелий исцеления.");
                }
            }
        }

        System.out.printf("%s оказался сильнее! Битва окончена.", (player.isAlive()) ? player.getName(): monster.getName());
    }
}