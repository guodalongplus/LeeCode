package com.leecode.DFS;

import java.util.HashMap;

public class buildTree_106 {
    int val;
    buildTree_106 left;
    buildTree_106 right;

    buildTree_106(int x) {
        val = x;
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    int[] post;

    public buildTree_106 buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        post = postorder;
        buildTree_106 node = create(0, inorder.length - 1, 0, postorder.length - 1);
        return node;

    }

    /*
        i_S中序遍历起始地址
        i_E中序遍历结束地址
        p_S后续遍历起始地址
        p_S后续遍历结束地址

    */
    public buildTree_106 create(int i_S, int i_E, int p_S, int p_E) {
        if (i_S > i_E || p_S > p_E) {
            return null;
        }
        int root_val = post[p_E];
        //获取根节点在中序遍历中的位置
        int root_index = map.get(root_val);
        buildTree_106 node = new buildTree_106(root_val);
        /*以根节点为界限分为左右子树，左子树的中序遍历结果首地址为i_S,末地址为root_index-1;
        后序遍历结果中首地址为p_S,末地址为p_S+()root_index-i_S-1)（P_S+首地址距离根节点）

        */
        node.left = create(i_S, root_index - 1, p_S, p_S + root_index - i_S - 1);
        node.right = create(root_index + 1, i_E, p_S + root_index - i_S, p_E - 1);
        return node;
    }

}
