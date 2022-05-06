package daily;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_933 {

    private Queue<Integer> tQue;

    public Problem_933() {
        tQue = new LinkedList<>();
    }

    public int ping(int t) {
        tQue.offer(t);
        while (tQue.peek() + 3000 < t){
            tQue.poll();
        }
        return tQue.size();
    }
}
