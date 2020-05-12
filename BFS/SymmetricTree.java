import java.util.LinkedList;
import java.util.Queue;
//对称条件：首先得有一左一右的结构,即左右节点要么都是null要么都不是null,在此基础上如果都不是null值也要相等
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
   TreeNode(int x) { val = x; }
}
public class SymmetricTree {
    //迭代 BFS
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);//先把根节点插入两次，因为我们要一一比对左枝和右枝
        while (!q.isEmpty()) {//队列中有元素就执行
            TreeNode t1 = q.poll();//得到队列中前两个节点，并删除
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;//这种情况是左右都为空,但是至少有一对是对称。可能会有疑问地地方是他,t2为空怎么进入循环的？原来Queue可以add(null)
            if (t1 == null || t2 == null) return false;//有一个不存在,结构就不对称，直接返回结果
            if (t1.val != t2.val) return false;         //有一对值不相等就不对称，直接返回结果
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
/*时间复杂度：O(n)O(n)，因为我们遍历整个输入树一次，所以总的运行时间为 O(n)O(n)，其中 nn 是树中结点的总数。
空间复杂度：搜索队列需要额外的空间。在最糟糕情况下，我们不得不向队列中插入 O(n)O(n) 个结点。因此，空间复杂度为 O(n)O(n)。
*/
    //递归
//    public boolean isSymmetric(TreeNode root) {
//        return isMirror(root, root);
//    }
//
//    public boolean isMirror(TreeNode t1, TreeNode t2) {
//        if (t1 == null && t2 == null) return true;
//        if (t1 == null || t2 == null) return false;
//        return (t1.val == t2.val)
//                && isMirror(t1.right, t2.left)
//                && isMirror(t1.left, t2.right);
//    }
/*时间复杂度：O(n)O(n)，因为我们遍历整个输入树一次，所以总的运行时间为 O(n)O(n)，其中 nn 是树中结点的总数。
空间复杂度：递归调用的次数受树的高度限制。在最糟糕情况下，树是线性的，其高度为 O(n)O(n)。因此，在最糟糕的情况下，由栈上的递归调用造成的空间复杂度为 O(n)O(n)。
*/
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(2);
        TreeNode t4=new TreeNode(3);
        TreeNode t5=new TreeNode(4);
        TreeNode t6=new TreeNode(4);
        TreeNode t7=new TreeNode(3);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        SymmetricTree code=new SymmetricTree();
        System.out.println(code.isSymmetric(t1));
    }

}
