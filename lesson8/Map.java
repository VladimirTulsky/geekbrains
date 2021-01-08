package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;
    private static final int EMPTY_DOT = 0;
    private static final int HUMAN_DOT = 1;
    private static final int AI_DOT = 2;
    private static final int DRAW = 0;
    private static final int HUMAN_WIN = 1;
    private static final int AI_WIN = 2;
    private int showResultOfGame;
    private boolean gameOver;

    int[][] field;
    int fieldSizeX;
    int fieldSizeY;
    int winLen;

    int cellHeight;
    int cellWidth;

    private final Font font = new Font("Times new roman", Font.BOLD, 48);
    Random random = new Random();

    boolean isInitialized = false;

    Map() {
        setBackground(new Color(183, 255, 253));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }

    void update(MouseEvent e) {
        if(gameOver) return;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if(!isCellValid(cellX, cellY) || !isCellEmpty(cellY, cellX)) return;
        field[cellX][cellY] = HUMAN_DOT;
        repaint();
        if(checkWin(HUMAN_DOT)) {
            showResultOfGame = HUMAN_WIN;
            gameOver = true;
            return;
        }
        if(isMapFull()) {
            showResultOfGame = DRAW;
            gameOver = true;
            return;
        }
        aiStep();
        repaint();
        if(checkWin(AI_DOT)) {
            showResultOfGame = AI_WIN;
            gameOver = true;
            return;
        }
        if(isMapFull()) {
            showResultOfGame = DRAW;
            gameOver = true;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen) {
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLen = winLen;
        field = new int[fieldSizeY][fieldSizeX];
        isInitialized = true;
        repaint();
    }

    void render(Graphics g) {
        if(!isInitialized) return;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSizeX;
        cellHeight = panelHeight / fieldSizeY;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if(isCellEmpty(j, i)) continue;
                if(field[i][j] == HUMAN_DOT){
                    g.setColor(Color.BLUE);
                    int dw = getWidth() / fieldSizeX;
                    int dh = getHeight() / fieldSizeY;
                    int x = i * dw;
                    int y = j * dh;
                    g.drawLine(x, y, x + dw, y + dh);
                    g.drawLine(x, y + dh, x + dw, y);
                }
                else if(field[i][j] == AI_DOT){
                    g.setColor(Color.RED);
                    g.drawOval(i * cellWidth + 5,
                            j * cellHeight + 5,
                            cellWidth - 5 * 2,
                            cellHeight- 5 * 2);
                }
            }
        }
        if(gameOver){ gameOverMessage(g); }
    }

    void gameOverMessage(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0,200, getWidth(), 70);
        g.setColor(Color.BLACK);
        g.setFont(font);
        switch (showResultOfGame) {
            case HUMAN_WIN -> g.drawString("Player win", 70, getHeight() / 2);
            case DRAW -> g.drawString("Draw", 70, getHeight() / 2);
            case AI_WIN -> g.drawString("AI win", 70, getHeight() / 2);
        }
    }

    private boolean isCellValid(int x, int y) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    private boolean isCellEmpty(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    private void aiStep() {
        int x, y;
        //ход на победу
        if(aiStepCheck(1, AI_DOT)) return;
        //блокировка победы игрока
        if(aiStepCheck(1, HUMAN_DOT)) return;
        //увеличение серии 0 подряд
        if(aiStepCheck(2, AI_DOT)) return;
        if(aiStepCheck(3, AI_DOT)) return;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isCellValid(x, y));
        field[y][x] = AI_DOT;
    }

    private boolean aiStepCheck(int step, int sym) {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if(i + winLen <= fieldSizeY) {
                    if(checkVertical(i, j, sym) == winLen - step) {
                        if(aiBlockVertical(i, j)) return true;
                    }

                }
                if(j + winLen <= fieldSizeX) {
                    if (checkHorisontal(i, j, sym) == winLen - step) {
                        if(aiBlockHorizontal(i, j)) return true;
                    }

                    if(i + winLen <= fieldSizeY) {
                        if (checkDiagonal1(i, j, sym) == winLen - step) {
                            if (aiBlockDiagonal1(i, j)) return true;
                        }
                    }
                    if(i - winLen > -2) {
                        if (checkDiagonal2(i, j, sym) == winLen - step) {
                            if (aiBlockDiagonal2(i, j)) return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean aiBlockHorizontal(int y, int x) {
        for (int i = x; i < winLen; i++) {
            if(field[y][i] == EMPTY_DOT) {
                field[y][i] = AI_DOT;
                return true;
            }
        }
        return false;

    }
    private boolean aiBlockVertical(int y, int x) {
        for (int i = y; i < winLen; i++) {
            if(field[i][x] == EMPTY_DOT) {
                field[i][x] = AI_DOT;
                return true;
            }
        }
        return false;
    }

    private boolean aiBlockDiagonal1(int y, int x) {
        for (int i = 0; i < winLen; i++) {
            if(field[y + i][x + i] == EMPTY_DOT) {
                field[y + i][x + i] = AI_DOT;
                return true;
            }
        }
        return false;
    }

    private boolean aiBlockDiagonal2(int y, int x) {
        for (int i = 0; i < winLen; i++) {
            if(field[y - i][x + i] == EMPTY_DOT) {
                field[y - i][x + i] = AI_DOT;
                return true;
            }
        }
        return false;
    }

    private boolean checkWin(int sym) {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if(i + winLen <= fieldSizeY) {
                    if(checkVertical(i, j, sym) >= winLen) return true;
                }
                if(j + winLen <= fieldSizeX) {
                    if(checkHorisontal(i, j, sym) >= winLen) return true;
                    if(i + winLen <= fieldSizeY) {
                        if(checkDiagonal1(i, j, sym) >= winLen) return true;
                    }
                    if(i - winLen > -2) {
                        if(checkDiagonal2(i, j, sym) >= winLen) return true;
                    }
                }
            }
        }
        return false;
    }

    //проверка по горизонтали
    private int checkHorisontal(int y, int x, int sym) {
        int counter = 0;
        for (int i = x; i < winLen + x; i++) {
            if((field[y][i]) == sym) counter++;
        }
        return counter;
    }
    //проверка по вертикали
    private int checkVertical(int y, int x, int sym) {
        int counter = 0;
        for (int i = y; i < winLen + y; i++) {
            if((field[i][x]) == sym) counter++;
        }
        return counter;
    }
    //проверка по диагонали 1
    private int checkDiagonal1(int y, int x, int sym) {
        int counter = 0;
        for (int i = 0; i < winLen; i++) {
            if((field[i + y][i + x]) == sym) counter++;
        }
        return counter;
    }
    //проверка по диагонали 2
    private int checkDiagonal2(int y, int x, int sym) {
        int counter = 0;
        for (int i = 0; i < winLen; i++) {
            if((field[y - i][x + i]) == sym) counter++;
        }
        return counter;
    }

}
