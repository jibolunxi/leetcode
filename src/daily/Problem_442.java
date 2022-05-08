package daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 **   @author yhchen
 **   @date 2022/5/8
 ****/

public class Problem_442 {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i){
                if (res.contains(nums[i])){
                    continue;
                }else {
                    if (nums[nums[i] - 1] - 1 == nums[i] - 1){
                        res.add(nums[i]);
                        continue;
                    }else {
                        swap(nums, i, nums[i] - 1);
                        i--;
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
