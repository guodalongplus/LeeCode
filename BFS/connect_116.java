package com.leecode.BFS;

public class connect_116 {
    public int val;
    public connect_116 left;
    public connect_116 right;
    public connect_116 next;

    public connect_116() {}

    public connect_116(int _val) {
        val = _val;
    }

    public connect_116(int _val, connect_116 _left, connect_116 _right, connect_116 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
    public connect_116 connect(connect_116 root) {
        if(root==null){
            return root;
        }
        //fromLeft -> 指向每层最左边的结点
        connect_116 fromLeft=root;
        while(fromLeft.left!=null){
            //toNext -> 指向结点的next结点
            connect_116 toNext=fromLeft;
            while(toNext!=null){
                //同一个父结点时，直接指向
                toNext.left.next=toNext.right;
                //不同父节点时
                if(toNext.next!=null){
                    toNext.right.next=toNext.next.left;
                }
                toNext=toNext.next;
            }
            fromLeft=fromLeft.left;

        }
        return root;
    }
}

// if(root==null) return root;
// Queue<connect_116> queue=new LinkedList<>();
// queue.offer(root);
// while(!queue.isEmpty()){

//     int size=queue.size();
//     for(int i=0;i<size;i++){
//         connect_116 connect_116=queue.poll();
//          // z在不是该层最后一个节点时横向连接
//         if (i != size - 1) {
//             connect_116.next = queue.peek();
//         }

//         if(connect_116.left!=null){
//             queue.add(connect_116.left);
//         }
//         if(connect_116.right!=null){
//             queue.add(connect_116.right);
//         }
//     }
// }
// return root;
