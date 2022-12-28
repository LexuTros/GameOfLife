package Interface;

import Logic.Gameplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiWinner extends GuiTemplate implements ActionListener {

    private final JButton buttonExit;
    private final JButton buttonBackToBoard;
    private final JButton buttonRestart;
    private final JButton buttonNewGame;

    public GuiWinner(String winner) {
        this.setLayout(null);
        JLabel labelWin = new JLabel();
        labelWin.setFont(new Font("Papyrus", Font.BOLD, 60));
        labelWin.setText("CONGRATULATIONS");
        labelWin.setBounds(120,200,1000,100);
        JLabel labelWinner = new JLabel();
        labelWinner.setFont(new Font("Papyrus", Font.BOLD, 80));
        labelWinner.setText(winner);
        labelWinner.setBounds(300, 300,1000,100);

        buttonBackToBoard = new JButton();
        buttonBackToBoard.addActionListener(this);
        buttonBackToBoard.setText("Back to Board");
        buttonBackToBoard.setHorizontalTextPosition(JButton.CENTER);
        buttonBackToBoard.setVerticalTextPosition(JButton.BOTTOM);
        buttonBackToBoard.setFont(new Font("Comic Sans", Font.BOLD, 20));
        buttonBackToBoard.setBorder(BorderFactory.createCompoundBorder());
        buttonBackToBoard.setBounds(700, 600,200,60);

        buttonExit = new JButton();
        buttonExit.addActionListener(this);
        buttonExit.setText("EXIT");
        buttonExit.setHorizontalTextPosition(JButton.CENTER);
        buttonExit.setVerticalTextPosition(JButton.BOTTOM);
        buttonExit.setFont(new Font("Comic Sans", Font.BOLD, 20));
        buttonExit.setBorder(BorderFactory.createCompoundBorder());
        buttonExit.setBounds(910, 600,200,60);

        buttonRestart = new JButton();
        buttonRestart.addActionListener(this);
        buttonRestart.setText("Restart");
        buttonRestart.setHorizontalTextPosition(JButton.CENTER);
        buttonRestart.setVerticalTextPosition(JButton.BOTTOM);
        buttonRestart.setFont(new Font("Comic Sans", Font.BOLD, 20));
        buttonRestart.setBorder(BorderFactory.createCompoundBorder());
        buttonRestart.setBounds(490, 600,200,60);

        buttonNewGame = new JButton();
        buttonNewGame.addActionListener(this);
        buttonNewGame.setText("New Game");
        buttonNewGame.setHorizontalTextPosition(JButton.CENTER);
        buttonNewGame.setVerticalTextPosition(JButton.BOTTOM);
        buttonNewGame.setFont(new Font("Comic Sans", Font.BOLD, 20));
        buttonNewGame.setBorder(BorderFactory.createCompoundBorder());
        buttonNewGame.setBounds(280, 600,200,60);



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

