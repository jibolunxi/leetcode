package daily;

public class Problem_908 {
    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        if (max - min <= 2 * k){
            return 0;
        }else {
            return max - min - 2 * k;
        }
    }
}
