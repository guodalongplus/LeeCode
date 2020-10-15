package com.leecode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CloneGraph {

    public int val;
    public List<CloneGraph> neighbors;

    public CloneGraph() {
        val = 0;
        neighbors = new ArrayList<CloneGraph>();
    }

    public CloneGraph(int _val) {
        val = _val;
        neighbors = new ArrayList<CloneGraph>();
    }

    public CloneGraph(int _val, ArrayList<CloneGraph> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }


    public static CloneGraph cloneGraph(CloneGraph CloneGraph){
        if(CloneGraph==null){
            return CloneGraph;
        }
        //建立哈希表保存结点间的关系
        HashMap<CloneGraph,CloneGraph> visited=new HashMap();
        LinkedList<CloneGraph> queue=new LinkedList<>();
        queue.add(CloneGraph);
        visited.put(CloneGraph,new CloneGraph(CloneGraph.val,new ArrayList<CloneGraph>()));

        while(!queue.isEmpty()){
            CloneGraph n=queue.remove();
            //遍历该节点的邻接结点
            for(CloneGraph p:n.neighbors){
                if(!visited.containsKey(p)){
                    //如果没有访问过，就放到哈希表中存储
                    visited.put(p,new CloneGraph(p.val,new ArrayList()));
                    queue.add(p);
                }
                //更新该节点的邻接结点
                visited.get(n).neighbors.add(visited.get(p));
            }
        }
        return visited.get(CloneGraph);

    }

    public static void main(String[] args) {
        CloneGraph CloneGraph1 = new CloneGraph(1);
        CloneGraph CloneGraph2 = new CloneGraph(2);
        CloneGraph CloneGraph3 = new CloneGraph(3);
        CloneGraph CloneGraph4 = new CloneGraph(4);
        ArrayList<CloneGraph> CloneGraph1List = new ArrayList<>();
        CloneGraph1List.add(CloneGraph2);
        CloneGraph1List.add(CloneGraph4);
        CloneGraph1.neighbors = CloneGraph1List;
        ArrayList<CloneGraph> CloneGraph2List = new ArrayList<>();
        CloneGraph2List.add(CloneGraph1);
        CloneGraph2List.add(CloneGraph3);
        CloneGraph2.neighbors = CloneGraph2List;
        ArrayList<CloneGraph> CloneGraph3List = new ArrayList<>();
        CloneGraph3List.add(CloneGraph2);
        CloneGraph3List.add(CloneGraph4);
        CloneGraph3.neighbors = CloneGraph3List;
        ArrayList<CloneGraph> CloneGraph4List = new ArrayList<>();
        CloneGraph4List.add(CloneGraph1);
        CloneGraph4List.add(CloneGraph3);
        CloneGraph4.neighbors = CloneGraph4List;
        System.out.println(cloneGraph(CloneGraph1));
    }
}
