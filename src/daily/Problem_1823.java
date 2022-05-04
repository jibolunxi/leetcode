package daily;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_1823 {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1){
            int tmp = k - 1;
            while (tmp-- > 0){
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        Problem_1823 problem = new Problem_1823();
        System.out.println(problem.findTheWinner(5, 2));
    }
}
