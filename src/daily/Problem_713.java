package daily;

public class Problem_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int mol = 1;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            mol = mol * nums[i];
            while (left <= i && mol >= k){
                mol = mol / nums[left];
                left++;
            }
            res += i - left + 1;
        }
        return res;
    }
}
