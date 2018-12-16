package insertsort;

/**
 * 实现插入排序算法
 * @author wuxincheng
 */
public class InsertSort {
    public static int[] insertionSort(int []array) {
        if (array == null || array.length <= 0) {
            return null;
        }
        int len = array.length;
        for (int i = 1; i < len; ++ i) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (array[j] > value) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
            for (int x : array) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        return array;
    }
}
