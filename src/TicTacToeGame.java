import java.util.Scanner;

public class TicTacToeGame {
    char[][] board;
    Player currentPlayer;

    public TicTacToeGame() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        currentPlayer = new Player('X');
    }

    public void playGame() {
        while (true) {
            printBoard();
            int row = getInput("Enter row (0-2): ");
            int col = getInput("Enter column (0-2): ");
            if (isValidMove(row, col)) {
                makeMove(row, col);
                if (checkWin()) {
                    printBoard();
                    System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                    break;
                }
                switchPlayer();
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    private void makeMove(int row, int col) {
        board[row][col] = currentPlayer.getSymbol();
    }

    boolean checkWin() {
        // Check rows and columns for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return true;
            }
        }
        // Check diagonals for a win
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-')) {
            return true;
        }
        return false;
    }

    void switchPlayer() {
        currentPlayer = currentPlayer.getOpponent();
    }

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.playGame();
    }
}

class Player {
    private char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public Player getOpponent() {
        return new Player(symbol == 'X' ? 'O' : 'X');
    }
}
