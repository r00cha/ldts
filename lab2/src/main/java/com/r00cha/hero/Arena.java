package com.r00cha.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {

    private int height;
    private int width;

    private List<Wall> walls;
    private List<Coin> coins;

    private List<Monster> monsters;
    private Hero hero;

    Arena(int width, int height){
        this.height = height;
        this.width = width;
        hero = new Hero(10, 10);
        this.walls = createWalls();
        coins = createCoins();
        monsters = createMonsters();
    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1,
                    random.nextInt(height - 2) + 1));
        return coins;
    }
    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1,
                    random.nextInt(height - 2) + 1));
        return monsters;
    }

    private boolean canHeroMove(Position position){

        for (Wall wall : walls){
            if (wall.getPosition().equals(position)){
                return false;
            }
        }
        return true;
    }
    private void moveHero(Position position) {
        if (canHeroMove(position)){
            hero.setPosition(position);
        }

    }

    private void moveMonsters(){
        for (Monster monster : monsters){
            Position monsterPosition = monster.move();
            if(canHeroMove(monsterPosition)){
                monster.setPosition(monsterPosition);
            }

        }
    }
    public void verifyMonsterCollisions(){
        for(Monster monster : monsters){
            if(monster.position.equals(hero.position)){
                System.out.println("GAME OVER!");
                System.exit(0);

                }
            }
    }

    public void processKey(KeyStroke key) throws IOException {
        switch (key.getKeyType()){
            case ArrowUp:
                moveHero(hero.moveUp());

                break;
            case ArrowDown:
                moveHero(hero.moveDown());

                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());

                break;
            case ArrowRight:
                moveHero(hero.moveRight());

                break;

        }
        verifyMonsterCollisions();
        moveMonsters();
        verifyMonsterCollisions();

    }
    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#ffcc66"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, width), ' ');
        hero.draw(graphics);
        for (Wall wall : walls) wall.draw(graphics);
        for (Coin coin : coins) {
            if(retrieveCoins()){
                break;
            }
        }
        for (Coin coin : coins) {
            coin.draw(graphics);
        }
        for(Monster monster : monsters){
            monster.draw(graphics);
        }

    }
    public void setPosition(Position position){hero.setPosition(position);}

    private boolean retrieveCoins(){
        boolean flag = false;
        for(Coin coin : coins){
            if (hero.position.equals(coin.position)){
                coins.remove(coin);
                flag = true;
                break;
            }
        }
        return flag;
    }


}
