package СomputerScienceProblemsJava.chapter8;

import java.util.List;

public interface Board<Move> {

    Piece getTurn();

    Board<Move> move(Move location);

    List<Move> getLegalMove();

    boolean isWin();

    default boolean isDraw() {
        return !isWin() && getLegalMove().isEmpty();
    }

    double evaluate(Piece player);
}
