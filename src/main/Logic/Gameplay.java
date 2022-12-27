package Logic;

import DataStructure.Player;
import Interface.GuiGame;
import Interface.GuiGetPlayers;
import Interface.GuiWelcome;
import Interface.GuiWinner;

import java.awt.*;
import java.util.ArrayList;

public class Gameplay {

    static ArrayList players;
    static Player player1;
    static Player player2;

    Gameplay(){}
    // Initialisation

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
        System.out.println(players);
        player1 = new Player((String) players.get(0), null);
        player2 = new Player((String) players.get(1), null);
        startGame();
    }
    private void getBoardSize(){}
    private static void startGame(){
      GuiGame game = new GuiGame(player1, player2);

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
        welcomeDisplay();
    }



}
