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
    private boolean enabled;

    public Cell() {
        this.setLayout(new FlowLayout());
        this.setBackground(Color.LIGHT_GRAY);
        this.setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        this.addMouseListener(this);
        this.isAlive = false;
        this.roundChanged = -1;
        this.roundKilled =-1;
        this.enabled = true;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean newStatus) {
        isAlive = newStatus;
    }

    public void setEnabledChange(boolean enabledInput){
        enabled = enabledInput;
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

        // cell was not alive at start of round => can be selected
        if (enabled){
            if (!isAlive && roundKilled != Gameplay.getGeneration()){
                setBackground(Gameplay.getActivePlayer().getPlayerColor());
                isAlive = true;
                playerOfCell = Gameplay.getActivePlayer();
                roundChanged = Gameplay.getGeneration();
            }

            // cell has been born in this round -> can be killed again
            else if (isAlive && playerOfCell == Gameplay.getActivePlayer() && roundChanged == Gameplay.getGeneration()) {
                setBackground(Color.lightGray);
                isAlive = false;
                playerOfCell = null;
                roundChanged = Gameplay.getGeneration() - 1;}

            // cell belonged to other player at start of round -> can be killed
            else if (isAlive && playerOfCell != Gameplay.getActivePlayer()) {
                isAlive = false;
                playerOfCell = null;
                roundKilled = Gameplay.getGeneration() - 1;
            }

            // cell belonged to other player at start of round and has been killed-> can be revived
            else if (!isAlive && roundKilled == Gameplay.getGeneration()){
                setBackground(Gameplay.getActivePlayer().getPlayerColor());
                isAlive = true;
                playerOfCell = Gameplay.getActivePlayer();
                roundChanged = Gameplay.getGeneration();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

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
