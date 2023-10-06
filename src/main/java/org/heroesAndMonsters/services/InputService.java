package org.heroesAndMonsters.services;

import org.heroesAndMonsters.gameplay.Dialog;

import java.util.Scanner;

public class InputService {
    private final int LOW_BORDER = 1;
    private final int HIGH_BORDER = 30;
    private int value = 0;
    Scanner scanner = new Scanner(System.in);
    Dialog dialog = new Dialog();

    public String inputName() {
        String name = null;
        while (name == null) {
            System.out.println("\u001b[36m" + dialog.INPUT_NAME + "\u001b[0m");
            name = scanner.nextLine();
        }
        return name;
    }

    public int inputAttack() {
        return valueCheck(dialog.INPUT_ATTACK, LOW_BORDER, HIGH_BORDER);
    }

    public int inputDefense() {
        return valueCheck(dialog.INPUT_DEFENSE, LOW_BORDER, HIGH_BORDER);
    }

    public int inputHealth() {
        return valueCheck(dialog.INPUT_HEALTH, LOW_BORDER, Integer.MAX_VALUE);
    }

    public int inputMinDamage() {
        return valueCheck(dialog.INPUT_MIN_DAMAGE, LOW_BORDER, Integer.MAX_VALUE);
    }

    public int inputMaxDamage(int minDamage) {
        return valueCheck(dialog.INPUT_MAX_DAMAGE, minDamage, Integer.MAX_VALUE);
    }

    public boolean yesOrNot() {
        boolean yesOrNot = false;
        String answer;
        while (true) {
            System.out.println(dialog.YES_OR_NO_MESSAGE);
            answer = scanner.nextLine();
            if ("y".equalsIgnoreCase(answer)) {
                yesOrNot = true;
                break;
            } else if ("n".equalsIgnoreCase(answer)) {
                break;
            } else {
                dialog.answerIncorrect(answer);
            }
        }
        return yesOrNot;
    }

    private int valueCheck(String message, int min, int max) {
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                System.out.println("\u001b[36m" + message + "\u001b[0m");
                value = scanner.nextInt();
                if (value >= min && value <= max) {
                    isValidInput = true;
                } else {
                    System.err.println(dialog.INVALID_VALUE);
                }
            } catch (Exception e) {
                System.err.println(dialog.ERROR);
                scanner.nextLine();
            }
        }
        return value;
    }
}

