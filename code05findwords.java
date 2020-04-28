package com.leecode.tree;

public class code05findwords {
    private boolean[][] marked;
//点可以移动的位置“十”
    //        x-1,y
    // x,y-1  x,y     x,y+1
    //        x+1,y
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    // 盘面上有多少行
    private int m;
    // 盘面上有多少列
    private int n;
    private String word;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];//二维的布尔型矩阵记录走过的位置
        this.word = word;
        this.board = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        //走一步需要比较对应的字符串是否相等
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true;//把点已走过所在位置标记为true表示为
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];//每个点有4个方向，但是处于边缘位置的点会出圈，需要把这种情况过滤用inArea函数
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]) {//点在圈内   和  新的位置没有走过开始广度优先搜索
                    if (dfs(newX, newY, start + 1)) {//此时start要加一 ，因为新位置可以走，此时的字母需要和字符串对应位置作比较
                        return true;
                    }
                }
            }
            //走到这部说明（i,j）该点没有向任意个方向走，但是通过其他方式也会经过该点，所以不能直接标注为已走过。
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {

        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        String word = "ABCCED";

//
//        char[][] board = {{'a', 'b'}};
//        String word = "ba";
        code05findwords solution = new code05findwords();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }

}
