package org.heroesAndMonsters;

import org.heroesAndMonsters.models.Monster;
import org.heroesAndMonsters.models.Player;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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
            System.out.printf("%s бьет %s \n", monster.getName(), player.getName());
            if (monster.isAlive()) {
                monster.hit(player);
            }
            Thread.sleep(1000);
            System.out.printf("у %s осталось %d здоровья \n", player.getName(), player.getHealth());
        }

        System.out.printf("%s оказался сильнее! Битва окончена.", (player.isAlive()) ? player.getName(): monster.getName());
    }
}