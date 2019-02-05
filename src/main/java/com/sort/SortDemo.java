package com.sort;

/**
 * @author dongyl
 * @date 14:00 1/30/19
 * @project study-demo
 */
public class SortDemo {

    /**
     * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
     * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     *
     * @param array
     * @return
     */
    private static int[] insertSort(int[] array) {
        int len = array.length;
        int preIndex;
        int current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = array[i];
            while (preIndex >= 0 && array[preIndex] > current) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    private int[] shellSort(int[] arr) {
        int len = arr.length;
        int temp;
        int gap = 1;
        // 动态定义间隔序列
        while (gap < len / 3) {
            gap = gap * 3 + 1;
        }
        for (; gap > 0; gap = gap / 3) {
            for (int i = gap; i < len; i++) {
                temp = arr[i];
                for (int j = i - gap; j > 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[i + gap] = temp;

            }
        }
        return arr;
    }

    /**
     * 归并排序是一种稳定的排序方法。和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，
     * 因为始终都是O(nlogn）的时间复杂度。代价是需要额外的内存空间。
     */
    void mergeSort(int a[], int first, int mid, int last, int temp[]) {
        int i = first, j = mid + 1;
        int m = mid, n = last;
        int k = 0;

        while (i <= m && j <= n) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= m) {
            temp[k++] = a[i++];
        }
        while (j <= n) {
            temp[k++] = a[j++];
        }
        for (i = 0; i < k; i++) {
            a[first + i] = temp[i];
        }
    }

    void mergeSort(int a[], int first, int last, int temp[]) {
        if (first < last) {
            int mid = (first + last) / 2;
            //左边有序
            mergeSort(a, first, mid, temp);
            //右边有序
            mergeSort(a, mid + 1, last, temp);
            //再将二个有序数列合并
            mergeSort(a, first, mid, last, temp);
        }
    }

    /**
     * 6、快速排序（Quick Sort）
     * <p>
     * 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
     * <p>
     * 6.1 算法描述
     * <p>
     * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
     * <p>
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     */
//    private int[] quickSort(int[] arr, int left, int right) {
//        int len = arr.length;
//        int partitionIndex;
//        int left =  left != 'number' ? 0 : left;
//        int right = right != 'number' ? len - 1 : right;
//        return arr;
//    }

    void shellSort(int a[], int n) {
        //d为增量
        int d, i, j, temp;
        //增量递减到1使完成排序
        for (d = n / 2; d >= 1; d = d / 2) {
            //插入排序的一轮
            for (i = d; i < n; i++) {
                temp = a[i];
                for (j = i - d; (j >= 0) && (a[j] > temp); j = j - d) {
                    a[j + d] = a[j];
                }
                a[j + d] = temp;
            }
        }
    }

    private static int[] countingSort(int[] arr, int maxValue) {
        int[] bucket = new int[maxValue + 1];
        int sortedIndex = 0;
        int arrLen = arr.length;
        int bucketLen = maxValue + 1;
        for (int i = 0; i < arrLen; i++) {
            bucket[arr[i]]++;
        }
        for (int i = 0; i < bucketLen; i++) {
            while (bucket[i] > 0) {
                arr[sortedIndex++] = i;
                bucket[i]--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 2, 2, 1, 1, 3};
        arr = countingSort(arr, 4);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
