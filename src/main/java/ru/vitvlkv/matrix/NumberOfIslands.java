package ru.vitvlkv.matrix;

import java.util.*;

public class NumberOfIslands {
    private int result = 0;
    private final static char LAND = '1';
    private final static char WATER = '0';
    private final static char LAND_VISITED = '2';

    public int numIslands(char[][] grid) {
        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[r].length; ++c) {
                if (grid[r][c] == WATER) {
                    continue;
                }
                if (grid[r][c] == LAND_VISITED) {
                    continue;
                }
                grid[r][c] = LAND_VISITED;
                Queue<Cell> cellsToDiscover = new LinkedList<>();
                cellsToDiscover.add(new Cell(r, c));
                discoverLand(cellsToDiscover, grid);
                ++result;
            }
        }
        return result;
    }

    private void discoverLand(Queue<Cell> cellsToDiscover, char[][] grid) {
        while (!cellsToDiscover.isEmpty()) {
            Cell cur = cellsToDiscover.poll();
            List<Cell> nearbyLand = cur.nearbyCells(grid);
            cellsToDiscover.addAll(nearbyLand);
        }
    }

    private static class Cell {
        public final int r;
        public final int c;

        public Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public List<Cell> nearbyCells(char[][] grid) {
            int rMax = grid.length;
            int cMax = grid[r].length;
            List<Cell> cells = new ArrayList<>();
            if (r - 1 >= 0 && grid[r - 1][c] == LAND) {
                cells.add(new Cell(r - 1, c));
                grid[r - 1][c] = LAND_VISITED;
            }
            if (c - 1 >= 0 && grid[r][c - 1] == LAND) {
                cells.add(new Cell(r, c - 1));
                grid[r][c - 1] = LAND_VISITED;
            }
            if (r + 1 < rMax && grid[r + 1][c] == LAND) {
                cells.add(new Cell(r + 1, c));
                grid[r + 1][c] = LAND_VISITED;
            }
            if (c + 1 < cMax && grid[r][c + 1] == LAND) {
                cells.add(new Cell(r, c + 1));
                grid[r][c + 1] = LAND_VISITED;
            }

            return cells;
        }
    }
}