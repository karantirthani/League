package dsa.practice.graph;

import java.util.*;

class SlidingGame {
    int[][] idealBoard = new int[][]{{1, 2, 3}, {4, 5, 0}};
    int[][] availableMoves = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int getInversions(int[][] board) {
        int inversions = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != idealBoard[i][j]) {
                    inversions++;
                }
            }
        }
        return inversions;
    }

    private int[] zeroPosition(int[][] board) {
        int zerox = 0;
        int zeroy = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    zerox = i;
                    zeroy = j;
                }
            }
        }
        return new int[]{zerox, zeroy};
    }

    private String convertToBoard(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }

    public int slidingPuzzle(int[][] board) {
        Map<String, Boolean> visited = new HashMap<>();
        Queue<int[][]> q = new LinkedList<>();
        q.offer(board);
        int moves = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            System.out.println(moves);
            for (int i = 0; i < n; i++) {
                int[][] currentBoard = q.poll();
                String boardString = convertToBoard(currentBoard);
                visited.put(boardString, true);
                int inversions = getInversions(currentBoard);
                if (inversions == 0) {
                    return moves;
                }
                //add children
                int[] zeroPos = zeroPosition(currentBoard);
                for (int[] move : availableMoves) {
                    int newX = zeroPos[0] + move[0];
                    int newY = zeroPos[1] + move[1];
                    if (newX >= 0 && newX < 2 && newY >= 0 && newY < 3) {
                        int temp = currentBoard[newX][newY];
                        currentBoard[zeroPos[0]][zeroPos[1]] = temp;
                        currentBoard[newX][newY] = 0;
                        String boardStr = convertToBoard(currentBoard);
                        if (!visited.containsKey(boardStr)) {
                            System.out.println(boardStr);
                            q.offer(Arrays.stream(currentBoard).map(int[]::clone).toArray(int[][]::new));
                        }
                        currentBoard[newX][newY] = temp;
                        currentBoard[zeroPos[0]][zeroPos[1]] = 0;
                    }
                }

            }
            moves++;
        }
        return -1;
    }
}