package DataStructure;

public class Player {
    private String name;
    private Color color;
    private int aliveCells;


    public Player(String name, String color) {
        this.name = name;
        this.color = Color.valueOf(color.toUpperCase());
        this.aliveCells = 0;;

    }

    public void setAliveCells(int numberOfCells) {
        aliveCells += numberOfCells;
    }

    public int getAliveCells() {
        return aliveCells;
    }

    public String getPlayerName() {
        return name;
    }

    public Color getPlayerColor() {
        return color;
    }

    public boolean isAlive()
    {
        return getAliveCells() > 0;
    }

}
