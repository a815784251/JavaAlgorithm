package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JingHe
 * @date 2021-07-22 20:35
 */
public class ConvertZ {

    public static void main(String[] args) {
        String s = "123456789";
        System.out.println(convert(s, 3));
    }

    public static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> r = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            r.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goOn = false;
        for (char c : s.toCharArray()) {
            r.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goOn = !goOn;
            }
            curRow += goOn ? 1 : -1;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : r) {
            sb.append(stringBuilder.toString());
        }
        return sb.toString();
    }
}
