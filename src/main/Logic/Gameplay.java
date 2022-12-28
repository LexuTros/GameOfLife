package Logic;

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
            try {
                Thread.sleep(2000);} // sleep for x miliseconds
            catch (InterruptedException e) {
                e.printStackTrace();}
            welcome.dispose();
            askPlayerNames();
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
    private void getBoardSize(){}


    // TO-DO: get first player alphabetically
    private static void getStartingPlayer(){
        activePlayer = player1;
    }

    private static void startGame(){
        GuiGame game = new GuiGame(player1, player2, activePlayer);
    }

    public static void roundDone(){
        System.out.println("DOONE!");

    }

    private void nextGeneration(){}
    private void checkWinner(){}
    private void updateGui(){}
    private static void winnerDisplay(){
        GuiWinner win = new GuiWinner(player1);
        try {
            Thread.sleep(2500);} // sleep for x miliseconds
        catch (InterruptedException e) {
            e.printStackTrace();}
        win.dispose();
        askPlayerNames();
    }




    public static void main(String[] args) {

        generation = 1;
        welcomeDisplay();
    }



}
