package daily;

public class Problem_905 {
    public int[] sortArrayByParity(int[] nums) {
        int lens = nums.length;
        int[] res = new int[lens];
        int l = 0, r = lens - 1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) != 1){
                res[l++] = nums[i];
            }else {
                res[r--] = nums[i];
            }
        }
        return res;
    }
}
