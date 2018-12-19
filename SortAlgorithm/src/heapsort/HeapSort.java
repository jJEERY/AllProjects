package heapsort;

import java.util.regex.Pattern;

/**
 * 堆排序
 * @author wuxincheng
 */
public class HeapSort {
    /**
     * 堆排序对外接口
     * @param array
     * @return
     */
    public static int[] heapSort (int[] array) {
        if (array == null || array.length <= 0) {
            return null;
        }
        int len = array.length;
        //第一次生成堆
        for (int i = len >> 1; i >= 0; i --) {
            arrayHeap(array, i, len);
        }
        //循环，将最大
        for (int i = len - 1; i > 0; i --) {
            swap(array, 0, i);
            arrayHeap(array, 0, i);
        }

        return array;
    }

    /**
     * 核心算法，比较父节点与子节点，将最大的数保存到父节点
     * @param array
     * @param current
     * @param len
     */
    private static void arrayHeap(int[] array, int current, int len) {
        int child;
        int father;
        for (father = array[current]; leftChild(current) < len; current = child) {
            child = leftChild(current);
            if (child != len - 1&& array[child] < array[child + 1]) {
                child ++;
            }
            if (father < array[child]) {
                array[current] = array[child];
            } else {
                break;
            }
        }
        array[current] = father;
    }

    /**
     * 交换两者值
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int []array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    /**
     * 返回左孩子的下标
     * 由于是从0开始存储的，因此为父节点下标的2倍加1
     * @param i
     * @return
     */
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

}