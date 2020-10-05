
import java.util.*;
public  class LevelOrderBottom {
    int val;
    LevelOrderBottom left;
    LevelOrderBottom right;

    LevelOrderBottom(int x) {
        val = x;
    }
    public static List<List<Integer>> levelOrderBottom(LevelOrderBottom root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }
        //存放最终结果
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        //创建一个队列，将根节点放入其中
        Queue<LevelOrderBottom> queue = new LinkedList<LevelOrderBottom>();
        //先将root入队
        queue.offer(root);
        while(!queue.isEmpty()) {
            //每次遍历的数量为队列的长度
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();

            for(int i=0;i<size;++i) {
                LevelOrderBottom node = queue.poll();//从队列头部删除一个元素
                tmp.add(node.val);
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
            res.add(tmp);//将该层元素添加到结果集
        }
        //翻转结果
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {

        LevelOrderBottom root = new LevelOrderBottom(3);
        LevelOrderBottom left = new LevelOrderBottom(9);
        LevelOrderBottom right = new LevelOrderBottom(20);
        LevelOrderBottom right1 = new LevelOrderBottom(15);
        LevelOrderBottom right2 = new LevelOrderBottom(7);
        root.left = left;
        root.right = right;
        right.left = right1;
        right.right = right2;
        System.out.println(levelOrderBottom(root));
    }
}
