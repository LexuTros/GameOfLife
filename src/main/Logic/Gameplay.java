package Logic;

import DataStructure.Board;
import DataStructure.Player;
import Exceptions.InvalidCoordinate;
import Exceptions.NegativeAmountOfNeighbors;
import Exceptions.NoPlayerAssigned;
import Exceptions.TooManyAliveNeighbors;

import Interface.*;

import java.awt.*;
import java.util.ArrayList;

public class Gameplay {
    protected static Player activePlayer;
    protected static int generation;
    private static boolean toKill;
    private static boolean toCreate;
    protected static Player player1;
    protected static Player player2;
    private static Board board;


    public static Player getActivePlayer(){
        return activePlayer;
            }

    public static void setActivePlayer(Player newActivePlayer){
        activePlayer = newActivePlayer;
    }

    public static int getGeneration(){
        return generation;
    }
    public static void setGeneration(int newGeneration) {
        generation = newGeneration;
    }

    public static boolean getToKill(){
        return toKill;
    }
    public static void setToKill(boolean changeToKill){
        toKill = changeToKill;
    }

    public static boolean getToCreate(){
        return toCreate;
    }
    public static void setToCreate(boolean changeToKill){
        toCreate = changeToKill;
    }


    protected static void welcomeDisplay(){
        new GuiWelcome();
    }

    public static void askPlayerNames(){
        new GuiGetPlayers();
    }

    private static void winnerDisplay(String winner){
        new GuiWinner(winner);
    }


    public static void initializePlayers(){
        ArrayList<String> players = GuiGetPlayers.players;
        ArrayList<Color> colors = GuiGetPlayers.colors;

        player1 = new Player(players.get(0), colors.get(0));
        player2 = new Player(players.get(1), colors.get(1));
        getStartingPlayer();
        startGame();
    }


    private static void startGame(){
        generation = 1;
        toKill = true;
        toCreate = true;
        board = new Board(50,37);

        // Initial star configuration
        try {
            board.getField(15,18).reviveCell(player1);
            board.getField(14,19).reviveCell(player1);
            board.getField(15,19).reviveCell(player1);
            board.getField(16,19).reviveCell(player1);
            board.getField(15,20).reviveCell(player1);

            board.getField(35,18).reviveCell(player2);
            board.getField(34,19).reviveCell(player2);
            board.getField(35,19).reviveCell(player2);
            board.getField(36,19).reviveCell(player2);
            board.getField(35,20).reviveCell(player2);
        } catch (InvalidCoordinate e) {
            throw new RuntimeException(e);
        }
        new GuiGame(board, player1, player2);
        PanelInfos.updateInfoPanel();
    }

    public static void roundDone(){
        board.setBoardChangeEnabled(false);
        try {
            Round.simulateGeneration(board);
        } catch (NoPlayerAssigned | TooManyAliveNeighbors | NegativeAmountOfNeighbors | InvalidCoordinate e) {
            throw new RuntimeException(e);
        }
        generation++;
        checkWinner();

    }

    public static void restartGame(){
        player1.setAliveCells(0);
        player2.setAliveCells(0);
        startGame();
    }

    private static void checkWinner(){

        if (player1.getAliveCells() == 0 && player2.getAliveCells() == 0) {
            winnerDisplay("You are both equally bad");
        }
        else if (player1.getAliveCells() == 0){
            winnerDisplay(player2.getPlayerName()+ ", you win!!");
        }
        else if (player2.getAliveCells() == 0){
            winnerDisplay(player1.getPlayerName()+ ", you win!!");
        }
        else {nextPlayer();
        PanelInfos.updateInfoPanel();
        board.setBoardChangeEnabled(true);}
    }



    protected static void getStartingPlayer(){
        if (player1.compareTo(player2) < 0) {
            activePlayer = player1;
        } else {
            activePlayer = player2;
        }
    }

    private static void nextPlayer() {
        if (activePlayer == player1) {
            activePlayer = player2;
        } else {
            activePlayer = player1;
        }
        toKill = true;
        toCreate = true;
    }


    public static void main(String[] args) {
        welcomeDisplay();
    }
}
