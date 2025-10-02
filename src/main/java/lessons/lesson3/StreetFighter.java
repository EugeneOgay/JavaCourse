package main.java.lessons.lesson3;

import java.util.ArrayList;
import java.util.Random;

public class StreetFighter {
    public static ArrayList<Fighter> fighters = new ArrayList<>();
    public static void AddAFighter(Fighter fighter) {
        fighters.add(fighter);
    }
    public static void GetFighters() {
        if (!fighters.isEmpty()) {
            for (Fighter fighter : fighters) {
                fighter.GetFighterInfo();
            }
        } else System.out.println("Нет бойцов\n");
    }

    public static void GetFighterInfo(String name) {
        var foundFighter = fighters.stream().filter(f -> f.name.equalsIgnoreCase(name)).findFirst().orElse(null);
        foundFighter.GetFighterInfo();
    }

    public static void Fight(String firstFighterName, String secondFighterName) {
        var firstFighter = fighters.stream().filter(f -> f.name.equalsIgnoreCase(firstFighterName)).findFirst().orElse(null);
        var secondFighter = fighters.stream().filter(f -> f.name.equalsIgnoreCase(secondFighterName)).findFirst().orElse(null);
        Random r = new Random();
        String firstToAttack = r.nextInt(2) == 0 ? firstFighterName : secondFighterName;
        if(firstToAttack  ==  firstFighterName) {
            do {
                secondFighter.health = secondFighter.health - firstFighter.attack;
                firstFighter.health = firstFighter.health - secondFighter.attack;
            } while (firstFighter.health > 0 && secondFighter.health > 0);
        } else {
            do {
                firstFighter.health = firstFighter.health - secondFighter.attack;
                secondFighter.health = secondFighter.health - firstFighter.attack;
            } while (firstFighter.health > 0 && secondFighter.health > 0);
        }
        if(firstFighter.health > secondFighter.health) {
            System.out.printf("Победил боец %s\n", firstFighter.name);
        } else {
            System.out.printf("Победил боец %s\n", secondFighter.name);
        }
    }

    public static class Fighter {
        private int code;
        private String name;
        private int health;
        private int attack;

        public Fighter(int code, String name, int health, int attack) {
            this.code = code;
            this.name = name;
            this.health = health;
            this.attack = attack;
        }

        public void GetFighterInfo() {
            System.out.printf("Код: %d, Имя: %s, Здоровье: %d, Аттака: %d\n", code, name,  health, attack);
        }
    }
}


