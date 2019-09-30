/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Gitta Szabo
 */
public class Board {

    private String player;
    private String pattern;
    private String[][] board;
    private int size;
    private int remainingSteps;
    private int x;
    private int y;

    public Board(int size) {
        this.size = size;
        remainingSteps = size * size;
        board = new String[size][size];
        player = "X";
        pattern = "XXXXX";
    }

    public void turn() {
        if (player.equals("X")) {
            player = "O";
            pattern = "OOOOO";
        } else {
            player = "X";
            pattern = "XXXXX";
        }
    }

    public void move(int position) {
        this.x = position / size;
        this.y = position % size;
        board[x][y] = player;
        remainingSteps--;
    }

    public boolean hasWinner() {

        String[] patterns = new String[4];

        String row = "";
        String column = "";
        String diagonal1;
        String diagonal2;

        //get signs in the corresponding row
        for (int c = 0; c < size; c++) {
            row += board[x][c];
        }
        patterns[0] = row;

        //get signs in the corresponding column
        for (int r = 0; r < size; r++) {
            column += board[r][y];
        }
        patterns[1] = column;

        //get signs in corresponding diagonals
        diagonal1 = board[x][y];
        int r = x;
        int c = y;
        while (r > 0 && c > 0) {
            r--;
            c--;
            diagonal1 = board[r][c] + diagonal1;
        }
        r = x;
        c = y;
        while (r < size - 1 && c < size - 1) {
            r++;
            c++;
            diagonal1 = diagonal1 + board[r][c];
        }
        patterns[2] = diagonal1;

        diagonal2 = board[x][y];
        r = x;
        c = y;
        while (r < size - 1 && c > 0) {
            r++;
            c--;
            diagonal2 = diagonal2 + board[r][c];
        }
        r = x;
        c = y;
        while (0 < r && c < size - 1) {
            r--;
            c++;
            diagonal2 = board[r][c] + diagonal2;
        }
        patterns[3] = diagonal2;

        //check if the corresponding row, column or diagonals contain the winning pattern
        for (String s : patterns) {
            if (s.contains(pattern)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDraw() {
        if (remainingSteps == 0) {
            return true;
        }
        return false;
    }

    public void reset() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = "";
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
