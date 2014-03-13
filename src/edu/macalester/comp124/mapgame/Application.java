package edu.macalester.comp124.mapgame;

import acm.program.ConsoleProgram;

import java.util.*;

/**
 * Created by oliverkoo on 3/13/14.
 */
public class Application extends ConsoleProgram {
    public void run() {
        println("welcome to map game");
        int w = readInt("your map width? ");
        int h = readInt("your map height? ");
        Map gameMap = new Map(w, h);
        gameMap.setPlayerLocation(5, 5);
        println(gameMap.toString());
        Random dice = new Random();
        int random_w = dice.nextInt(w + 1);
        int random_h = dice.nextInt(h + 1);
        println(random_w);
        println(random_h);
        gameMap.setObjectLocation(random_w, random_h);
        println("I hide an object on this map, try to find it");


        while (true) {
            int beforeDistance = gameMap.distance();
            char q = readChar("Where do you want to go? (n,s,w,e)?  ");
            gameMap.movePlayer(q);
            int afterDistance = gameMap.distance();
            print(gameMap.toString());
            if (beforeDistance > afterDistance) {
                println("you are closer!");
            } else if (beforeDistance < afterDistance) {
                println("you are further");
            }
            if (gameMap.objectFound()) {
                println("yay you found it");
                break;
            }
        }
    }
}
