package daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Problem_1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList();
        Queue<Integer> tree1 = new LinkedList();
        Queue<Integer>  tree2 = new LinkedList();
        InorderTraversal(root1, tree1);
        InorderTraversal(root2, tree2);

        while (!tree1.isEmpty() && !tree2.isEmpty()){
            if (tree1.peek() < tree2.peek()){
                res.add(tree1.poll());
            }else {
                res.add(tree2.poll());
            }
        }
        while (!tree1.isEmpty()){
            res.add(tree1.poll());
        }
        while (!tree2.isEmpty()){
            res.add(tree2.poll());
        }

        return res;
    }

    public void InorderTraversal(TreeNode root, Queue<Integer> list){
        if (root == null){
            return;
        }
        if (root.left != null){
            InorderTraversal(root.left, list);
        }
        list.offer(root.val);
        if (root.right != null){
            InorderTraversal(root.right, list);
        }
    }

}
