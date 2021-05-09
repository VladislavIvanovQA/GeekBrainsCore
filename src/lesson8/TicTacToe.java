package lesson8;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe extends JFrame {

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static int SIZE = 3;
    private static int DOTS_TO_WIN = 3;
    private static char[][] map = new char[SIZE][SIZE];
    private JButton[] buttons;

    public TicTacToe() {
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        setVisible(true);

        String inputSize = JOptionPane.showInputDialog("Введите размер игры! (Только число!)");

        try {
            SIZE = Integer.parseInt(inputSize);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ошибка ввода! Используем по умолчанию размер игры 3", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }

        map = new char[SIZE][SIZE];
        buttons = new JButton[SIZE * SIZE];
        DOTS_TO_WIN = SIZE;

        GridLayout layout = new GridLayout(SIZE, SIZE, 10, 10);
        setLayout(layout);

        initMap();
        initButtons();
        printInfo();
    }

    public void createButton(int index, int x, int y) {
        JButton btn = new JButton();
        btn.setText(String.valueOf(DOT_EMPTY));
        btn.setName(x + " " + y);
        btn.addActionListener(actionEvent -> {
            if (!btn.getText().equals(String.valueOf(DOT_EMPTY))) {
                sendMessageDialog("Клетка уже занята!");
            } else {
                btn.setBackground(new Color(124, 199, 142));
                btn.setText(String.valueOf(DOT_X));
                String[] name = btn.getName().split(" ");
                int inputX = Integer.parseInt(name[0]);
                int inputY = Integer.parseInt(name[1]);

                System.out.println("Кнопка с кординатами x: " + (inputX + 1) + " y: " + (inputY + 1) + " нажата");

                map[inputX][inputY] = DOT_X;
                printInfo();

                if (isWin(DOT_X)) {
                    sendMessageDialog("Человек победил!");
                    System.out.println("Человек победил!");
                    endGame();
                }
                if (isMapFull()) {
                    sendMessageDialog("Ничья!");
                    System.out.println("Ничья!");
                    endGame();
                }

                computerTurn();
                if (isWin(DOT_O)) {
                    sendMessageDialog("Компьютер победил!");
                    System.out.println("Компьютер победил!");
                    endGame();
                }
                if (isMapFull()) {
                    sendMessageDialog("Ничья!");
                    System.out.println("Ничья!");
                    endGame();
                }
            }
        });
        buttons[index] = btn;
        add(btn);
    }

    public void sendMessageDialog(String text) {
        JOptionPane.showMessageDialog(this, text);
    }

    public void endGame() {
        sendMessageDialog("Игра закончена!");
        System.exit(0);
    }

    public static void main(String[] args) {
        new TicTacToe();
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isWin(char symbol) {
        if (checkRowsAndCols(symbol)) {
            return true;
        } else {
            return checkDiagonals(symbol);
        }
    }

    private static boolean checkDiagonals(char symbol) {
        int mainDiagCounter = 0;
        int sideDiagCounter = 0;
        for (int i = 0; i < SIZE; i++) {
            mainDiagCounter = (map[i][i] == symbol) ? mainDiagCounter + 1 : 0;
            sideDiagCounter = (map[i][map.length - 1 - i] == symbol) ? sideDiagCounter + 1 : 0;
            if (mainDiagCounter == DOTS_TO_WIN || sideDiagCounter == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkRowsAndCols(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            int rowCounter = 0;
            int colCounter = 0;
            for (int j = 0; j < SIZE; j++) {
                rowCounter = (map[i][j] == symbol) ? rowCounter + 1 : 0;
                colCounter = (map[j][i] == symbol) ? colCounter + 1 : 0;
                if (rowCounter == DOTS_TO_WIN || colCounter == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] getNextCellToWin(char symbol) {
        for (int rowIndex = 0; rowIndex < map.length; rowIndex++) {
            for (int colIndex = 0; colIndex < map[rowIndex].length; colIndex++) {
                if (map[rowIndex][colIndex] == DOT_EMPTY && isGameMoveWinning(rowIndex, colIndex, symbol)) {
                    return new int[]{rowIndex, colIndex};
                }
            }
        }
        return null;
    }

    private boolean isGameMoveWinning(int rowIndex, int colIndex, char symbol) {
        setCell(rowIndex, colIndex, symbol);
        boolean result = isWin(symbol);
        setCell(rowIndex, colIndex, DOT_EMPTY);
        return result;
    }

    private void setCell(int rowIndex, int colIndex, char symbol) {
        map[rowIndex][colIndex] = symbol;
    }

    private void computerTurn() {
        int[] cell = getNextCellToWin(DOT_O);
        if (cell == null) {
            cell = getNextCellToWin(DOT_X);
            if (cell == null) {
                cell = getRandomEmptyCell();
            }
        }
        int rowIndex = cell[0];
        int colIndex = cell[1];

        setCell(rowIndex, colIndex, DOT_O);
        JButton jButton = Arrays.stream(buttons)
                .filter(btn -> {
                    String[] name = btn.getName().split(" ");
                    int x = Integer.parseInt(name[0]);
                    int y = Integer.parseInt(name[1]);
                    return rowIndex == x && colIndex == y;
                })
                .findFirst()
                .get();
        System.out.println("Выставляем значение: " + DOT_O + " кнопке с индексом: " + jButton.getName());
        jButton.setBackground(new Color(205, 115, 115));
        jButton.setText(String.valueOf(DOT_O));
    }

    private static int[] getRandomEmptyCell() {
        int x;
        int y;
        Random random = new Random();
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (map[x][y] != DOT_EMPTY);

        map[x][y] = DOT_O;
        return new int[]{x, y};
    }

    private static int readInt(Scanner scanner) {
        return scanner.hasNextInt() ? scanner.nextInt() : -1;
    }

    private void printInfo() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void initMap() {
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(map[i], DOT_EMPTY);
        }
    }

    private void initButtons() {
        int index = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                createButton(index++, i, j);
            }
        }
        repaint();
        revalidate();
    }
}
