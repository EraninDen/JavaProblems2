package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Valid_sudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '1', '9', '5', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '2', '.', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }; //output true

        char[][] boardFalse = new char[][]{
                new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }; //output false

        char[] row = {'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        char[] row2 = {'5', '3', '.', '.', '5', '.', '.', '.', '.'};
        char[] columns = {'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        char[] columns2 = {'5', '3', '.', '.', '5', '.', '.', '.', '.'};


        System.out.println(isRow(row));
        System.out.println(isRow(row2));
        System.out.println(isColumn(columns));
        System.out.println(isColumn(columns2));
    }


    public boolean isValidSudoku(char[][] board) {

        return false;

    }

    public static boolean isRow(char[] rows) {
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < rows.length - 1; i++) {
            if (rows[i] != '.') {
                if (!integerSet.add((int) rows[i]))
                    return false;
            }
        }
        return true;
    }

    public static boolean isColumn(char[] columns) {
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < columns.length - 1; i++) {
            if (columns[i] != '.') {
                if (!integerSet.add((int) columns[i]))
                    return false;
            }
        }
        return true;

    }

    public boolean isSquare(char[][] squares) {
        return true;

    }
    /*

Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
    */

}
