package Interface;

import DataStructure.Cell;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelGrid extends JPanel {

    ArrayList <Cell> cellsMultiDimensional;

    PanelGrid() {
        this.setPreferredSize(new Dimension(1000,750));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(75,100));
        for (int i = 1; i <= 75; i++)
            for (int j = 1; j <= 100; j++)
            {
                Cell cell = new Cell(j,i);
                this.add(cell);
            } ;


    }
}