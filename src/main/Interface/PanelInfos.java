package Interface;

import DataStructure.Player;
import InterfaceHelpers.LabelActiveCells;
import InterfaceHelpers.LabelPlayerColor;
import InterfaceHelpers.LabelPlayerName;
import InterfaceHelpers.LabelTextActiveCells;
import Logic.Gameplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInfos extends JPanel implements ActionListener {

    private static JButton buttonDone;



    private static Player playerOne;
    private static Player playerTwo;
    private Player activePlayer;

    private static JLabel generation;
    private static LabelActiveCells playerOneActiveCells;
    private static LabelActiveCells playerTwoActiveCells;
    private static JLabel labelActivePlayer;

    private static JLabel labelToCreate;
    private static JLabel labelToKill;

    private static LabelPlayerColor labelActivePlayerColor;

    PanelInfos(Player player1, Player player2, Player activePlayerStart)
    {
        this.setLayout(null);
        playerOne = player1;
        playerTwo = player2;
        activePlayer = activePlayerStart;

        // Generation

        generation = new JLabel();
        generation.setFont(new Font("Comic Sans", Font.ITALIC, 20));
        generation.setForeground(Color.BLACK);
        generation.setBounds(10, 25, 160, 30);

        // Box Player one

        PanelPlayerBox boxPlayerOne = new PanelPlayerBox();
        boxPlayerOne.setBounds(10,350,160,80);

        LabelPlayerName namePlayerOne = new LabelPlayerName();
        namePlayerOne.setText(playerOne.getPlayerName());

        LabelPlayerColor colorPlayerOne = new LabelPlayerColor();
        colorPlayerOne.setBackground(playerOne.getPlayerColor());

        LabelTextActiveCells textActiveCellsOne = new LabelTextActiveCells();

        playerOneActiveCells = new LabelActiveCells();

        boxPlayerOne.add(namePlayerOne);
        boxPlayerOne.add(colorPlayerOne);
        boxPlayerOne.add(textActiveCellsOne);
        boxPlayerOne.add(playerOneActiveCells);

        // Box Player two

        PanelPlayerBox boxPlayerTwo = new PanelPlayerBox();
        boxPlayerTwo.setBounds(10,450,160,80);

        LabelPlayerName namePlayerTwo = new LabelPlayerName();
        namePlayerTwo.setText(playerTwo.getPlayerName());

        LabelPlayerColor colorPlayerTwo = new LabelPlayerColor();
        colorPlayerTwo.setBackground(playerTwo.getPlayerColor());

        LabelTextActiveCells textActiveCellsTwo = new LabelTextActiveCells();

        playerTwoActiveCells = new LabelActiveCells();

        boxPlayerTwo.add(colorPlayerTwo);
        boxPlayerTwo.add(namePlayerTwo);
        boxPlayerTwo.add(textActiveCellsTwo);
        boxPlayerTwo.add(playerTwoActiveCells);

        // Active Player

        labelActivePlayer = new JLabel();
        labelActivePlayer.setFont(new Font("MV Boli", Font.BOLD, 25));
        labelActivePlayer.setForeground(Color.black);
        labelActivePlayer.setBounds(10, 140, 160, 30);

        labelActivePlayerColor= new LabelPlayerColor();
        labelActivePlayerColor.setBounds(135, 145, 20, 20);

        // to create / to kill

        labelToCreate = new JLabel();
        labelToCreate.setBounds(10, 180, 200, 20);
        labelToCreate.setFont(new Font("Comic Sans", Font.ITALIC, 14));

        labelToKill = new JLabel();
        labelToKill.setFont(new Font("Comic Sans", Font.ITALIC, 14));
        labelToKill.setBounds(10, 200, 200, 20);

        // Button to continue game

        buttonDone = new JButton();
        buttonDone.addActionListener(this);
        buttonDone.setText("DONE!");
        buttonDone.setBounds(10,240,160 ,30 );
        buttonDone.setFont(new Font("Comic Sans", Font.BOLD, 20));
        buttonDone.setFocusable(false);
        buttonDone.setEnabled(false);

        // add all components to frame

        this.add(generation);
        this.add(labelActivePlayer);
        this.add(labelActivePlayerColor);
        this.add(boxPlayerOne);
        this.add(boxPlayerTwo);
        this.add(buttonDone);
        this.add(labelToCreate);
        this.add(labelToKill);

        //updateInfoPanel();
        // settings of frame

        this.setPreferredSize(new Dimension(180,750));
        this.setBackground(Color.white);
        this.setOpaque(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonDone){
            Gameplay.roundDone();
            if (Gameplay.getToCreate()){
                labelToCreate.setText("left to create: 1");}
            else {
                labelToCreate.setText("left to create: 0");}
            if (Gameplay.getToKill()){
                labelToKill.setText("left to kill: 1");}
            else {
                labelToKill.setText("left to kill: 0");}

        }
    }

    public static void updateInfoPanel(){

        playerOneActiveCells.setText(String.valueOf(playerOne.getAliveCells()));
        playerTwoActiveCells.setText(String.valueOf(playerTwo.getAliveCells()));
        generation.setText("Generation: " + Gameplay.getGeneration());
        labelActivePlayer.setText(Gameplay.getActivePlayer().getPlayerName());
        labelActivePlayerColor.setBackground(Gameplay.getActivePlayer().getPlayerColor());
        if (Gameplay.getToCreate()){
            labelToCreate.setText("left to create: 1");}
        else {
            labelToCreate.setText("left to create: 0");}
        if (Gameplay.getToKill()){
            labelToKill.setText("left to kill: 1");}
        else {
            labelToKill.setText("left to kill: 0");}

        if (!Gameplay.getToCreate() && !Gameplay.getToKill()){
            buttonDone.setEnabled(true);}
        else {
            buttonDone.setEnabled(false);}
    }



    public JButton getButtonDone() {
        return buttonDone;
    }
}
