package leetcode;

/**
 * 最长公共前缀
 * @author JingHe
 * @date 2021-07-19 16:25
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] s = {"a"};
        System.out.println(longestCommonPrefix(s));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String match = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < match.length() && j < strs[i].length(); j++) {
                if (match.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            match = match.substring(0, j);
        }
        return match;
    }
}
