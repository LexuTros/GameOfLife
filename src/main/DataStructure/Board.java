package DataStructure;

import Exceptions.InvalidCoordinate;
import Exceptions.InvalidHeight;
import Exceptions.InvalidWidth;

public class Board {
    private final Cell[][] board;
    public final int width;
    public final int height;

    public Board(int width, int height) throws InvalidHeight, InvalidWidth {
        if (height < 1) {
            throw new InvalidHeight();
        } else if (width < 1) {
            throw new InvalidWidth();
        } else {
            this.width = width;
            this.height = height;
            board = new Cell[height][width];
            initializeBoard();
        }
    }

    private void initializeBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = new Cell();
            }
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
