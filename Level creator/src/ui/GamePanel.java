package ui;

import inputs.KeyBoard;
import inputs.Mouse;

import javax.swing.*;
import java.awt.*;

import static ui.Game.GAME_HEIGHT;
import static ui.Game.GAME_WIDTH;

public class GamePanel extends JPanel {

    private Mouse mouseInputs;
    private Game game;
    private KeyBoard keyboard;


    public GamePanel(Game game) {
        this.game = game;
        initializeMouseInputs();
        initializeKeyBoard();
        setSize();
    }



    public void initializeMouseInputs() {
        mouseInputs = new Mouse(this, game.getLevelManager());
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void initializeKeyBoard() {
        keyboard = new KeyBoard(this , game.getLevelManager());
        addKeyListener(keyboard);
    }


    public void setSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        this.setPreferredSize(size);
    }

    public void updateGame() {

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
    }

    public Game getGame() {
        return game;
    }
}