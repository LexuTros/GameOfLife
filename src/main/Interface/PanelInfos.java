package Interface;

import DataStructure.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInfos extends JPanel implements ActionListener {

    PanelInfos(Player playerOne, Player playerTwo)
    {
        this.setLayout(null);

        JLabel generation = new JLabel();
        generation.setFont(new Font("Comic Sans", Font.ITALIC, 20));
        generation.setForeground(Color.BLACK);
        generation.setBounds(10, 25, 160, 30);
        generation.setText("Generation " + "133");

        PanelPlayerBox boxPlayerOne = new PanelPlayerBox();
        boxPlayerOne.setBounds(10,100,160,80);
        PanelPlayerBox boxPlayerTwo = new PanelPlayerBox();
        boxPlayerTwo.setBounds(10,200,160,80);

        LabelNamePlayer namePlayerOne = new LabelNamePlayer();
        namePlayerOne.setText(playerOne.getPlayerName());
        LabelNamePlayer namePlayerTwo = new LabelNamePlayer();
        namePlayerTwo.setText(playerTwo.getPlayerName());

        LabelTextActiveCells textActiveCellsOne = new LabelTextActiveCells();
        LabelTextActiveCells textActiveCellsTwo = new LabelTextActiveCells();

        LabelActiveCells playerOneActiveCells = new LabelActiveCells();
        playerOneActiveCells.setText("50");
        LabelActiveCells playerTwoActiveCells = new LabelActiveCells();
        playerTwoActiveCells.setText("50");


        JLabel textActivePlayer = new JLabel();
        textActivePlayer.setFont(new Font("Comic Sans", Font.ITALIC, 20));
        textActivePlayer.setForeground(Color.black);
        textActivePlayer.setBounds(20, 400, 160, 30);
        textActivePlayer.setText("active Player:");

        JLabel activePlayer = new JLabel();
        activePlayer.setFont(new Font("MV Boli", Font.BOLD, 20));
        activePlayer.setForeground(Color.blue);
        activePlayer.setBounds(20, 440, 160, 30);
        activePlayer.setText("Player 3");

        boxPlayerOne.add(textActiveCellsOne);
        boxPlayerOne.add(namePlayerOne);
        boxPlayerOne.add(playerOneActiveCells);
        boxPlayerTwo.add(textActiveCellsTwo);
        boxPlayerTwo.add(namePlayerTwo);
        boxPlayerTwo.add(playerTwoActiveCells);

        ButtonGame button = new ButtonGame();

        this.add(generation);
        this.add(textActivePlayer);
        this.add(activePlayer);
        this.add(boxPlayerOne);
        this.add(boxPlayerTwo);
        this.add(button);


        this.setPreferredSize(new Dimension(180,750));
        this.setBackground(Color.white);
        this.setOpaque(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
