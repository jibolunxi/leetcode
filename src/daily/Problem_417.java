package daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m,n;
        List res = new ArrayList<ArrayList<Integer>>();

        m = heights.length;
        if(m > 0) {
            n = heights[0].length;
        }else {
            return res;
        }

        int[][] target_l = new int[m][n];
        for (int i = 0; i < n; i++) {
            target_l[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            target_l[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (target_l[i][j] == 1){
                    bfs(heights, target_l, i, j, m, n);
                }
            }
        }

        int[][] target_r = new int[m][n];
        for (int i = 0; i < n; i++) {
            target_r[m-1][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            target_r[i][n-1] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (target_r[i][j] == 1) {
                    bfs(heights, target_r, i, j, m, n);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (target_l[i][j] == 1 && target_r[i][j] == 1){
                    List pos = new ArrayList<Integer>();
                    pos.add(i);
                    pos.add(j);
                    res.add(pos);
                }
            }
        }

        return res;
    }

    public void bfs(int[][] nums, int[][] target, int i, int j, int m, int n){
        Queue<List<Integer>> queue = new LinkedList<>();
        List pos = new ArrayList<Integer>();
        pos.add(i);
        pos.add(j);
        queue.offer(pos);

        while (!queue.isEmpty()) {
            ArrayList<Integer> cur_pos = (ArrayList<Integer>) queue.poll();
            i = cur_pos.get(0);
            j = cur_pos.get(1);
            if (j - 1 >= 0 && target[i][j - 1] != 1) {
                if (nums[i][j] <= nums[i][j - 1]) {
                    pos = new ArrayList<Integer>();
                    pos.add(i);
                    pos.add(j-1);
                    queue.offer(pos);
                    target[i][j - 1] = 1;
                }
            }
            if (i - 1 >= 0 && target[i - 1][j] != 1) {
                if (nums[i][j] <= nums[i - 1][j]) {
                    pos = new ArrayList<Integer>();
                    pos.add(i-1);
                    pos.add(j);
                    queue.offer(pos);
                    target[i - 1][j] = 1;
                }
            }
            if (j + 1 < n && target[i][j + 1] != 1) {
                if (nums[i][j] <= nums[i][j + 1]) {
                    pos = new ArrayList<Integer>();
                    pos.add(i);
                    pos.add(j+1);
                    queue.offer(pos);
                    target[i][j + 1] = 1;
                }
            }
            if (i + 1 < m && target[i + 1][j] != 1) {
                if (nums[i][j] <= nums[i + 1][j]) {
                    pos = new ArrayList<Integer>();
                    pos.add(i+1);
                    pos.add(j);
                    queue.offer(pos);
                    target[i + 1][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Problem_417 problem_417 = new Problem_417();
        int[][] heights = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        problem_417.pacificAtlantic(heights);
    }
}
