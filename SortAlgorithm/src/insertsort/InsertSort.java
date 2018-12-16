package insertsort;

/**
 * 实现插入排序算法
 * @author wuxincheng
 */
public class InsertSort {
    /**
     * 直接插入排序
     * @param array
     * @return
     */
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

    /**
     * 希尔排序，在直接插入排序上的改进
     * @param array
     * @return
     */
    public static int[] shellSort(int []array) {
        if (array == null || array.length <= 0) {
            return null;
        }
        int len = array.length;
        int temp;
        //设置增量
        int incrementNum = len;
        while (incrementNum != 1) {
            incrementNum = incrementNum / 2;
            for (int i = 0; i < incrementNum; i ++) {
                for (int j = i + incrementNum; j < len; j = j + incrementNum) {
                    temp = array[j];
                    int k;
                    for (k = j - incrementNum; k >= 0; k = k - incrementNum) {
                        if (array[k] > temp) {
                            array[k + incrementNum] = array[k];
                        } else {
                            break;
                        }
                    }

                    array[k + incrementNum] = temp;
                }
            }
        }
        return array;
    }
}
