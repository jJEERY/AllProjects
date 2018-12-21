package choosesort;

/**
 * 实现选择排序算法
 * @author wuxincheng
 */
public class ChooseSort {
    /**
     * 选择排序，从小到大排序
     * @param array
     * @return
     */
    public static int[] chooseSort(int[] array) {
        if (array == null || array.length < 0) {
            return null;
        }
        int len = array.length;
        for (int i = 0; i < len; i ++) {
            //将当前值设定为最小值
            int temp = array[i];
            int flag = i;
            for (int j = i + 1; j < len; j ++) {
                //记录最小值，以及最小值的下标
                if (temp > array[j]) {
                    temp = array[j];
                    flag = j;
                }
            }
            //i记录的值不为最小值，时，与最小值交换
            if (flag != i) {
                array[flag] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }
}
