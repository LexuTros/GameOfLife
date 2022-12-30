package Interface;

import InterfaceHelpers.TextFieldGetPlayerName;
import Logic.Gameplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiGetPlayers extends GuiTemplate implements ActionListener {


    final JButton continueButton;
    private final JButton buttonChooseColor1;
    private final JButton buttonChooseColor2;
    private final TextFieldGetPlayerName textPlayerOne;
    private final TextFieldGetPlayerName textPlayerTwo;

    public static ArrayList<String> players;
    public static ArrayList<Color> colors = new ArrayList<>();

    public GuiGetPlayers(){


        this.setLayout(null);

        // Add standard Player color

        colors.add(Color.green);
        colors.add(Color.MAGENTA);

        // Panel continueButton

        continueButton = new JButton();
        continueButton.addActionListener(this);

        continueButton.setText("Click to continue");
        continueButton.setHorizontalTextPosition(JButton.CENTER);
        continueButton.setVerticalTextPosition(JButton.BOTTOM);
        continueButton.setFont(new Font("Comic Sans", Font.BOLD, 20));

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new BorderLayout());
        panelButton.setBounds(200,500,250,80);


        panelButton.add(continueButton);

        // Panel Title Frame

        JLabel titleFrame = new JLabel();
        titleFrame.setText("Please enter your names and pick colors:");
        titleFrame.setFont(new Font("Comic Sans", Font.BOLD, 40));
        titleFrame.setHorizontalTextPosition(JLabel.CENTER);
        titleFrame.setForeground(Color.darkGray);


        JPanel panelTitleFrame = new JPanel();
        panelTitleFrame.setLayout(new BorderLayout());
        panelTitleFrame.setBounds(200,150,800,80);
        panelTitleFrame.setBackground(new Color(0, 150, 240));

        panelTitleFrame.add(titleFrame);


        // Panel Player One

        JPanel panelGetPlayerOne = new JPanel();
        panelGetPlayerOne.setLayout(new BorderLayout());
        panelGetPlayerOne.setBounds(200,250,550,80);

        textPlayerOne = new TextFieldGetPlayerName();
        textPlayerOne.setText("Player 1");
        textPlayerOne.addActionListener(this);

        buttonChooseColor1 = new JButton("pick a color");
        buttonChooseColor1.setFont(new Font("Comic Sans", Font.BOLD, 15));
        buttonChooseColor1.addActionListener(this);

        panelGetPlayerOne.add(textPlayerOne, BorderLayout.WEST);
        panelGetPlayerOne.add(buttonChooseColor1, BorderLayout.CENTER);

        // Panel Player Two

        JPanel panelGetPlayerTwo = new JPanel();
        panelGetPlayerTwo.setLayout(new BorderLayout());
        panelGetPlayerTwo.setBounds(200,350,550,80);

        textPlayerTwo = new TextFieldGetPlayerName();
        textPlayerTwo.setText("Player 2");
        textPlayerTwo.addActionListener(this);

        buttonChooseColor2 = new JButton("pick a color");
        buttonChooseColor2.setFont(new Font("Comic Sans", Font.BOLD, 15));
        buttonChooseColor2.addActionListener(this);

        panelGetPlayerTwo.add(textPlayerTwo, BorderLayout.WEST);
        panelGetPlayerTwo.add(buttonChooseColor2, BorderLayout.CENTER);

        this.add(panelTitleFrame);
        this.add(panelGetPlayerOne);
        this.add(panelGetPlayerTwo);
        this.add(panelButton);
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonChooseColor1){
            Color color = JColorChooser.showDialog(null, "Pick a color", Color.black);
            buttonChooseColor1.setBackground(color);
            colors.set(0, color);
        }

        if (e.getSource() == buttonChooseColor2){
            Color color = JColorChooser.showDialog(null, "Pick a color", Color.black);
            buttonChooseColor2.setBackground(color);
            colors.set(1, color);
        }

        if (e.getSource() == continueButton) {
            players = new ArrayList<>();
            players.add(0, textPlayerOne.getText());
            players.add(1, textPlayerTwo.getText());
            this.dispose();
            Gameplay.initializePlayers();
        }
    }

        public static void main (String[]args){
            GuiGetPlayers players = new GuiGetPlayers();
        }

}

