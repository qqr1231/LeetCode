// solution 1 : time: O(N^2), space:O(N^2) 
public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;
        int[][] count = new int[row][col];
        
        for (int i = 0;  i < row; i++) {
            for (int j = 0; j < col; j++) {
                count[i][j] = liveNeig(board, i, j);
            }
        }
        for (int i = 0;  i < row; i++) {
            for (int j = 0; j < col; j++) {
                //int count = liveNeig(board, i, j);
                if (board[i][j] == 1) {
                    if (count[i][j] < 2 || count[i][j] > 3) {
                        board[i][j] = 0;
                    }
                }else {
                    if (count[i][j] == 3) {
                        board[i][j] = 1;
                    }
                }
                
            }
        }
    }
    public int liveNeig(int[][]board, int i , int j) {
        int count = 0;
        for (int x = i-1; x < i+2; x++) {
            for (int y = j-1; y < j+2; y++) {
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                    if (board[x][y] == 1)   count++;
                }
            }
        }
        return board[i][j] == 1 ? count-1:count;
    }
}

// Solution 2 time: O(N^2), space:O(1) 
public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;
        //int[][] count = new int[row][col];
        
        
        for (int i = 0;  i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = liveNeig(board, i, j);
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = 2;
                    }
                }
                if (board[i][j] == 0) {
                    if (count == 3) {
                        board[i][j] = 3;
                    }
                }
                
            }
        }
        //System.out.println(Arrays.deepToString(board));
        for (int i = 0;  i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
    public int liveNeig(int[][]board, int i , int j) {
        int count = 0;
        for (int x = i-1; x < i+2; x++) {
            for (int y = j-1; y < j+2; y++) {
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                    if (board[x][y] == 1 || board[x][y] == 2)   count++;
                }
            }
        }
        return (board[i][j] == 1 || board[i][j] == 2) ? count-1:count;
    }
}