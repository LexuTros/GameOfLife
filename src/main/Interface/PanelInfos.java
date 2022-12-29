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

    private final JButton buttonDone;

    PanelInfos(Player playerOne, Player playerTwo, Player activePlayer)
    {
        this.setLayout(null);

        // Generation

        JLabel generation = new JLabel();
        generation.setFont(new Font("Comic Sans", Font.ITALIC, 20));
        generation.setForeground(Color.BLACK);
        generation.setBounds(10, 25, 160, 30);
        generation.setText("Generation " + Gameplay.getGeneration());

        // Box Player one

        PanelPlayerBox boxPlayerOne = new PanelPlayerBox();
        boxPlayerOne.setBounds(10,100,160,80);

        LabelPlayerName namePlayerOne = new LabelPlayerName();
        namePlayerOne.setText(playerOne.getPlayerName());

        LabelPlayerColor colorPlayerOne = new LabelPlayerColor();
        colorPlayerOne.setBackground(playerOne.getPlayerColor());

        LabelTextActiveCells textActiveCellsOne = new LabelTextActiveCells();

        LabelActiveCells playerOneActiveCells = new LabelActiveCells();
        playerOneActiveCells.setText(String.valueOf(playerOne.getAliveCells()));

        boxPlayerOne.add(namePlayerOne);
        boxPlayerOne.add(colorPlayerOne);
        boxPlayerOne.add(textActiveCellsOne);
        boxPlayerOne.add(playerOneActiveCells);

        // Box Player two

        PanelPlayerBox boxPlayerTwo = new PanelPlayerBox();
        boxPlayerTwo.setBounds(10,200,160,80);

        LabelPlayerName namePlayerTwo = new LabelPlayerName();
        namePlayerTwo.setText(playerTwo.getPlayerName());

        LabelPlayerColor colorPlayerTwo = new LabelPlayerColor();
        colorPlayerTwo.setBackground(playerTwo.getPlayerColor());

        LabelTextActiveCells textActiveCellsTwo = new LabelTextActiveCells();

        LabelActiveCells playerTwoActiveCells = new LabelActiveCells();
        playerTwoActiveCells.setText(String.valueOf(playerTwo.getAliveCells()));

        boxPlayerTwo.add(colorPlayerTwo);
        boxPlayerTwo.add(namePlayerTwo);
        boxPlayerTwo.add(textActiveCellsTwo);
        boxPlayerTwo.add(playerTwoActiveCells);

        // Active Player

        JLabel textActivePlayer = new JLabel();
        textActivePlayer.setFont(new Font("Comic Sans", Font.ITALIC, 20));
        textActivePlayer.setForeground(Color.black);
        textActivePlayer.setBounds(20, 400, 160, 30);
        textActivePlayer.setText("active Player:");

        JLabel labelActivePlayer = new JLabel();
        labelActivePlayer.setFont(new Font("MV Boli", Font.BOLD, 25));
        labelActivePlayer.setForeground(Color.blue);
        labelActivePlayer.setBounds(20, 440, 160, 30);
        labelActivePlayer.setText(activePlayer.getPlayerName());

        // Button to continue game

        buttonDone = new JButton();
        buttonDone.addActionListener(this);
        buttonDone.setText("DONE!");
        buttonDone.setBounds(10,550,160 ,30 );
        buttonDone.setFont(new Font("Comic Sans", Font.BOLD, 20));
        buttonDone.setFocusable(false);

        // add all components to frame

        this.add(generation);
        this.add(textActivePlayer);
        this.add(labelActivePlayer);
        this.add(boxPlayerOne);
        this.add(boxPlayerTwo);
        this.add(buttonDone);

        // settings of frame

        this.setPreferredSize(new Dimension(180,750));
        this.setBackground(Color.white);
        this.setOpaque(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonDone){
            buttonDone.setEnabled(false);
            Gameplay.roundDone();
            // ToDo: Update Panel Infos
            buttonDone.setEnabled(true);
        }

    }
}
