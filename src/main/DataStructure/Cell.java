package DataStructure;

import Exceptions.*;
import Logic.Gameplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends JLabel implements MouseListener {
    private boolean isAlive;
    private Player playerOfCell;
    private int roundChanged;
    private int roundKilled;
    private int aliveNeighbors;

    private int x;
    private int y;

    public Cell(int x, int y) {
        this.setLayout(new FlowLayout());
        this.setBackground(Color.LIGHT_GRAY);
        this.setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        this.addMouseListener(this);
        this.x = x;
        this.y = y;
        this.isAlive = false;
        this.roundChanged = -1;
        this.roundKilled =-1;
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

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {


        // cell was not alive at start of round => can be selected
        if (!isAlive && roundKilled != Gameplay.getRound()){
            setBackground(Gameplay.getActivePlayer().getPlayerColor());
            isAlive = true;
            playerOfCell = Gameplay.getActivePlayer();
            roundChanged = Gameplay.getRound();
        }

        // cell has been born in this round -> can be killed again
        else if (isAlive && playerOfCell == Gameplay.getActivePlayer() && roundChanged == Gameplay.getRound()) {
            setBackground(Color.lightGray);
            isAlive = false;
            playerOfCell = null;
            roundChanged = Gameplay.getRound() - 1;}

        // cell belonged to other player at start of round -> can be killed
        else if (isAlive && playerOfCell != Gameplay.getActivePlayer()) {
            isAlive = false;
            playerOfCell = null;
            roundKilled = Gameplay.getRound() - 1;
        }

        // cell belonged to other player at start of round and has been killed-> can be revived
        else if (!isAlive && roundKilled == Gameplay.getRound()){
            setBackground(Gameplay.getActivePlayer().getPlayerColor());
            isAlive = true;
            playerOfCell = Gameplay.getActivePlayer();
            roundChanged = Gameplay.getRound();
        }

        }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
