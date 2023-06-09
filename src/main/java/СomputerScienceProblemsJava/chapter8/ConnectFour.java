package СomputerScienceProblemsJava.chapter8;

import java.util.Scanner;

public class ConnectFour {

    private C4Board board = new C4Board();
    private Scanner scanner = new Scanner(System.in);

    private Integer getPlayerMove() {
        Integer playerMove = -1;
        while (!board.getLegalMove().contains(playerMove)) {
            System.out.println("Enter a legal column (0-6): ");
            Integer play = scanner.nextInt();
            playerMove = play;
        }
        return playerMove;
    }

    private void runGame() {
        while(true) {
            Integer humanMove = getPlayerMove();
            board = (C4Board) board.move(humanMove);// Закастомил!!!
            if (board.isWin()) {
                System.out.println("Human wins!!!");
                break;
            } else if (board.isDraw()) {
                System.out.println("Draw!!!");
                break;
            }
            Integer computerMove = Minimax.findBestMove(board, 5);
            System.out.println("Computer move is " + computerMove);
            board = (C4Board) board.move(computerMove);//закастомил!!!
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
        new ConnectFour().runGame();
    }
}
