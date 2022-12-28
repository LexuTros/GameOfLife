package DataStructure;

import Exceptions.InvalidCoordinate;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    public int width;
    public int height;
    private Cell[][] board;

    public Board(int width, int height) {
//            throws InvalidHeight, InvalidWidth {
//        if (height < 1) {
//            throw new InvalidHeight();
//        } else if (width < 1) {
//            throw new InvalidWidth();
//        } else {
//            this.width = width;
//            this.height = height;
//            board = new Cell[height][width];
        this.width = width;
        this.height = height;
        board = new Cell[width][height];
        this.setPreferredSize(new Dimension(1000,750));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(height,width));
        for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++)
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
                xCoordinate >= board.length ||
                yCoordinate >= board[0].length) {
            throw new InvalidCoordinate();
        }
        return board[xCoordinate][yCoordinate];
    }
}
