package daily;

/***
 **   @author yhchen
 **   @date 2022/5/9
 ****/
public class Problem_942 {
    public int[] diStringMatch(String s) {
        int left = 0, right = s.length();
        int[] res = new int[right + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I'){
                res[i] = left;
                left++;
            }else {
                res[i] = right;
                right--;
            }
        }
        res[s.length()] = left;
        return res;
    }

    public static void main(String[] args) {
        Problem_942 pr = new Problem_942();
        pr.diStringMatch("IDID");
    }
}
