package СomputerScienceProblemsJava.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {

    public enum Cell {
        EMPTY(" "),
        BLOCKED("X"),
        START("S"),
        GOAL("G"),
        PATH("*");


        private final String code;

        private Cell(String c) {
            code = c;
        }

        @Override
        public String toString() {
            return code;
        }

        public static class MazeLocation {
            public final int row;
            public final int column;

            public MazeLocation(int row, int column) {
                this.row = row;
                this.column = column;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                MazeLocation that = (MazeLocation) o;
                return row == that.row && column == that.column;
            }

            @Override
            public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + column;
                result = prime * result + row;
                return result;
            }
        }
    }

    private final int rows, columns;
    private final Cell.MazeLocation start, goal;
    private Cell[][] grid;

    public Maze(int rows, int columns, Cell.MazeLocation start, Cell.MazeLocation goal, double sparseness) {
        this.rows = rows;
        this.columns = columns;
        this.start = start;
        this.goal = goal;
        grid = new Cell[rows][columns];
        for (Cell[] row : grid) {
            Arrays.fill(row, Cell.EMPTY);
        }
        randomFill(sparseness);
        grid[start.row][start.column] = Cell.START;
        grid[goal.row][goal.column] = Cell.GOAL;
    }

    public Maze() {
        this(25, 25, new Cell.MazeLocation(0, 0), new Cell.MazeLocation(24, 24), 0.2);
    }

    private void randomFill(double sparseness) {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (Math.random() < sparseness) {
                    grid[row][column] = Cell.BLOCKED;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                sb.append(cell.toString());
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public boolean goalTest(Cell.MazeLocation ml) {
        return goal.equals(ml);
    }

    List<Cell.MazeLocation> successors(Cell.MazeLocation ml) {
        List<Cell.MazeLocation> locations = new ArrayList<>();
        if (ml.row + 1 < rows && grid[ml.row + 1][ml.column] != Cell.BLOCKED) {
            locations.add(new Cell.MazeLocation(ml.row + 1, ml.column));
        }
        if (ml.row - 1 >= 0 && grid[ml.row - 1][ml.column] != Cell.BLOCKED) {
            locations.add(new Cell.MazeLocation(ml.row - 1, ml.column));
        }
        if (ml.column + 1 < columns && grid[ml.row][ml.column + 1] != Cell.BLOCKED) {
            locations.add(new Cell.MazeLocation(ml.row, ml.column + 1));
        }
        if (ml.column - 1 >= 0 && grid[ml.row][ml.column - 1] != Cell.BLOCKED) {
            locations.add(new Cell.MazeLocation(ml.row, ml.column - 1));
        }
        return locations;
    }

    public void mark(List<Cell.MazeLocation> path) {
        for (Cell.MazeLocation ml : path) {
            grid[ml.row][ml.column] = Cell.PATH;
        }
        grid[start.row][start.column] = Cell.START;
        grid[goal.row][goal.column] = Cell.GOAL;
    }

    public void clear(List<Cell.MazeLocation> path) {
        for (Cell.MazeLocation ml : path) {
            grid[ml.row][ml.column] = Cell.EMPTY;
        }
        grid[start.row][start.column] = Cell.START;
        grid[goal.row][goal.column] = Cell.GOAL;
    }

    public double euclideanDistance(Cell.MazeLocation ml) {
        int xdist = ml.column - goal.column;
        int ydist = ml.row - goal.row;
        return Math.sqrt((xdist * xdist) + (ydist * ydist));
    }

    public double manhattanDistance(Cell.MazeLocation ml) {
        int xdist = Math.abs(ml.column - goal.column);
        int ydist = Math.abs(ml.row - goal.row);
        return (xdist + ydist);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Maze m = new Maze();
            System.out.println(m);

            GenericSearch.Node<Cell.MazeLocation> solution1 = GenericSearch.dfs(
                    m.start, m::goalTest, m::successors);
            if (solution1 == null) {
                System.out.println("No solution found using depth-first search!");
            } else {
                List<Cell.MazeLocation> path1 = GenericSearch.nodeToPath(solution1);
                m.mark(path1);
                System.out.println(m);
                m.clear(path1);
            }

            GenericSearch.Node<Cell.MazeLocation> solution2 = GenericSearch.bfs(m.start, m::goalTest, m::successors);
            if (solution2 == null) {
                System.out.println("No solution found using breadth-first first search!");
            } else {
                List<Cell.MazeLocation> path2 = GenericSearch.nodeToPath(solution2);
                m.mark(path2);
                System.out.println(m);
                m.clear(path2);
            }

            GenericSearch.Node<Cell.MazeLocation> solution3 =
                    GenericSearch.astar(m.start, m::goalTest, m::successors, m::manhattanDistance);
            if (solution3 == null) {
                System.out.println("No solution found using A*!");
            } else {
                List<Cell.MazeLocation> path3 = GenericSearch.nodeToPath(solution3);
                m.mark(path3);
                System.out.println(m);
                m.clear(path3);
            }
        }
    }
}
