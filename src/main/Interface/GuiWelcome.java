package Interface;

import Logic.Gameplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiWelcome extends GuiTemplate implements ActionListener {

    private final JButton buttonWelcome;
    private final JLabel labelWelcome = new JLabel();
    public GuiWelcome() {
        this.setLayout(null);
        labelWelcome.setFont(new Font("Papyrus", Font.BOLD, 100));
        labelWelcome.setText("WELCOME!");
        labelWelcome.setBounds(200, 250,1000,120);
        buttonWelcome = new JButton();

        buttonWelcome.setFocusable(false);
        buttonWelcome.addActionListener(this);
        buttonWelcome.setText("okaaaay, let's go!");
        buttonWelcome.setHorizontalTextPosition(JButton.CENTER);
        buttonWelcome.setVerticalTextPosition(JButton.BOTTOM);
        buttonWelcome.setFont(new Font("Comic Sans", Font.BOLD, 30));
        buttonWelcome.setBounds(350, 450,400,50);


        this.add(labelWelcome);
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

    public JLabel getWelcomeLabel() {
        return labelWelcome;
    }

    public JButton getWelcomeButton() {
        return buttonWelcome;
    }
}
