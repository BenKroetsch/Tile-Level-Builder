package inputs;

import Level.LevelManager;
import ui.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {
    private GamePanel gamePanel;
    private LevelManager levelManager;

    public Mouse(GamePanel gamePanel, LevelManager levelManager) {
        this.gamePanel = gamePanel;
        this.levelManager = levelManager;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

            levelManager.editLevel(e.getX(), e.getY());
            gamePanel.repaint();
        System.out.println(levelManager.a);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mousePressed(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
