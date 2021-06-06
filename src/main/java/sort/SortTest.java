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

        int[] f = {3,8,6,1,2,5,7,4,9};
        shellSort(f);
        printArr(f);
        int[] g = {3,8,6,1,2,5,7,4,9,0};
        quickSort(g);
        printArr(g);

        int[] h = {3,8,6,1,2,5,7,4,9,0};
        mergeSort(h, 0, h.length-1);
        printArr(h);
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

    /**
     * 希尔排序
     * 思路：把数组分为length/2 = d组
     * d组成d组的元素执行插入排序(相当于把插入排序的1换成了N)
     * 重复上述过程，直到N=1。(其实N=1就是执行完全的插入排序)
     * @param a 数组
     */
    public static void shellSort(int[] a) {
        int length = getLength(a);
        int d = length;
        while (d > 0) {
            d = d / 2;
            //分数数量遍历
            for (int i = 0; i < d; i++) {
                //当前分组内的数据进行插入排序
                for (int j = i + d; j < length; j += d) {
                    int k = j - d; //j为有序序列最后一位的位数
                    int temp = a[j];
                    //区间内插入排序
                    for (; k >= 0 && temp < a[k]; k -= d) {
                        a[k + d] = a[k];
                    }
                    a[k + d] = temp;
                }
            }
        }
    }

    /**
     * 快速排序
     * 思想：以最左边的元素为基准，把大于最左边的元素都放到右边，
     * 小于最左元素放到左边，然后递归进行，当start 和 end 相等 则排序完成
     * @param a 数组
     */
    public static void quickSort(int[] a) {
        int length = getLength(a);
        quickSort(a, 0, length - 1);
    }

    public static void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int temp = a[start];
            int i = start;
            int j = end;
            while (i < j) {
                while (a[i] < temp && i < j) {
                    i++;
                }
                while (a[j] > temp && j > i) {
                    j--;
                }
                if (i < j) {
                    swap(a, i, j);
                }
            }

            quickSort(a, start, j-1);
            quickSort(a, j+1, end);
        }
    }

    /**
     * 归并排序
     * 思想 数据一分为二 对分割的数递归划分，当数组长度为1时，就已经时排好序的，
     * 这时候只要和划分的另外一个数据合并，递归执行
     * @param a 数据
     * @param start 开始下标
     * @param end 结束下标
     */
    public static void mergeSort(int[] a, int start, int end) {

        int mid = (start + end) / 2;
        if (start < end) {
            //分组
            mergeSort(a, start, mid);
            mergeSort(a, mid+1, end);
            //合并
            merge(a, start, mid, end);
        }

    }

    public static void merge(int[] a, int start, int mid, int end) {
        //存放当前需要合并的元素
        int temp[] = new int[end - start + 1];
        int i = start;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= end) {
            temp[k++] = a[j++];
        }
        //排好序的重新放回a中
        for (int m = 0; m < temp.length; m++) {
            a[m + start] = temp[m];
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
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
