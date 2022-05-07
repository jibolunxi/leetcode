package daily;

import java.util.*;

/**
 * @author yhchen
 * @date 2022/5/7
 **/
public class Problem_433 {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)){
            return -1;
        }
        Set<String> dealt = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> res = new LinkedList<>();
        queue.offer(start);
        dealt.add(start);
        res.offer(0);
        List<Integer> allRes = new ArrayList<>();
        while (!queue.isEmpty()){
            String cur = queue.poll();
            int cur_res = res.poll();
            for (int i = 0; i < cur.length(); i++) {
                String newStr = cur.substring(0, i) + "A" + cur.substring(i + 1);
                if (newStr.equals(end)){
                    allRes.add(cur_res + 1);
                }else if (!dealt.contains(newStr) && bankSet.contains(newStr)){
                    dealt.add(newStr);
                    queue.offer(newStr);
                    res.offer(cur_res + 1);
                }
                newStr = cur.substring(0, i) + "C" + cur.substring(i + 1);
                if (newStr.equals(end)){
                    allRes.add(cur_res + 1);
                }else if (!dealt.contains(newStr) && bankSet.contains(newStr)){
                    dealt.add(newStr);
                    queue.offer(newStr);
                    res.offer(cur_res + 1);
                }
                newStr = cur.substring(0, i) + "G" + cur.substring(i + 1);
                if (newStr.equals(end)){
                    allRes.add(cur_res + 1);
                }else if (!dealt.contains(newStr) && bankSet.contains(newStr)){
                    dealt.add(newStr);
                    queue.offer(newStr);
                    res.offer(cur_res + 1);
                }
                newStr = cur.substring(0, i) + "T" + cur.substring(i + 1);
                if (newStr.equals(end)){
                    allRes.add(cur_res + 1);
                }else if (!dealt.contains(newStr) && bankSet.contains(newStr)){
                    dealt.add(newStr);
                    queue.offer(newStr);
                    res.offer(cur_res + 1);
                }
            }
        }
        if (allRes.size() > 0){
            return Collections.min(allRes);
        }
        return  -1;
    }

    public static void main(String[] args) {
        Problem_433 pr = new Problem_433();
        String start = "AAAACCCC";
        String end = "CCCCCCCC";
        String[] bank = {"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"};
        System.out.println(pr.minMutation(start, end, bank));
    }
}
