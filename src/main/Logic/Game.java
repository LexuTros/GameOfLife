package Logic;


public class Game {
//
//    private static final String ANSI_RESET = "\u001B[0m";
//    private static final String ANSI_RED = "\u001B[31m";
//    private static final String ANSI_GREEN = "\u001B[32m";
//    private static final String ANSI_YELLOW = "\033[0;93m";
//    private static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
//    private static int playerIndex = 0;
//
//
//    protected String getPlayerName() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Player number " + ++playerIndex +", please enter your " + ANSI_YELLOW + "name" + ANSI_RESET + ":");
//        while (true) {
//            String inputName = scanner.nextLine();
//            if (inputName.length() > 18) {
//                System.out.println(ANSI_RED + "Please enter a shorter name!" + ANSI_RESET);
//            } else if (inputName.length() < 1) {
//                System.out.println(ANSI_RED + "Please enter a longer name!" + ANSI_RESET);
//            } else {
//                return inputName;
//            }
//        }
//    }
//
//    protected ArrayList<Integer> getBoardSize() {
//        ArrayList<Integer> boardInputSize = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.print("Please enter the " + ANSI_YELLOW + "width " + ANSI_RESET + "of the board: ");
//            int width = scanner.nextInt();
//
//            System.out.print("Please enter the " + ANSI_YELLOW + "height " + ANSI_RESET + "of the board: ");
//            int height = scanner.nextInt();
//
//            if (width == height) {
//                boardInputSize.add(width);
//                boardInputSize.add(height);
//
//                return boardInputSize;
//            }
//
//            System.out.println(ANSI_RED + "Width and height of board must be equal! Please try again." + ANSI_RESET);
//        }
//
//    }
//
//
//    protected String getPlayerColor(Player otherPlayer) {
//        Scanner scanner = new Scanner(System.in);
//        String possibleColors = "red, green, blue, purple, black, yellow, orange, gray";
//        if (otherPlayer != null) {
//            possibleColors = possibleColors.replace(otherPlayer.getPlayerColor().toLowerCase(), otherPlayer.getPlayerColor().toLowerCase() + " (unavailable)");
//        }
//        System.out.println("Player number "+ playerIndex +", please enter your " + ANSI_YELLOW + "color " + ANSI_RESET + "from the following ones: (" + possibleColors + ")" + ":");
//        while (true) {
//            String inputColor = scanner.nextLine();
//            try {
//                Color color = Color.valueOf(inputColor.toUpperCase()); // Check if inputColor is a valid color
//                if (otherPlayer == null) {
//                    return inputColor;
//                }
//                else {
//                    if (color == otherPlayer.getPlayerColor()) {
//                        System.out.println(ANSI_RED + "Error: This color is already in use by another player. Please select a different color." + ANSI_RESET);
//                    } else {
//                        return inputColor;
//                    }
//                }
//            } catch (IllegalArgumentException e) {
//                System.out.println(ANSI_RED + "Error: Invalid color, please select one of the possible colors!" + ANSI_RESET);
//            } catch (NoSuchElementException e) {
//                throw new IllegalArgumentException(ANSI_RED + "Error: This color is already in use by another player. Please select a different color." + ANSI_RESET);
//            }
//        }
//    }
//
//
//
//
//    protected boolean askForNewGame () {
//        Scanner getYesOrNo = new Scanner(System.in);
//        System.out.println("Do you want to start a new game? (" + ANSI_GREEN + "yes" + ANSI_RESET + " / " + ANSI_RED + "no" + ANSI_RESET + ")");
//        String answer = getYesOrNo.nextLine();
//        while (true) {
//            if (Objects.equals(answer, "yes")) { return true; }
//            if (Objects.equals(answer, "no")) { return false; }
//        }
//    }
//
//    private void startGame() throws InvalidHeight, InvalidWidth {
//
//
//
//        //GUI GuiManager = GUI.getInstance();
//        Player player1 = new Player(getPlayerName(), getPlayerColor(null));
//        Player player2 = new Player(getPlayerName(), getPlayerColor(player1));
//
//        ArrayList<Integer> boardSize = getBoardSize();
//        int boardWidth = boardSize.get(0);
//        int boardHeight = boardSize.get(1);
//
//        Board gameBoard = new Board(boardWidth, boardHeight);
//
//        //GuiManager.displayGame();
//        Player activePlayer = player1.getPlayerName().compareToIgnoreCase(player2.getPlayerName()) <= 0 ? player1 : player2;
//
//        while (player1.isAlive() && player2.isAlive()) {
//
//
//            if (activePlayer == player1) {
//
//                //TODO
//                //Round.playRound(player1, gameBoard);
//                activePlayer = player2;
//            } else {
//                //TODO
//                //Round.playRound(player2, gameBoard);
//                activePlayer = player1;
//            }
//        }
//        if (!player1.isAlive()) {
//            System.out.println(GREEN_BOLD_BRIGHT + player2.getPlayerName() + ", Congratulations, you won the game!" + ANSI_RESET);
//        } else {
//            System.out.println(GREEN_BOLD_BRIGHT + player1.getPlayerName() + ", Congratulations! You won the game!" + ANSI_RESET);
//        }
//        if (askForNewGame()) {
//            playerIndex = 0;
//            startGame();
//        }
//    }
//    public static void main(String[] args) throws InvalidHeight, InvalidWidth {
//        Game g = new Game();
//        g.startGame();
//    }
}