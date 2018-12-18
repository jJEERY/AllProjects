package mergesort;

import insertsort.InsertSort;

/**
 * 归并算法实现
 * @author wuxincheng
 */
public class MergeSort {
    /**
     * 归并算法实现
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    /**
     * 归并递归算法
     * @param array
     * @param low
     * @param high
     */
    private static void sort(int[] array, int low, int high) {
        /**
         * 当低于某个数值时，使用插入排序
         * 小优化，此段代码可注销
         */
        int ten = 10;
        if (low + ten > high) {
            InsertSort.insertionSort(array);
            return;
        }
        if (low >= high) {
            return;
        }
        int mid = low + ((high - low) >> 1);
        sort(array, low, mid);
        sort(array, mid + 1, high);
        //当左右已经有序，不进行合并操作，避免不必要的合并
        if (array[mid] <= array[mid + 1]) {
            return;
        }
        merge(array, low, mid, high);
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    /**
     * 归并核心算法，将排好序的两个部分进行合并
     * @param array
     * @param low
     * @param mid
     * @param high
     */
    private static void merge(int []array, int low, int mid ,int high) {
        int []temp = new int[array.length];
        int k = low;
        int rl = low;
        int rh = mid + 1;
        while (rl <= mid && rh <= high) {
            if (array[rl] <= array[rh]) {
                temp[k ++] = array[rl++];
            } else {
                temp[k ++] = array[rh ++];
            }
        }
        while (rl <= mid) {
            temp[k ++] = array[rl ++];
        }
        while (rh <= high) {
            temp[k ++] = array[rh ++];
        }
        while (low <= high) {
            array[low] = temp[low];
            low ++;
        }
    }
}
