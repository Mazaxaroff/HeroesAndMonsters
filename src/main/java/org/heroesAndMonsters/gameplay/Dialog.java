package org.heroesAndMonsters.gameplay;

import org.heroesAndMonsters.models.Creature;

import java.util.Map;

public class Dialog {
    public final String LETS_START = "Добро пожаловать в игру \"Герои против Монстров\"! \n" +
            "Пришло время создать героя, готового дать отпор монстрам!";
    public final String INPUT_NAME = "Введите имя.";
    public final String INPUT_ATTACK = "Введите значение атаки (от 1 до 30)";
    public final String INPUT_DEFENSE = "Введите значение защиты (от 1 до 30)";
    public final String INPUT_HEALTH = "Введите значение здоровья (больше 0)";
    public final String INPUT_MIN_DAMAGE = "Введите значение минимального урона (больше 0)";
    public final String INPUT_MAX_DAMAGE = "Введите значение максимального урона (больше минимального урона)";
    public final String INVALID_VALUE = "Вы ввели не верное значение, попробуйте еще раз.";
    public final String ERROR = "Неверный тип данных. Пожалуйста введите целое число.";
    public final String YES_OR_NO_MESSAGE = "Введите y (да) или n (нет)";

    public void answerIncorrect(String answer) {
        System.err.println("Ответ " + answer + " не корректный!\n");
    }

    public void heroIsReady(Creature creature) {
        System.out.printf("Герой %s готов к сражению!\n", creature.getName());
    }

    public void monsterIsComing(Creature creature) {
        System.out.printf("%s врывается на поле боя!\n", creature.getName());
        getInfo(creature);
    }

    public void getInfo(Creature creature) {
        System.out.printf("Имя - %s, атака - %d, защита - %d, здоровье - %d, минимальный урон - %d, " +
                        "максимальный урон - %d \n", creature.getName(), creature.getAttack(),
                creature.getDefense(), creature.getHealth(), creature.getDamageMin(), creature.getDamageMax());
    }

    public void battleBegin(String player, String monster) {
        System.out.printf("Начинается битва между %s и %s \n", player, monster);
    }

    public void hit(String attacking, String defending, int damage, int remainsOfHealth) {
        System.out.printf("%s наносит %s %d урона. У %s осталось %d здоровья. \n",
                attacking, defending, damage, defending, remainsOfHealth);
    }

    public void youNeedToHillUp() {
        System.out.println("Ваш уровень здоровья слишком низкий, желаете исцелиться?");
    }

    public void successfulHillUp(int health, int potionCounts) {
        System.out.printf("Вы исцелились! Ваше здоровье равно %d У вас осталось %d зелий исцеления. \n", health, potionCounts);
    }

    public void resultOfTheBattle(Creature winner, Creature loser) {
        System.out.printf("%s оказался сильнее! Битва окончена. \n", (winner.isAlive()) ? winner.getName() : loser.getName());
        System.out.printf("%s отправляется на кладбище кормить червей! \n", (winner.isAlive()) ? loser.getName() : winner.getName());
    }

    public void resultOfTheGame(Map<String, Integer> graveyard) {
        System.out.println("Игра окончена! Вот список побежденных вами монстров: " + graveyard.entrySet());
    }
}
