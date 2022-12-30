package DataStructure;

import Exceptions.*;
import Interface.PanelInfos;
import Logic.Gameplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends JLabel implements MouseListener {
    private boolean isAlive;
    private Player playerOfCell;
    private Player futurePlayerOfCell;
    private int roundChanged;
    private int aliveNeighbors;
    protected boolean enabled;

    public Cell() {
        setLayout(new FlowLayout());
        setBackground(Color.LIGHT_GRAY);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        addMouseListener(this);
        isAlive = false;
        roundChanged = -1;
        enabled = true;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void reviveCell(Player newOwner) {
        isAlive = true;
        playerOfCell = newOwner;
        playerOfCell.setAliveCells(playerOfCell.getAliveCells() + 1);
        setBackground(newOwner.getPlayerColor());
    }

    public void killCell() {
        isAlive = false;
        playerOfCell.setAliveCells(playerOfCell.getAliveCells() - 1);
        playerOfCell = null;
        setBackground(Color.lightGray);
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

    public Player getFuturePlayer() throws NoPlayerAssigned {
        if (futurePlayerOfCell == null) {
            throw new NoPlayerAssigned();
        }
        return futurePlayerOfCell;
    }

    public void setFuturePlayer(Player player) {
        futurePlayerOfCell = player;
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

        if (enabled){
            // cell was not alive at start of round => can be selected
            if (Gameplay.getToCreate() && !isAlive){
                reviveCell(Gameplay.getActivePlayer());
                roundChanged = Gameplay.getGeneration();
                Gameplay.setToCreate(false);
            }

            // cell has been born in this round -> can be killed again
            else if (isAlive && playerOfCell == Gameplay.getActivePlayer() && roundChanged == Gameplay.getGeneration()) {
                killCell();
                roundChanged = Gameplay.getGeneration() - 1;
                Gameplay.setToCreate(true);
            }

            // cell belonged to other player at start of round -> can be killed
            else if (Gameplay.getToKill() && isAlive && playerOfCell != Gameplay.getActivePlayer()) {
                killCell();
                Gameplay.setToKill(false);
            }

            PanelInfos.updateInfoPanel();
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
