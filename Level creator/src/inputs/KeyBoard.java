package inputs;

import Level.LevelManager;
import ui.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_W;

public class KeyBoard implements KeyListener {
    private GamePanel gamePanel;
    private LevelManager levelManager;

    public KeyBoard(GamePanel game, LevelManager levelManager) {
        this.gamePanel = game;
        this.levelManager = levelManager;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == VK_W) {
            levelManager.selector();
            gamePanel.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
