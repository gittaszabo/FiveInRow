/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiveinrow;

import controller.Controller;
import model.Board;

/**
 *
 * @author Gitta Szabo
 */
public class FiveInRow {

    public static void main(String[] args) {
        //the default size of the game board is 20 x 20

        int boardSize = 20;
        Board board = new Board(boardSize);
        Controller controller = new Controller(board);
    }

}
