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
        Arrays.sort(array);
        return array;
    }
}
