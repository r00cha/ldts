package com.r00cha.hero;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;


public class Game {
    private Screen screen;
    private Arena arena;


    public Game(int height, int width) throws IOException{
            TerminalSize terminalSize = new TerminalSize(height, width);
            DefaultTerminalFactory terminalFactory = new
                    DefaultTerminalFactory()
                    .setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary
            arena = new Arena(height,width);


    }

    private void draw() throws IOException{
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException {
        while (true){
            draw();
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.EOF) break;
            else if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                screen.close();
            }
            processKey(key);

        }


    }
    private void moveHero(Position position) {
        arena.setPosition(position);
    }

    private void processKey(KeyStroke key) throws IOException {
        arena.processKey(key);
    }


}


