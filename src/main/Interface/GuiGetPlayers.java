package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiGetPlayers extends GuiTemplate implements ActionListener {


    JButton button;
    JLabel titleFrame;
    JTextField playerOne;
    JTextField playerTwo;
    ArrayList<String> players;

    GuiGetPlayers(){

        this.setLayout(null);

        // Panel Button

        button = new JButton();
        button.addActionListener(this);

        button.setText("Click to continue");
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans", Font.BOLD, 20));
        button.setBorder(BorderFactory.createCompoundBorder());

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new BorderLayout());
        panelButton.setBounds(200,500,250,80);


        panelButton.add(button);

        // Panel Title Frame

        titleFrame = new JLabel();
        titleFrame.setText("Please enter your names:");
        titleFrame.setFont(new Font("Comic Sans", Font.BOLD, 40));
        titleFrame.setHorizontalTextPosition(JLabel.CENTER);
        titleFrame.setForeground(Color.white);


        JPanel panelTitleFrame = new JPanel();
        panelTitleFrame.setLayout(new BorderLayout());
        panelTitleFrame.setBounds(200,150,800,80);
        panelTitleFrame.setBackground(new Color(0, 150, 240));

        panelTitleFrame.add(titleFrame);


        // Panel Player One

        playerOne = new JTextField();
        playerOne.setFont(new Font("Consolas", Font.PLAIN, 35));
        playerOne.setForeground(Color.green);
        playerOne.setBackground(Color.black);
        playerOne.setCaretColor(Color.white);
        playerOne.setText("Player 1");
        playerOne.addActionListener(this);

        JPanel panelGetPlayerOne = new JPanel();
        panelGetPlayerOne.setLayout(new BorderLayout());
        panelGetPlayerOne.setBounds(200,250,400,80);


        panelGetPlayerOne.add(playerOne);

        // Panel Player One

        playerTwo = new JTextField();
        playerTwo.setFont(new Font("Consolas", Font.PLAIN, 35));
        playerTwo.setForeground(Color.green);
        playerTwo.setBackground(Color.black);
        playerTwo.setCaretColor(Color.white);
        playerTwo.setText("Player 2");

        JPanel panelGetPlayerTwo = new JPanel();
        panelGetPlayerTwo.setLayout(new BorderLayout());
        panelGetPlayerTwo.setBounds(200,350,400,80);

        panelGetPlayerTwo.add(playerTwo);

        this.add(panelTitleFrame);
        this.add(panelGetPlayerOne);
        this.add(panelGetPlayerTwo);
        this.add(panelButton);
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            players = new ArrayList<>();
            players.add(0, playerOne.getText());
            players.add(1, playerTwo.getText());
            System.out.println(players); }
    }

    public static void main(String[] args) {
        GuiGetPlayers players = new GuiGetPlayers();
    }
}

