package letcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 数组2个元素相加等于指定数字
 * @author Jinghe
 * @date 2021-05-28 0:49
 */
public class ArrIndexSum {

    public static void main(String[] args) {
        int[] nums = {5,4,2,7,9};
        int[] result = twoSum(nums, 7);
        if (Objects.nonNull(result)) {
            for (int i : result) {
                System.out.print(i + " ");
            }
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }
}
