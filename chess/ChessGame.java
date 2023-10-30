import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Console Chess Game!");

        while (true) {
            board.display();
            System.out.print("Enter your move (e.g., 'e2 to e4'): ");
            String move = scanner.nextLine();

            if (isValidMove(move, board)) {
                board.makeMove(move);
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private static boolean isValidMove(String move, ChessBoard board) {

        return true;
    }
}

class ChessBoard {
    private char[][] board = new char[8][8];

    public ChessBoard() {

        char[][] startingPosition = {
                { 'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r' },
                { 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' },
                { 'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R' }
        };

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = startingPosition[i][j];
            }
        }
    }

    public void display() {
        System.out.println("  a b c d e f g h");
        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(8 - i);
        }
        System.out.println("  a b c d e f g h");
    }

    public void makeMove(String move) {

    }
}
