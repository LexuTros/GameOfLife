package Logic;

import DataStructure.Board;
import DataStructure.Cell;
import DataStructure.Player;
import Exceptions.InvalidCoordinate;
import Exceptions.NegativeAmountOfNeighbors;
import Exceptions.NoPlayerAssigned;
import Exceptions.TooManyAliveNeighbors;
import Interface.GuiGame;
import Interface.GuiGetPlayers;
import Interface.GuiWelcome;
import Interface.GuiWinner;
import com.sun.net.httpserver.HttpExchange;

import java.awt.*;
import java.util.ArrayList;

public class Gameplay {
    protected static Player activePlayer;
    protected static int generation;
    protected static boolean toKill;
    protected static boolean toCreate;
    static ArrayList<String> players;
    static ArrayList<Color> colors;
    static Player player1;
    static Player player2;
    public static Board board;

    Gameplay(){}

    public static Player getActivePlayer(){
        return activePlayer;
            }
    public static int getGeneration(){
        return generation;
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

    private static void welcomeDisplay(){
        GuiWelcome welcome = new GuiWelcome();
    }

    public static void askPlayerNames(){
        GuiGetPlayers guiPlayerNames = new GuiGetPlayers();
    }

    public static void initializePlayers(){
        players = GuiGetPlayers.players;
        colors = GuiGetPlayers.colors;

        player1 = new Player(players.get(0), colors.get(0));
        player2 = new Player(players.get(1), colors.get(1));
        getStartingPlayer();
        startGame();
    }

    // TO-DO: get first player alphabetically
    private static void getStartingPlayer(){
        activePlayer = player1;
    }

    public static void restartGame(){
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

        GuiGame game = new GuiGame(board, player1, player2, activePlayer);
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
        nextPlayer();
        board.setBoardChangeEnabled(true);
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

    private static void updateAlivePlayerCells() throws NoPlayerAssigned, InvalidCoordinate {
        int player1Counter = 0;
        int player2Counter = 0;
        for (int x = 1; x <= board.width; x++) {
            for (int y = 1; y <= board.height; y++) {
                Cell cell = board.getField(x,y);
                if (cell.getIsAlive()) {
                    if (cell.getPlayer() == player1) {
                        player1Counter++;
                    } else {
                        player2Counter++;
                    }
                }
            }
        }
        player1.setAliveCells(player1Counter);
        player2.setAliveCells(player2Counter);
    }


    private static void checkWinner(){
        try {
            updateAlivePlayerCells();
        } catch (NoPlayerAssigned | InvalidCoordinate e) {
            throw new RuntimeException(e);
        }

        boolean endOfGame = false;
        if (player1.getAliveCells() == 0 && player2.getAliveCells() == 0) {
            endOfGame = true;
            winnerDisplay("You are both equally bad");
        }
        else if (player1.getAliveCells() == 0){
            endOfGame = true;
            winnerDisplay(player2.getPlayerName()+ ", you win!!");
        }
        else if (player2.getAliveCells() == 0){
            endOfGame = true;
                winnerDisplay(player1.getPlayerName()+ ", you win!!");
        }
    }

    private static void updateGui(){}

    private static void winnerDisplay(String winner){
        GuiWinner win = new GuiWinner(winner);
    }

    public static void main(String[] args) {
        welcomeDisplay();
    }



}
