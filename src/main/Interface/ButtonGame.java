package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonGame extends JButton implements ActionListener {
    
    ButtonGame(){
        this.addActionListener(this);
        this.setText("DONE!");
        this.setBounds(10,550,160 ,30 );
        this.setFont(new Font("Comic Sans", Font.BOLD, 20));
        this.setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
