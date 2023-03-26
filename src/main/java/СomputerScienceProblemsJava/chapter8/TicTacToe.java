package СomputerScienceProblemsJava.chapter8;

import java.util.Scanner;

public class TicTacToe {

    private TTTBoard board = new TTTBoard();
    private Scanner scanner = new Scanner(System.in);

    private Integer getPlayerMove() {
        Integer playerMove = -1;
        while (!board.getLegalMove().contains(playerMove)) {
            System.out.println("Enter a legal square (0-8):");
            Integer play = scanner.nextInt();
            playerMove = play;
        }
        return playerMove;
    }

    private void runGame() {
        while (true) {
            Integer humanMove = getPlayerMove();
            board = (TTTBoard) board.move(humanMove);// кастомизация так как идея ругается!
            if (board.isWin()) {
                System.out.println("Human wins!!!");
                break;
            } else if (board.isDraw()) {
                System.out.println("Draw!!!");
                break;
            }
            Integer computerMove = Minimax.findBestMove(board, 9);
            System.out.println("Computer move is " + computerMove);
            board = (TTTBoard) board.move(computerMove);// кастомизация так как идея ругается!
            System.out.println(board);
            if (board.isWin()) {
                System.out.println("Computer wins!!!");
                break;
            } else if (board.isDraw()) {
                System.out.println("Draw!!!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToe().runGame();
    }
}
