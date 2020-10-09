package com.leecode.BFS;

import java.util.*;

public class PondSizes {
    private static int[][] move = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    /**
     * 坐标点定义
     */
    private static class Position {
        private int row;
        private int col;

        public Position(int r, int c) {
            row = r;
            col = c;
        }
    }


    public static int[] pondSizes(int[][] land) {
        if (land == null || land.length == 0 || land[0].length == 0) {
            return new int[0];
        }
        //定义标记数组来标记该地方是否访问过
        int[][] mark = new int[land.length][land[0].length];
        List<Integer> areas = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                //只有该地方是池并且未访问过才进行查找
                if (land[i][j] == 0 && mark[i][j] == 0) {
                    int waterArea = getWaterArea(land, i, j, mark);
                    areas.add(waterArea);
                }
            }
        }
        Collections.sort(areas);
        //转化为 int数组
        int[] resAreas = new int[areas.size()];
        for (int i = 0; i < areas.size(); i++) {
            resAreas[i] = areas.get(i);
        }
        return resAreas;
    }

    /**
     * 使用宽度优先搜索求包含当前点的水域面积
     * @param land 地图
     * @param row 当前点的行坐标
     * @param col 当前点的列坐标
     * @param mark 记录该点是否被访问标记
     * @return 返回包含当前点的水域面积
     */
    private static int getWaterArea(int[][] land, int row, int col, int[][] mark) {
        int waterArea = 0;
        //创建队列保访问的地方
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(new Position(row, col));
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            mark[row][col] = 1;//访问过的地方进行标记，池塘面积+1
            waterArea += 1;
            //接下来开始尝试向8个方向走
            for (int i = 0; i < move.length; i++) {
                int nextRow = move[i][0] + position.row;
                int nextCol = move[i][1] + position.col;
                //方向正常 且 该地方是池塘 且 该地为访问过时  进入队列
                if (isNotBoundary(land, nextRow, nextCol)) {
                    if (land[nextRow][nextCol] == 0 && mark[nextRow][nextCol] == 0) {
                        queue.add(new Position(nextRow, nextCol));
                    }
                    mark[nextRow][nextCol] = 1;//计算面积中的池塘也进行访问标记
                }
            }
        }
        return waterArea;
    }

    //检查边界
    private static boolean isNotBoundary(int[][] land, int row, int col) {
        int rowBoundary = land.length - 1;
        int rolBoundary = land[0].length - 1;
        return row >= 0 && row <= rowBoundary && col >= 0 && col <= rolBoundary;
    }

    public static void main(String[] args) {
        int [][]land={
                {0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}
        };
        System.out.println(Arrays.toString(pondSizes(land)));
    }
}
