package DataStructure;

import Exceptions.InvalidCoordinate;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    public int width;
    public int height;
    private Cell[][] board;

    public Board() {
//            throws InvalidHeight, InvalidWidth {
//        if (height < 1) {
//            throw new InvalidHeight();
//        } else if (width < 1) {
//            throw new InvalidWidth();
//        } else {
//            this.width = width;
//            this.height = height;
//            board = new Cell[height][width];
        board = new Cell[100][75];
        this.setPreferredSize(new Dimension(1000,750));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(75,100));
        for (int row = 0; row < 75; row++)
            for (int col = 0; col < 100; col++)
            {
                Cell cell = new Cell();
                this.add(cell);
                board[col][row] = cell;
            }
    }




    public Cell getField(int xCoordinate, int yCoordinate) throws InvalidCoordinate {
        xCoordinate--;
        yCoordinate--;
        // make sure the choice is valid, throw exception if it isn't
        if (xCoordinate < 0 ||
                yCoordinate < 0 ||
                xCoordinate >= board[0].length ||
                yCoordinate >= board.length) {
            throw new InvalidCoordinate();
        }
        return board[yCoordinate][xCoordinate];
    }
}
