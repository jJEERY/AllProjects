package quicksort;

import insertsort.InsertSort;

/**
 * 快速排序算法
 * @author wuxincheng
 */
public class QuickSort {

    /**
     * 对外接口，调用内部方法进行快速排序算法
     * @param array
     * @return
     */
    public static int[] quickSort(int []array) {
        quick(array, 0, array.length - 1);
        return array;
    }

    /**
     * 递归实现快速排序
     * @param array
     * @param low
     * @param high
     */
    private static void quick(int[] array, int low, int high) {

        if (low < high) {
            int par = partition(array, low, high);
            quick(array, low, par - 1);
            quick(array, par + 1, high);
        }
    }

    /**
     * 快排核心，查找标签的位置
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] array, int low, int high) {
        int temp = selectMiddle(array, low, high);
        while (low < high) {
            while (low < high && array[high] >= temp) {
                -- high;
            }
            array[low] = array[high];
            while (low < high && array[low] <= temp) {
                ++ low;
            }
            array[high] = array[low];
        }
        array[low] = temp;
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
        return low;
    }

    /**
     * 三者取中法对快排进行优化
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int selectMiddle(int[] array, int low, int high) {
        int mid = low + ((high - low) >> 1);
        if (array[mid] > array[high]) {
            swap(array[mid], array[high]);
        }
        if (array[low] > array[high]) {
            swap(array[low], array[high]);
        }
        if (array[low] < array[mid]) {
            swap(array[low], array[mid]);
        }
        //可得到array[mid]< array[low] < array[high]
        return array[low];
    }

    /**
     * 交换两者值
     * @param a
     * @param b
     */
    private static void swap(int a, int b) {
        int t = a;
        a = b;
        b = t;
    }
}
