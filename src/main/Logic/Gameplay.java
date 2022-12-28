package Logic;

import DataStructure.Board;
import DataStructure.Player;
import Interface.GuiGame;
import Interface.GuiGetPlayers;
import Interface.GuiWelcome;
import Interface.GuiWinner;

import java.awt.*;
import java.util.ArrayList;

public class Gameplay {

    private static Player activePlayer;
    private static int generation;
    static ArrayList<String> players;
    static ArrayList<Color> colors;
    static Player player1;
    static Player player2;
    public static Board board;


    Gameplay(){
    }
    public static Player getActivePlayer(){
        return activePlayer;
            }
    public static int getGeneration(){
        return generation;
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
        board = new Board(50,37);
        GuiGame game = new GuiGame(board, player1, player2, activePlayer);
    }

    public static void roundDone(){
        Round.setBoardChangeEnabled(board, false);
        checkWinner();
    }

    private static void checkWinner(){
        boolean endOfGame = false;
        String winnerName;
        if (player1.getAliveCells() == 0 && player2.getAliveCells() == 0) {
            endOfGame = true;
            winnerDisplay("You are both equally bad");
        }
        else if (player1.getAliveCells() == 0){
            endOfGame = true;
            winnerDisplay(player2.getPlayerName()+ ", you win!!");}
        else if (player2.getAliveCells() == 0){
            endOfGame = true;
                winnerDisplay(player1.getPlayerName()+ ", you win!!");}
        // next step
        }

    private static void updateGui(){}


    private static void winnerDisplay(String winner){
        GuiWinner win = new GuiWinner(winner);
    }




    public static void main(String[] args) {
        welcomeDisplay();
    }



}
