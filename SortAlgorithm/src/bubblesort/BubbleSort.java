package bubblesort;

/**
 * 实现冒泡排序算法
 * @author wuxincheng
 */
public class BubbleSort {
    /**
     * 从小到大排序 未优化
     * @param array 数组
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i ++) {
            for (int j = 0; j < len - i - 1; j ++) {
                //当当前值比后面的值大时，交换值
                if (array[j] > array[j + 1]) {
                    //交换值操作
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
        return array;
    }

    /**
     * 从小到大排序，当某趟遍历数组过程中发现没有进行任何比较时，可以判断此时数组已经达到有序状态，
     * 不需要再进行后续遍历
     * @param array
     * @return
     */
    public static int[] bubbleSortOptimize1(int[] array) {
        //表示本趟遍历没有进行比较操作
        boolean flag = false;
        int len = array.length;
        for (int i = 0; i < len - 1; i ++) {
            flag = false;
            for (int j = 0; j < len - i - 1; j ++) {
                //交换值
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                    //交换了则将flag设置为true，表示有交换操作
                    flag = true;
                }
            }
            if (flag == false) {
                //没有交换操作，则退出循环，后续不用进行比较
                break;
            }
        }
        return array;
    }

    /**
     * 从小到大排序，找到每趟交换时的最大数的位置，可以知道只需要排序这个数前面的所有数即可
     * 如前面100个数为乱序，后面900个数为有序，第一次遍历找到最大交换数下标99后，后续只需排序前面99个数即可
     * @param array
     * @return
     */
    public static int[] bubbleSortOptimize2(int[] array) {
        int len = array.length;
        //第一趟遍历，应该将值默认为长度
        int flag = len, k;
        while (flag > 0) {
            k = flag;
            flag = 0;
            for (int j = 0; j < k - 1; j ++) {
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                    //记录最新的尾边界
                    flag = j + 1;
                }
            }
        }
        return array;
    }
}
