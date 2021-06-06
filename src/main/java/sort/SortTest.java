package sort;

/**
 * 数组2个元素相加等于指定数字
 * @author Jinghe
 * @date 2021-05-28 0:49
 */

public class SortTest {

    public static void main(String[] args) {
        int[] a = {3,8,6,1,2,5,7,4,9,0};
        insertSort(a);
        printArr(a);

        int[] b = {3,8,6,1,2,5,7,4,9,0};
        insertSortWhile(b);
        printArr(b);

        int[] c = {3,8,6,1,2,5,7,4,9,0};
        selectSort(c);
        printArr(c);

        int[] d = {3,8,6,1,2,5,7,4,9,0};
        bubbleSort(d);
        printArr(d);
    }

    /**
     * 插入排序
     * 思想：前面N个都是已经排好序，只需要把当前i节点的数
     * 插入到已经排好序的0 - j(也就是i-1)的序列中即可。
     * @param a 数组
     */
    public static void insertSort(int[] a) {
        int length = getLength(a);
        for (int i = 1; i < length; i++) {
            int current = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (current < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = current;
        }
    }

    /**
     * 插入排序while版本
     * @param a 数组
     */
    public static void insertSortWhile(int[] a) {
        int length = getLength(a);
        for (int i = 1; i < length; i++) {
            int current = a[i];
            int j = i - 1;
            while (j >= 0 && current < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = current;
        }
    }

    /**
     * 选择排序
     * 思想：每次从i - length-1的区间中找出最小元素和i进行交换 循环length次即可
     * @param a 数组
     */
    public static void selectSort(int[] a) {
        int length = getLength(a);
        for (int i = 0; i < length - 1; i++) {
            int min = a[i];
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    index = j;
                }
            }
            if (index != i) {
                swap(a, i, index);
            }
        }
    }

    /**
     * 冒泡排序
     * 思想：从i - length区间 i和i+1的元素比较，大的元素放到后面，因此
     * 外层每次循环可以完成把最大的数放到最末尾。
     * @param a 数组
     */
    public static void bubbleSort(int[] a) {
        int length = getLength(a);
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j+1);
                }
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    public static int getLength(int[] a) {
        return a.length;
    }

    private static void printArr(int[] a) {
        for (int num : a) {
            System.out.println();
            System.out.print(num + " ");
        }
    }
}
