package leetcode;

/**
 * 查询字符串最长不连续子串长度
 * @author JingHe
 * @date 2021-06-06 16:08
 */
public class MaxLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 双链表法
     * l r 分别代表当前最大长度下标 r不断往后移动,然后循环判断当前字符和已有的
     * 最大子串是否冲突，冲突则把左下标设置为重复的下一个字符。
     * @param s 字符串
     * @return 最大子串长度
     */
    public static int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        //r下标遍历
        for (; r < s.length(); r++) {
            //当前r的新值是否和原来重复
            for (int k = l; k < r; k++) {
                if (s.charAt(r) == s.charAt(k)) {
                    //重复代表则移动左下标到k+1
                    l = k + 1;
                    break;
                }
            }
            //判断当前的长度是否比之前探测的都大
            if (r - l + 1 > max) {
                max = r - l + 1;
            }
        }
        return max;
    }
}
