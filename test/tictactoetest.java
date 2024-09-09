import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class tictactoetest {
    @Test
    public void testWinningGame() {
        TicTacToeGame game = new TicTacToeGame();
        game.board[0][0] = 'X';
        game.board[0][1] = 'X';
        game.board[0][2] = 'X';
        assertTrue(game.checkWin());
    }

    @Test
    public void testNonWinningGame() {
        TicTacToeGame game = new TicTacToeGame();
        game.board[0][0] = 'X';
        game.board[1][1] = 'O';
        game.board[2][2] = 'X';
        assertFalse(game.checkWin());
    }

    @Test
    public void testSwitchPlayer() {
        TicTacToeGame game = new TicTacToeGame();
        assertEquals('X', game.currentPlayer.getSymbol());
        game.switchPlayer();
        assertEquals('O', game.currentPlayer.getSymbol());
    }
}
