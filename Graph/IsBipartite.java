package com.leecode.Graph;

import java.util.Arrays;
import java.util.Stack;
/*785
* 给定一个无向图graph，当这个图为二分图时返回true。
如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值
*/
public class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);//用-1填充color,没有指定位置的话，默认填充所有

        for (int start = 0; start < n; ++start) {
            if (color[start] == -1) {
                Stack<Integer> stack = new Stack();
                stack.push(start);
                color[start] = 0;

                while (!stack.empty()) {
                    Integer node = stack.pop();
                    for (int nei: graph[node]) {
                        if (color[nei] == -1) {
                            stack.push(nei);
                            color[nei] = color[node] ^ 1;//还未染色的话，把该值去另外一个值,这里是异或运算，二进制位相同为0不同为1
                        } else if (color[nei] == color[node]) {//若两个颜色相等即值相同不能分为A,B
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsBipartite is=new IsBipartite();
        int [][]p={{1,3}, {0,2}, {1,3}, {0,2}};
        System.out.println(is.isBipartite(p));
    }
}
