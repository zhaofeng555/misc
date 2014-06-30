package hjg.sort;

import hjg.mianshi.Utils;

public class ExchangeSort {
	 
    // 冒泡
    public static void bubbleSort(int[] array) {
        int length = array.length;
        int temp;
        boolean isSort;
        for (int i = 1; i < length; i++) {
            isSort = false;
            for (int j = 0; j < length - i; j++) {
                if (array[j] > array[j + 1]) {
                    // 交换
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSort = true;
                }
            }
            if (!isSort)
                break; // 如果没有发生交换，则退出循环
        }
    }
 
    public static int getMiddle(int[] arr, int low, int high) {
        if (low < high) {
            int tmp = arr[low]; // 数组的第一个作为中轴
            while (low < high && arr[high] > tmp) {
                high--;
            }
            arr[low] = arr[high]; // 比中轴小的记录移到低端
            while (low < high && arr[low] < tmp) {
                low++;
            }
            arr[high] = arr[low]; // 比中轴大的记录移到高端
            arr[low] = tmp; // 中轴记录到尾
        }
        return low; // 返回中轴的位置
    }
     
    public static int getMiddle2(int[] arr, int low, int high) {
        int tmp = arr[low]; // 数组的第一个作为中轴
        while (low < high) {
            while (low < high && arr[high] > tmp) {
                high--;
            }
            arr[low] = arr[high]; // 比中轴小的记录移到低端
            while (low < high && arr[low] < tmp) {
                low++;
            }
            arr[high] = arr[low]; // 比中轴大的记录移到高端
        }
        arr[low] = tmp; // 中轴记录到尾
        return low; // 返回中轴的位置
    }
 
    //快速排序
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = getMiddle(arr, low, high); // 将arr数组进行一分为二
            quickSort(arr, low, middle - 1); // 对低字表进行递归排序
            quickSort(arr, middle + 1, high); // 对高字表进行递归排序
        }
    }
 
    public static void main(String[] args) {
        quickSortTest();
        bubbleSortTest();
    }
 
    private static void quickSortTest() {
        int[] sortArray = { 5, 2, 4, 1, 3 };
        Utils.printArray("快速排序前: ",sortArray);
        
        quickSort(sortArray, 0, sortArray.length - 1);
        Utils.printArray("快速排序后: ",sortArray);
    }
 
    private static void bubbleSortTest() {
        int[] sortArray = { 5, 2, 4, 1, 3 };
        Utils.printArray("冒泡排序前: ",sortArray);
 
        bubbleSort(sortArray);
        Utils.printArray("冒泡排序后: ",sortArray);
    }
}
