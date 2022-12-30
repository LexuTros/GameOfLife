package Interface;

import DataStructure.Board;
import DataStructure.Player;
import Logic.Gameplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuiGame extends GuiTemplate implements ActionListener {
    private final JMenuItem itemRestart;
    public final JMenuItem itemNewGame;
    private final JMenuItem itemExit;

    public GuiGame(Board board, Player playerOne, Player playerTwo) {
        this.add(board,BorderLayout.CENTER);
        this.add(new PanelInfos(playerOne, playerTwo),BorderLayout.EAST);

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu optionMenu = new JMenu("Navigation Menu");

        itemRestart = new JMenuItem("Restart Game");
        itemNewGame = new JMenuItem("New Game");
        itemExit = new JMenuItem("EXIT");

        itemRestart.addActionListener(this);
        itemNewGame.addActionListener(this);
        itemExit.addActionListener(this);

        optionMenu.add(itemRestart);
        optionMenu.add(itemNewGame);
        optionMenu.add(itemExit);

        menuBar.add(optionMenu);



        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==itemRestart){
            this.dispose();
            Gameplay.restartGame();
        }
        if (e.getSource()==itemNewGame){
            this.dispose();
            Gameplay.askPlayerNames();
        }
        if (e.getSource()==itemExit){
            System.exit(0);
        }

    }}




