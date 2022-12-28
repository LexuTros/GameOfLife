package Interface;

import Logic.Gameplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiWelcome extends GuiTemplate implements ActionListener {

    private final JButton buttonWelcome;
    public GuiWelcome() {
        this.setLayout(null);
        JLabel welcome = new JLabel();
        welcome.setFont(new Font("Papyrus", Font.BOLD, 100));
        welcome.setText("WELCOME!");
        welcome.setBounds(200, 250,1000,120);
        buttonWelcome = new JButton();

        buttonWelcome.addActionListener(this);
        buttonWelcome.setText("okaaaay, let's go!");
        buttonWelcome.setHorizontalTextPosition(JButton.CENTER);
        buttonWelcome.setVerticalTextPosition(JButton.BOTTOM);
        buttonWelcome.setFont(new Font("Comic Sans", Font.BOLD, 30));
        buttonWelcome.setBounds(350, 450,400,50);


        this.add(welcome);
        this.add(buttonWelcome);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonWelcome){
            this.dispose();
            Gameplay.askPlayerNames();

        }
    }
}
