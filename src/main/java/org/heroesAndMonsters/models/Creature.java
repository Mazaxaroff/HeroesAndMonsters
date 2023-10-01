package org.heroesAndMonsters.models;

import lombok.Data;

import java.util.Random;
import java.util.Scanner;

@Data
public class Creature {
    private String name;
    private int attack;
    private int defense;
    private int health;
    private int damageMin;
    private int damageMax;
    private boolean isAlive;

    public Creature() {
        String error = "Вы ввели некорректное значение, попробуйте еще раз.";
        Scanner scanner = new Scanner(System.in);

        while (this.name == null) {
            System.out.println("Введите имя");
            this.setName(scanner.nextLine());
        }
        while (this.attack == 0) {
            System.out.println("Введите значение атаки (от 1 до 30)");
            int attack = scanner.nextInt();
            if (attack >= 1 && attack <= 30) {
                this.setAttack(attack);
            } else {
                System.out.println(error);
            }
        }
        while (this.defense == 0) {
            System.out.println("Введите значение защиты (от 1 до 30)");
            int defense = scanner.nextInt();
            if (defense >= 1 && defense <= 30) {
                this.setDefense(defense);
            } else {
                System.out.println(error);
            }
        }
        while (this.health == 0) {
            System.out.println("Введите значение здоровья (больше 0)");
            int health = scanner.nextInt();
            if (health > 0) {
                this.setHealth(health);
            } else {
                System.out.println(error);
            }
        }
        while (this.damageMin == 0) {
            System.out.println("Введите значение минимального урона (больше 0)");
            int damageMin = scanner.nextInt();
            if (damageMin > 0) {
                this.setDamageMin(damageMin);
            } else {
                System.out.println(error);
            }
        }
        while (this.damageMax == 0) {
            System.out.println("Введите значение максимального урона (больше минимального урона)");
            int damageMax = scanner.nextInt();
            if (damageMax > this.damageMin) {
                this.setDamageMax(damageMax);
            } else {
                System.out.println(error);
            }
        }
        this.isAlive = true;
    }

    public void getInfo() {
        System.out.printf("Имя - %s, атака - %d, защита - %d, здоровье - %d, минимальный урон - %d, " +
                "максимальный урон - %d \n", this.name, this.attack, this.defense, this.health, this.damageMin, this.damageMax);
    }

    public void hit(Creature creature) {
        Random random = new Random();
        int attackModifier = this.attack - (creature.defense + 1);
        int cubeFace;
        do {
            cubeFace = random.nextInt(1, 6);
            if (cubeFace >= 5) {
                creature.setHealth(creature.health - random.nextInt(this.damageMin, this.damageMax));
                if (creature.health <= 0) {
                    creature.die();
                }
                attackModifier--;
            }
        } while (attackModifier > 0);
    }

    public void die() {
        this.setAlive(false);
    }
}
