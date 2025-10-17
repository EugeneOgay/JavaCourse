package main.java.lessons.lesson3;

import java.util.ArrayList;
import java.util.Random;

public class StreetFighter {
    private ArrayList<Fighter> fighters = new ArrayList<>();

    public void addAFighter(Fighter fighter) {
        fighters.add(fighter);
    }

    public void getFighters() {
        if (!fighters.isEmpty()) {
            for (Fighter fighter : fighters) {
                fighter.getFighterInfo();
            }
        } else System.out.println("Нет бойцов\n");
    }

    public void getFighterInfo(String name) {
        var foundFighter = fighters.stream().filter(f -> f.name.equalsIgnoreCase(name)).findFirst().orElse(null);
        foundFighter.getFighterInfo();
    }

    public void fight(String firstFighterName, String secondFighterName) {
        var firstFighter = fighters.stream().filter(f -> f.name.equalsIgnoreCase(firstFighterName)).findFirst().orElse(null);
        var secondFighter = fighters.stream().filter(f -> f.name.equalsIgnoreCase(secondFighterName)).findFirst().orElse(null);
        Random r = new Random();
        String firstToAttack = r.nextInt(2) == 0 ? firstFighterName : secondFighterName;
        if(firstToAttack.equalsIgnoreCase(firstFighterName)) {
            fightAction(firstFighter, secondFighter);
        } else fightAction(secondFighter, firstFighter);
    }

    private void fightAction(Fighter firstAttacker, Fighter secondAttacker){
        do {
            secondAttacker.health = secondAttacker.health - firstAttacker.attack;
            firstAttacker.health = firstAttacker.health - secondAttacker.attack;
        } while (firstAttacker.health > 0 && secondAttacker.health > 0);
        if(firstAttacker.health > secondAttacker.health) {
            System.out.printf("Победил боец %s\n", firstAttacker.name);
        } else {
            System.out.printf("Победил боец %s\n", secondAttacker.name);
        }
    }

    public class Fighter {
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

        public void getFighterInfo() {
            System.out.printf("Код: %d, Имя: %s, Здоровье: %d, Аттака: %d\n", code, name,  health, attack);
        }
    }
}


