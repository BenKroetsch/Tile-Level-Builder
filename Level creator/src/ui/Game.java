package ui;

import Level.LevelManager;

import java.awt.*;


    public class Game implements Runnable {
        private static GameFrame gameFrame;
        private static boolean running = true;
        public final int FPS_CAP = 120;
        public final int UPS_CAP = 200;
        public GamePanel gamePanel;

        public LevelManager getLevelManager() {
            return levelManager;
        }

        private LevelManager levelManager;

        public static final int TILE_DEFAULT_SIZE = 64;
        public static final float SCALE = 1F;
        public static final int TILES_WIDTH = 20 + 3; // added for frame components
        public static final int TILES_HEIGHT = 12;
        public static final int TILE_SIZE = (int) (TILE_DEFAULT_SIZE * SCALE);
        public static final int GAME_WIDTH = TILES_WIDTH * TILE_SIZE;
        public static final int GAME_HEIGHT = TILES_HEIGHT * TILE_SIZE;




        public Game() {
            levelManager = new LevelManager(this);

            gamePanel = new GamePanel(this);
            gameFrame = new GameFrame(gamePanel);
            gamePanel.requestFocus();

            run();
        }

        public void update() {
            gamePanel.updateGame();
            levelManager.update();
        }

        public void render(Graphics g) {
            levelManager.render(g);
        }


        @Override
        public void run() {
            gamePanel.repaint();
        }
//            double timePerFrame = 1000000000.0 / FPS_CAP;
//            double timePerUpdate = 1000000000.0 / UPS_CAP;
//
//            long lastCheckedTime = System.nanoTime();
//
//            double deltaU = 0;
//            double deltaF = 0;
//
//            int updates = 0;
//            int frames = 0;
//
//            while (running) {
//
//                long currentTime = System.nanoTime();
//
//                deltaU += (currentTime - lastCheckedTime) / timePerUpdate;
//                deltaF += (currentTime - lastCheckedTime) / timePerFrame;
//
//                lastCheckedTime = currentTime;
//                if (deltaU >= 1) {
//                    update();
//                    deltaU--;
//                    updates++;
//                }
//
//                if (deltaF >= 1) {
//                    gamePanel.repaint();
//                    frames++;
//                    deltaF--;
//
//                    if (System.currentTimeMillis() - lastCheckedTime >= 1000) {
//                        lastCheckedTime = System.currentTimeMillis();
//                        System.out.println(frames + " FPS | UPS: " + updates);
//                        frames = 0;
//                        updates = 0;
//                    }
//                }
//            }
//        }
    }
