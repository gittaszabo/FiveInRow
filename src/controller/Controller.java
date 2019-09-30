/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Board;
import view.View;

/**
 *
 * @author Gitta Szabo
 */
public class Controller {

    private Board board;
    private View view;

    public Controller(Board board) {
        this.board = board;
        view = new View(this, board);
        view.setVisible(true);
    }

    public void newGame() {
        board.reset();
        view.reset();
    }

    public void newGame(int size) {
        board = new Board(size);
        view = new View(this, board);
        view.setVisible(true);
    }

    public void makeMove(int position) {
        view.mark(board.getPlayer());
        board.move(position);
        if (board.hasWinner()) {
            view.showWinner();
            newGame();
        } else if (board.isDraw()) {
            view.isDraw();
            newGame();
        } else {
            board.turn();
        }
    }
}
