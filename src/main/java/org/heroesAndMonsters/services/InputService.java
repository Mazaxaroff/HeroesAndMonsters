package org.heroesAndMonsters.services;

import java.util.Scanner;

public class InputService {
    private final String INPUT_NAME = "Введите имя.";
    private final String INPUT_ATTACK = "Введите значение атаки (от 1 до 30)";
    private final String INPUT_DEFENSE = "Введите значение защиты (от 1 до 30)";
    private final String INPUT_HEALTH = "Введите значение здоровья (больше 0)";
    private final String INPUT_MIN_DAMAGE = "Введите значение минимального урона (больше 0)";
    private final String INPUT_MAX_DAMAGE = "Введите значение максимального урона (больше минимального урона)";
    private final String INVALID_VALUE = "Вы ввели не верное значение, попробуйте еще раз.";
    private final String ERROR = "Неверный тип данных. Пожалуйста введите целое число.";
    private final String YES_OR_NO_MESSAGE = "Введите y (да) или n (нет)";
    private final int LOW_BORDER = 1;
    private final int HIGH_BORDER = 30;
    private int value = 0;
    Scanner scanner = new Scanner(System.in);

    public String inputName() {
        String name = null;
        while (name == null) {
            System.out.println(INPUT_NAME);
            name = scanner.nextLine();
        }
        return name;
    }

    public int inputAttack() {
        return valueCheck(INPUT_ATTACK, LOW_BORDER, HIGH_BORDER);
    }

    public int inputDefense() {
        return valueCheck(INPUT_DEFENSE, LOW_BORDER, HIGH_BORDER);
    }

    public int inputHealth() {
        return valueCheck(INPUT_HEALTH, LOW_BORDER, Integer.MAX_VALUE);
    }

    public int inputMinDamage() {
        return valueCheck(INPUT_MIN_DAMAGE, LOW_BORDER, Integer.MAX_VALUE);
    }

    public int inputMaxDamage(int minDamage) {
        return valueCheck(INPUT_MAX_DAMAGE, minDamage, Integer.MAX_VALUE);
    }

    public boolean yesOrNot() {
        boolean yesOrNot = false;
        String answer;
        while (true) {
            System.out.println(YES_OR_NO_MESSAGE);
            answer = scanner.nextLine();
            if ("y".equalsIgnoreCase(answer)) {
                yesOrNot = true;
                break;
            } else if ("n".equalsIgnoreCase(answer)) {
                break;
            } else {
                System.out.println("Ответ " + answer + " не корректный!\n");
            }
        }
        return yesOrNot;
    }

    private int valueCheck(String message, int min, int max) {
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                System.out.println(message);
                value = scanner.nextInt();
                if (value >= min && value <= max) {
                    isValidInput = true;
                } else {
                    System.out.println(INVALID_VALUE);
                }
            } catch (Exception e) {
                System.out.println(ERROR);
                scanner.nextLine();
            }
        }
        return value;
    }
}

