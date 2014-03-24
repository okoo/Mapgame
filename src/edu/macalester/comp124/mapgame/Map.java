package edu.macalester.comp124.mapgame;

/**
 * Created by oliverkoo on 3/13/14.
 */
public class Map {

    char playerCharacter = '@';
    char groundCharacter = '-';

    int width, height;
    char[][] map;
    int playerX, playerY;
    int objectX, objectY;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new char[width][height];
        fill(groundCharacter);
    }

    public void fill(char c) {
        for (int x = 0; x < width; x++) {

            for (int y = 0; y < height; y++) {

                map[x][y] = c;
            }
        }

    }

    public void setPlayerLocation(int x, int y) {
        playerX = x;
        if (playerX < 0) {
            playerX = 0;
        }
        if (playerX > width - 1) {
            playerX = width - 1;
        }
        playerY = y;
        if (playerY < 0) {
            playerY = 0;
        }
        if (playerY > height - 1) {
            playerY = height - 1;
        }
        map[playerX][playerY] = playerCharacter;
    }

    public void setObjectLocation(int x, int y) {
        objectX = x;
        if (objectX < 0) {
            objectY = 0;
        }
        if (objectX > width - 1) {
            objectY = width - 1;
        }
        objectY = y;
        if (objectY < 0) {
            objectY = 0;
        }
        if (objectY > height - 1) {
            objectY = height - 1;
        }
    }

    public void movePlayer(char direction) {

        switch (direction) {
            case 'N':
            case 'n':
                map[playerX][playerY] = groundCharacter;
                setPlayerLocation(playerX, playerY - 1);
                break;
            case 'S':
            case 's':
                map[playerX][playerY] = groundCharacter;
                setPlayerLocation(playerX, playerY + 1);
                break;
            case 'E':
            case 'e':
                map[playerX][playerY] = groundCharacter;
                setPlayerLocation(playerX + 1, playerY);
                break;
            case 'W':
            case 'w':
                map[playerX][playerY] = groundCharacter;
                setPlayerLocation(playerX - 1, playerY);
                break;
        }
    }

    public int distance() {
        int distance_x = playerX - objectX;
        int distance_y = playerY - objectY;
        return Math.abs(distance_x) + Math.abs(distance_y);
    }

    @Override
    public String toString() {
        String output = "";
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                output += map[x][y];
            }
            output += System.lineSeparator();
        }
        return output;
    }

    public boolean objectFound() {
        return ((playerX == objectX) && (playerY == objectY));
    }
}
