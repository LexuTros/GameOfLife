package Interface;

import InterfaceHelpers.ButtonWinnerGui;
import Logic.Gameplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiWinner extends GuiTemplate implements ActionListener {

    protected ButtonWinnerGui buttonExit;
    protected ButtonWinnerGui buttonBackToBoard;
    protected ButtonWinnerGui buttonRestart;
    protected ButtonWinnerGui buttonNewGame;
    protected JLabel labelWin;
    protected JLabel labelWinner;

    public GuiWinner(String winner) {
        this.setLayout(null);
        labelWin = new JLabel();
        labelWin.setFont(new Font("Papyrus", Font.BOLD, 60));
        labelWin.setText("CONGRATULATIONS");
        labelWin.setBounds(120,200,1000,100);

        labelWinner = new JLabel();
        labelWinner.setFont(new Font("Papyrus", Font.BOLD, 80));
        labelWinner.setText(winner);
        labelWinner.setBounds(240, 300,1000,100);

        buttonBackToBoard = new ButtonWinnerGui();
        buttonBackToBoard.addActionListener(this);
        buttonBackToBoard.setText("Back to Board");
        buttonBackToBoard.setBounds(280, 600,200,60);

        buttonExit = new ButtonWinnerGui();
        buttonExit.addActionListener(this);
        buttonExit.setText("EXIT");
        buttonExit.setBounds(910, 600,200,60);

        buttonRestart = new ButtonWinnerGui();
        buttonRestart.addActionListener(this);
        buttonRestart.setText("Restart");
        buttonRestart.setBounds(490, 600,200,60);

        buttonNewGame = new ButtonWinnerGui();
        buttonNewGame.addActionListener(this);
        buttonNewGame.setText("New Game");
        buttonNewGame.setBounds(700, 600,200,60);



        this.add(labelWin);
        this.add(labelWinner);
        this.add(buttonExit);
        this.add(buttonBackToBoard);
        this.add(buttonRestart);
        this.add(buttonNewGame);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buttonBackToBoard){
            this.dispose();
        }
        if (e.getSource()==buttonExit){
            System.exit(0);
        }

        if (e.getSource()==buttonRestart){
            this.dispose();
            Gameplay.restartGame();
        }

        if (e.getSource()==buttonNewGame){
            this.dispose();
            Gameplay.askPlayerNames();
        }
    }
}

