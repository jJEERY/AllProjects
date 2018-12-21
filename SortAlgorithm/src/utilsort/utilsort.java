package utilsort;

import java.util.Arrays;

/**
 * java已使用可以直接调用的工具类排序方法
 * @author wuxincheng
 */
public class utilsort {
    /**
     * 使用Arrays类进行排序
     * @param array
     * @return
     */
    public static int[] arraysSort(int[] array) {
        /**
         *
         * 采用了TimSort排序算法，是对归并算法的一种优化算法，最差的时间复杂度为O(nlogn)，稳定，但是需要利用额外空间
         */
        Arrays.sort(array);
        return array;
    }
}
