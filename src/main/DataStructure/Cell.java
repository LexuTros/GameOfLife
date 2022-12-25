package DataStructure;

import Exceptions.*;

public class Cell {
    private boolean isAlive;
    private Player playerOfCell;
    private int roundChanged;
    private int aliveNeighbors;

    public Cell() {
        isAlive = false;
        roundChanged = -1;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean newStatus) {
        isAlive = newStatus;
    }

    public Player getPlayer() throws NoPlayerAssigned {
        if (playerOfCell == null) {
            throw new NoPlayerAssigned();
        }
        return playerOfCell;
    }

    public void setPlayer(Player player) {
        playerOfCell = player;
    }

    public int getRoundChanged() throws NotYetChanged {
        if (roundChanged == -1) {
            throw new NotYetChanged();
        }
        return roundChanged;
    }

    public void setRoundChanged(int round) throws InvalidRound {
        if (round < 1) {
            throw new InvalidRound();
        }
        roundChanged = round;
    }

    public int getAliveNeighbors() {
        return aliveNeighbors;
    }

    public void setAliveNeighbors(int numberOfNeighborsAlive) throws TooManyAliveNeighbors, NegativeAmountOfNeighbors {
        if (numberOfNeighborsAlive > 8) {
            throw new TooManyAliveNeighbors();
        } else if (numberOfNeighborsAlive < 0) {
            throw new NegativeAmountOfNeighbors();
        }
        aliveNeighbors = numberOfNeighborsAlive;
    }
}
