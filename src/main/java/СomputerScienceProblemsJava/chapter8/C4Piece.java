package СomputerScienceProblemsJava.chapter8;

public enum C4Piece implements Piece{
    B, R, E;

    @Override
    public Piece opposite() {
        switch (this) {
            case B:
                return C4Piece.R;
            case R:
                return C4Piece.B;
            default:
                return C4Piece.E;
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case B:
                return "B";
            case R:
                return "R";
            default:
                return " ";
        }
    }
}
