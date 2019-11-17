package it.coderetreat;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int rows;
    private final int cols;

    private boolean[] cells;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new boolean[rows*cols];
    }

    public boolean isAlive(int row, int col) {
        return cells[index(row, col)];
    }

    public void setAlive(int row, int col) {
        cells[index(row, col)] = true;
    }

    private boolean checkIndex(int row, int col) {
        if (row < 0 || col < 0 ) {
            return false;
        }
        if (row >= rows || col >= cols) {
            return false;
        }
        return true;
    }

    private int index(int row, int col) {
        if (!checkIndex(row, col)) {
            throw new IllegalArgumentException();
        }
        return unsafeIndex(row, col);
    }

    private int unsafeIndex(int row, int col) {
        return row + col * rows;
    }

    public int countNeighbors(int row, int col) {
        List<Integer> indexes = new ArrayList<>();

        indexes.add(unsafeIndex(row-1, col-1));
        indexes.add(unsafeIndex(row-1, col-0));
        indexes.add(unsafeIndex(row-1, col+1));
        indexes.add(unsafeIndex(row-0, col-1));
        indexes.add(unsafeIndex(row-0, col+1));
        indexes.add(unsafeIndex(row+1, col-1));
        indexes.add(unsafeIndex(row+1, col-0));
        indexes.add(unsafeIndex(row+1, col+1));

        int sum = 0;
        for (Integer i : indexes) {
            if (i >= 0 && i < rows*cols && cells[i] ) {
                sum++;
            }
        }
        return sum;
    }
}
