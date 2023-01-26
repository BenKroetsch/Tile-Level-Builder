package Level;

import ui.Game;
import utility.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utility.LoadSave.LEVEL1_ATLAS;

public class LevelManager {
    private final Integer subImageSize = 32;
    private final Integer screenSize = 64;
    private Game game;
    private BufferedImage[] spriteRectangle;
    private Integer selectedSquare = 0;
    private Integer selected1 = 0;
    private Integer selected2 = 24;
    private Integer selected = selected1;
    public ArrayList<Integer> a = new ArrayList<>();

    public LevelManager(Game game) {
        this.game = game;
        initialize();
        importOutsideSprite();
    }

    private void importOutsideSprite() {
        BufferedImage levelSprites = LoadSave.getAtlas(LEVEL1_ATLAS);
        spriteRectangle = new BufferedImage[48];
        int f = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 12; i++) {
                int index = j * 12 + i;
                spriteRectangle[index] = levelSprites.getSubimage(i * subImageSize, j * subImageSize, subImageSize, subImageSize);
            }
        }

    }

    public void render(Graphics g) {
        for (int j = 0; j < 12; j++) {
            for (int i = 0; i < 20; i++) {
                int index = j * 20 + i;
                int pixel = a.get(index);
                g.drawImage(spriteRectangle[pixel], i * 64, j * 64, 64, 64, null);
            }
        }
        int i = 0;
        for (int x = 0; x < 12; x++) {
            for (int z = 0; z < 2; z++) {
                g.drawImage(spriteRectangle[selected + i], (z + 21) * 64, x * 64, 64, 64, null);
                i++;
            }
        }
    }


    public void update() {

    }

    public void initialize() {
        for (int i = 0; i < 240; i++) {
            a.add(11);
        }
    }

    public void changeSelection(int x, int y) {
        int column = (int) Math.floor(x / 64);
        int row = (int) Math.floor(y / 64);
    }


    public void editLevel(int x, int y) {
        if (y < 12 *64) {
        if (x >= 21 * 64) {
            int column = (int) Math.floor(x / 64 - 21);
            int row = (int) Math.floor(y / 64);
            int index = row * 2 + column;
            selectedSquare = selected + index;
        } if (x <= 20 * 64) {
                int column = (int) Math.floor(x / 64);
                int row = (int) Math.floor(y / 64);
                int index = row * 20 + column;
                a.set(index, selectedSquare);
            }
        }
    }

    public void selector() {
        if (selected == selected1) {
            selected = selected2;
        } else {
            selected = selected1;
        }
    }
}
