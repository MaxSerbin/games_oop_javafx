package ru.job4j.puzzle;

public class Win {
        public static boolean monoHorizontal(int[][] board, int row) {
            boolean rsl = true;
            for (int i = 0; i < board.length; i++) {
                if (board[row][i] != 1) {
                    rsl = false;
                    break;
                }
            }
            return rsl;
        }

        public static boolean monoVertical(int[][] board, int column) {
            boolean rsl = true;
            for (int i = 0; i < board.length; i++) {
                if (board[i][column] != 1) {
                    rsl = false;
                    break;
                }
            }
            return rsl;
        }
        public static boolean check(int[][] board) {
            boolean rsl = false;
            for (int i = 0; i < board.length; i++) {
                if (1 == board[i][i]) {
                    if (monoHorizontal(board, i) || monoVertical(board, i)) {
                        rsl = true;
                        break;
                    }
                }
            }
            return rsl;
        }
    }

